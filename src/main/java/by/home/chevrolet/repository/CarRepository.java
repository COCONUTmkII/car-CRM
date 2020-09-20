package by.home.chevrolet.repository;

import by.home.chevrolet.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car,Long> {
    Car getCarByModel(String model);
}
