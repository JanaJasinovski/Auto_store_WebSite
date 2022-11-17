package com.auto_store.auto_store.controllers;

import com.auto_store.auto_store.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mark")
public class MarkController {

    private final MarkService markService;

    @GetMapping("/marks")
    public ResponseEntity<List<?>> getListCars() {
        return new ResponseEntity<>(markService.findAll(), HttpStatus.OK);
    }
}
