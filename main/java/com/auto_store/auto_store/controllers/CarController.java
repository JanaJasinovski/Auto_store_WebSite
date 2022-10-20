package com.auto_store.auto_store.controllers;

import com.auto_store.auto_store.repository.CarRepository;
import com.auto_store.auto_store.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final ObjectMapper objectMapper;
    private final CarRepository carRepository;

    @GetMapping("/cars")
    public ResponseEntity<List<?>> getListCars() {
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }
}
