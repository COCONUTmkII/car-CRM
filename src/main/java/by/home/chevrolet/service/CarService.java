package by.home.chevrolet.service;

import by.home.chevrolet.entity.Car;
import java.util.List;

public interface CarService {
    Car addCar(Car car);
    void delete(Long id);
    Car getByModel(String name);
    Car editCar(Car car);
    List<Car> getAll();
}
