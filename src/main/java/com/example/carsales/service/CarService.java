package com.example.carsales.service;

import com.example.carsales.entity.Car;

import java.util.List;

public interface CarService {
    /**
     * 新增汽车记录
     */
    Car addCar(Car car);

    /**
     * 查询汽车列表
     */
    List<Car> getCarList();

    /**
     * 删除汽车记录
     */
    void deleteCar(Long id);

    /**
     * 通过id查询汽车
     */
    Car getCarById(Long id);

    /**
     * 更新汽车记录
     */
    Car editCar(Car car);
}
