package com.auto_store.auto_store.service;

import com.auto_store.auto_store.dto.CarDTO;
import com.auto_store.auto_store.helpers.DtoConvert;
import com.auto_store.auto_store.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {

    private final CarRepository carRepository;
    private final DtoConvert dtoConvert;

    public List<CarDTO> findAll() {
        return carRepository.findAll().stream().map(dtoConvert::convertCar).collect(Collectors.toList());
    }

    public CarDTO getById(Integer id) {
        return dtoConvert.convertCar(carRepository.findById(id).get());
    }

}
