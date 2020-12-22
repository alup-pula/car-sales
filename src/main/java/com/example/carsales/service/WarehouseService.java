package com.example.carsales.service;

import com.example.carsales.entity.Warehouse;
import com.example.carsales.vo.WarehouseVo;

import java.util.List;

public interface WarehouseService {
    /**
     * 入库统计
     */
    List<WarehouseVo> getWarehouseVoList();

    /**
     * 添加入库记录
     */
    String addWarehouse(Warehouse warehouse);
}
