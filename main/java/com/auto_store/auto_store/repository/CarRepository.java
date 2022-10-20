package com.auto_store.auto_store.repository;

import com.auto_store.auto_store.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAll();
}
