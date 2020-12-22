package com.example.carsales.service;

import com.example.carsales.entity.CarSell;

import java.util.List;

public interface CarSellService {
    /**
     * 新增汽车销售记录
     */
    String addCarSell(CarSell carSell);

    /**
     * 查询汽车销售记录列表
     */
    List<CarSell> getCarSellList();
}
