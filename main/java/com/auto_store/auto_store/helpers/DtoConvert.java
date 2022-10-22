package com.auto_store.auto_store.helpers;

import com.auto_store.auto_store.dto.CarDTO;
import com.auto_store.auto_store.model.Car;
import com.auto_store.auto_store.model.Model;
import com.auto_store.auto_store.model.NewOrder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class DtoConvert {

    private final ModelMapper modelMapper;

    public CarDTO convertCar(Car car, Model model, NewOrder new_order) {

        CarDTO carDTO = modelMapper.map(car, CarDTO.class);
        carDTO.setModels(Collections.singleton(model));
        carDTO.setNewOrders(Collections.singleton(new_order));

        return carDTO;
    }

    public CarDTO convertCar(Car car) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        CarDTO carDTO = modelMapper.map(car, CarDTO.class);

        carDTO.setModels(carDTO.getModels());
        carDTO.setNewOrders(carDTO.getNewOrders());

        System.out.println(carDTO);
        return carDTO;
    }
}