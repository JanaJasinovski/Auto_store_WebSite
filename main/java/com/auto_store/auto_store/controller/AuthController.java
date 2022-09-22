package com.auto_store.auto_store.controller;

import com.auto_store.auto_store.dto.UserDTO;
import com.auto_store.auto_store.enums.ERole;
import com.auto_store.auto_store.exception.TokenRefreshException;
import com.auto_store.auto_store.model.RefreshToken;
import com.auto_store.auto_store.model.Role;
import com.auto_store.auto_store.model.User;
import com.auto_store.auto_store.payload.JwtResponse;
import com.auto_store.auto_store.payload.RefreshTokenRequest;
import com.auto_store.auto_store.payload.TokenRefreshResponse;
import com.auto_store.auto_store.repository.UserRepository;
import com.auto_store.auto_store.security.CustomUserDetails;
import com.auto_store.auto_store.security.jwt.JwtUtils;
import com.auto_store.auto_store.security.service.RefreshTokenService;
import com.auto_store.auto_store.security.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/auth")
@Tag(name = "Authentication controller", description = "points for registration or login in the system")
public class AuthController {

    private final UserRepository userRepo;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final ObjectMapper objectMapper;
    private final RefreshTokenService refreshTokenService;

    @Operation(
            summary = "Registration in the system"
    )
    @PostMapping(value = "/signup")
    public ResponseEntity<?> registerUser(@RequestParam(name = "user") String userJson,
                                          @RequestParam("avatar") MultipartFile image
    ) throws IOException {

        UserDTO signupRequest = objectMapper.readValue(userJson, UserDTO.class);

        if (userRepo.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        User user = new User(signupRequest.getFirstName(), signupRequest.getLastName(),
                signupRequest.getEmail(), signupRequest.getPassword(), signupRequest.getAddresses());

        user.setRole(new Role(ERole.ROLE_USER));
        user.setAvatar(image.getBytes());

        userService.saveUser(user);

        log.info("user {} registering to the system", user.getEmail());
        return ResponseEntity.ok("User registered successfully!");
    }


    @Operation(
            summary = "Login to the system"
    )
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        if (authentication != null) {

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authentication.getName());

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), authentication.getName(), roles, refreshToken.getExpiryDate()));

        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }

    }

    @Operation(
            summary = "Get new access token by refresh token"
    )
    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody RefreshTokenRequest request) {
        String requestRefreshToken = request.getRefreshToken();
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getEmail());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }
}