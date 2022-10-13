package com.auto_store.auto_store.security.service;

import com.auto_store.auto_store.exception.ResourceNotFoundException;
import com.auto_store.auto_store.model.User;
import com.auto_store.auto_store.repository.UserRepository;
import com.auto_store.auto_store.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return CustomUserDetails.build(user);
    }

    public void saveUser(User user) {

        if (user.getPassword() != null) {
            user.setPassword(encoder.encode(user.getPassword()));
        }

        log.info("save user {} to db", user.getEmail());
        userRepository.save(user);
    }

    public boolean logout(String email) {
        return false;
    }

    @Cacheable(value = "Users", key = "#id")
    public User getById(Integer id) {

        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id)
        );
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email);
    }
}