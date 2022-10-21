package com.auto_store.auto_store.helpers;

import com.auto_store.auto_store.dto.CarDTO;
import com.auto_store.auto_store.model.Car;
import com.auto_store.auto_store.model.Model;
import com.auto_store.auto_store.model.New_Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoConvert {

    private final ModelMapper modelMapper;

    public CarDTO convertCar(Car car, Model model, New_Order new_order) {

        CarDTO carDTO = modelMapper.map(car, CarDTO.class);
        carDTO.setModel_Type(model.getType());
        carDTO.setModel_Generation(model.getGeneration());
        carDTO.setModel_Country(model.getCountry());

        carDTO.setNew_order_orderDate(new_order.getOrderDate());
        carDTO.setNew_order_shipping_date(new_order.getShippingDate());
        carDTO.setNew_order_status(new_order.getOrderStatus());
        carDTO.setNew_order_total(new_order.getOrderTotal());

        return carDTO;
    }

    public CarDTO convertCar(Car car) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        CarDTO carDTO = modelMapper.map(car, CarDTO.class);

        carDTO.setModel_Type(carDTO.getModel_Type());
        carDTO.setModel_Generation(carDTO.getModel_Generation());
        carDTO.setModel_Country(carDTO.getModel_Country());

        carDTO.setNew_order_orderDate(carDTO.getNew_order_orderDate());
        carDTO.setNew_order_shipping_date(carDTO.getNew_order_shipping_date());
        carDTO.setNew_order_status(carDTO.getNew_order_status());
        carDTO.setNew_order_total(carDTO.getNew_order_total());

        return carDTO;
    }
}