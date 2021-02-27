package com.example.carsales.service.impl;

import com.example.carsales.dao.CarDao;
import com.example.carsales.dao.WarehouseDao;
import com.example.carsales.entity.Car;
import com.example.carsales.entity.Warehouse;
import com.example.carsales.service.WarehouseService;
import com.example.carsales.vo.WarehouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    WarehouseDao warehouseDao;
    @Autowired
    CarDao carDao;

    @Override
    public List<WarehouseVo> getWarehouseVoList() {
        List<Warehouse> warehouses = warehouseDao.findAll();
        Car car;
        List<WarehouseVo> warehouseVos = new ArrayList<>();
        WarehouseVo warehouseVo;
        for (Warehouse warehouse : warehouses) {
            car = carDao.findById(warehouse.getCarId()).orElse(null);
            if (car != null) {
                warehouseVo = new WarehouseVo();
                warehouseVo.setCarBrand(car.getCarBrand());
                warehouseVo.setCarName(car.getName());
                warehouseVo.setNumber(warehouse.getNumber());
                warehouseVo.setPrice(warehouse.getPrice());
                warehouseVo.setTotalAmount(warehouse.getPrice() * warehouse.getNumber());
                warehouseVo.setDate(warehouse.getDate());
                warehouseVos.add(warehouseVo);
            }
        }
        return warehouseVos;
    }

    @Override
    public String addWarehouse(Warehouse warehouse) {
        Car car = carDao.findById(warehouse.getCarId()).orElse(null);
        if (car == null) {
            return "该汽车不存在";
        }
        car.setInventory(car.getInventory() + warehouse.getNumber());
        carDao.save(car);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        warehouse.setDate(df.format(new Date()));
        warehouseDao.save(warehouse);
        return "保存成功";
    }
}
