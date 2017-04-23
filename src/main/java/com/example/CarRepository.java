package com.example;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository extends CrudRepository<CarEntity, Integer> {

    Optional<CarEntity> findById( int id);
}
