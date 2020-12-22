package com.example.carsales.controller;

import com.example.carsales.entity.Warehouse;
import com.example.carsales.service.CarService;
import com.example.carsales.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    CarService carService;

    @GetMapping("/toWarehouseStatistics")
    public String toWarehouseStatistics(Model model) {
        model.addAttribute("warehouseVos", warehouseService.getWarehouseVoList());
        return "/warehouseStatistics";
    }

    @GetMapping("toAddWarehouse")
    public String toAddWarehouse(Model model) {
        model.addAttribute("cars", carService.getCarList());
        return "/addWarehouse";
    }

    @PostMapping("/addWarehouse")
    public String addWarehouse(Warehouse warehouse, Model model) {
        String msg = warehouseService.addWarehouse(warehouse);
        model.addAttribute("cars", carService.getCarList());
        model.addAttribute("msg", msg);
        return "/addWarehouse";
    }
}
