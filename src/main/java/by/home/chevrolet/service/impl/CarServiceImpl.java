package by.home.chevrolet.service.impl;

import by.home.chevrolet.entity.Car;
import by.home.chevrolet.repository.CarRepository;
import by.home.chevrolet.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car getByModel(String model) {
        return carRepository.getCarByModel(model);
    }

    @Override
    public Car editCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
