package com.example.carsales.service.impl;

import com.example.carsales.dao.CarDao;
import com.example.carsales.dao.CarSellDao;
import com.example.carsales.dao.CustomerDao;
import com.example.carsales.entity.Car;
import com.example.carsales.entity.CarSell;
import com.example.carsales.entity.Customer;
import com.example.carsales.service.CarSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarSellServiceImpl implements CarSellService {
    @Autowired
    CarSellDao carSellDao;
    @Autowired
    CarDao carDao;
    @Autowired
    CustomerDao customerDao;

    @Override
    public String addCarSell(CarSell carSell) {
        Car car = carDao.findById(carSell.getCarId()).orElse(null);
        if (null == car) {
            return "该汽车不存在";
        }
        if (car.getInventory() < carSell.getNumber()) {
            return "库存不足";
        }
        Customer customer = customerDao.findById(carSell.getCustomerId()).orElse(null);
        if (customer == null) {
            return "客户不存在";
        }
        car.setInventory(car.getInventory() - carSell.getNumber());
        carSell.setCarName(car.getName());
        carSell.setCustomerName(customer.getName());
        carDao.save(car);
        carSellDao.save(carSell);
        return "保存成功";
    }

    @Override
    public List<CarSell> getCarSellList() {
        return carSellDao.findAll();
    }
}
