package com.example.carsales.service.impl;

import com.example.carsales.dao.CarBrandDao;
import com.example.carsales.entity.CarBrand;
import com.example.carsales.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandServiceImpl implements CarBrandService {
    @Autowired
    CarBrandDao carBrandDao;

    @Override
    public List<CarBrand> getCarBrandList() {
        return carBrandDao.findAll();
    }
}
