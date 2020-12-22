package com.example.carsales.service;

import com.example.carsales.entity.CarBrand;

import java.util.List;

public interface CarBrandService {
    /**
     * 查询汽车品牌列表
     */
    List<CarBrand> getCarBrandList();
}
