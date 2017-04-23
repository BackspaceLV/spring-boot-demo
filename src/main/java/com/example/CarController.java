package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
public class CarController {

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private CarRepository carRepository;

    @GetMapping("/getAll")
    public Iterable<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @PostMapping("/save")
    public CarEntity addCar(@RequestBody CarEntity entity) {
        return carRepository.save(entity);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam int id) {
        return carRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> notFound().build());
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int id) {
        carRepository.delete(id);
    }
}
