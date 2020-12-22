package com.example.carsales.service.impl;

import com.example.carsales.dao.CarDao;
import com.example.carsales.entity.Car;
import com.example.carsales.service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;

    @Override
    public Car addCar(Car car) {
        return carDao.save(car);
    }

    @Override
    public List<Car> getCarList() {
        return carDao.findAll();
    }

    @Override
    public void deleteCar(Long id) {
        carDao.deleteById(id);
    }

    @Override
    public Car getCarById(Long id) {
        return carDao.findById(id).orElse(null);
    }

    @Override
    public Car editCar(Car car) {
        Car carDb = carDao.findById(car.getId()).orElse(null);
        if (carDb == null) {
            return null;
        }
        BeanUtils.copyProperties(car, carDb);
        return carDao.save(carDb);
    }
}
