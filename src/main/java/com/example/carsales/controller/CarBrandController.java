package com.example.carsales.controller;

import com.example.carsales.dao.CarBrandDao;
import com.example.carsales.entity.CarBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarBrandController {
    @Autowired
    CarBrandDao carBrandDao;

    @GetMapping("/toCarBrandManage")
    public String toCarBrandManager(Model model) {
        List<CarBrand> carBrands = carBrandDao.findAll();
        model.addAttribute("carBrands", carBrands);
        return "carBrandManage";
    }

    @GetMapping("/toAddCarBrand")
    public String toAddCarBrand() {
        return "addCarBrand";
    }

    @PostMapping("/addCarBrand")
    public String addCarBrand(CarBrand carBrand, Model model) {
        carBrandDao.save(carBrand);
        model.addAttribute("msg", "保存成功");
        return "addCarBrand";
    }

    @GetMapping("/delCarBrand/{id}")
    public String delCarBrand(@PathVariable("id") Long id) {
        carBrandDao.deleteById(id);
        return "redirect:/toCarBrandManage";
    }
}
