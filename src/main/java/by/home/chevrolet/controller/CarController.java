package by.home.chevrolet.controller;

import by.home.chevrolet.entity.Car;
import by.home.chevrolet.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarServiceImpl carService;

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/car")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car newCar = carService.addCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.OK);
    }

    @DeleteMapping("/car{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/car{model}")
    public ResponseEntity<Car> getByModel(@PathVariable String model) {
        return new ResponseEntity<>(carService.getByModel(model), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Car> editCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.editCar(car), HttpStatus.OK);
    }
}
