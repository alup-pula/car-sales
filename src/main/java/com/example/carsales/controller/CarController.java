package com.example.carsales.controller;

import com.example.carsales.entity.Car;
import com.example.carsales.service.CarBrandService;
import com.example.carsales.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    CarBrandService carBrandService;

    @GetMapping("/toAddCar")
    public String toAddCar(Model model) {
        model.addAttribute("carBrands", carBrandService.getCarBrandList());
        return "addCar";
    }

    @PostMapping("/addCar")
    public String addCar(Car car, Model model) {
        Car carDb = carService.addCar(car);
        if (carDb == null) {
            model.addAttribute("msg", "保存失败，请重试");
        } else {
            model.addAttribute("msg", "保存成功");
        }
        model.addAttribute("carBrands", carBrandService.getCarBrandList());
        return "addCar";
    }

    @GetMapping("/toCarManage")
    public String toCarManage(Model model) {
        model.addAttribute("cars", carService.getCarList());
        return "carManage";
    }

    @GetMapping("/delCar/{id}")
    public String delCarManage(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return "redirect:/toCarManage";
    }

    @GetMapping("/toEditCar/{id}")
    public String toEditCar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("car", carService.getCarById(id));
        model.addAttribute("carBrands", carBrandService.getCarBrandList());
        return "editCar";
    }

    @PostMapping("/editCar")
    public String editCar(Car car, Model model) {
        Car carDb = carService.editCar(car);
        if (null == carDb) {
            model.addAttribute("msg", "修改失败，请重试");
            model.addAttribute("car", car);
            model.addAttribute("carBrands", carBrandService.getCarBrandList());
            return "editCar";
        }
        model.addAttribute("msg", "修改成功");
        model.addAttribute("car", carDb);
        return "editCar";
    }

    @GetMapping("/inventoryManage")
    public String inventoryManage(Model model) {
        model.addAttribute("cars", carService.getCarList());
        return "inventoryManage";
    }
}
