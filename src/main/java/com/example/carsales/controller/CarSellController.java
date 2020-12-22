package com.example.carsales.controller;

import com.example.carsales.entity.CarSell;
import com.example.carsales.service.CarSellService;
import com.example.carsales.service.CarService;
import com.example.carsales.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarSellController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CarService carService;
    @Autowired
    CarSellService carSellService;

    @GetMapping("/toAddCarSell")
    public String addCarSell(Model model) {
        model.addAttribute("customers", customerService.getCustomerList());
        model.addAttribute("cars", carService.getCarList());
        return "/addCarSell";
    }

    @PostMapping("/addCarSell")
    public String addCarSell(CarSell carSell, Model model) {
        String msg = carSellService.addCarSell(carSell);
        model.addAttribute("customers", customerService.getCustomerList());
        model.addAttribute("cars", carService.getCarList());
        model.addAttribute("msg", msg);
        return "/addCarSell";
    }

    @GetMapping("/toCarSellStatistics")
    public String toCarSellStatistics(Model model) {
        model.addAttribute("carSells", carSellService.getCarSellList());
        return "/carSellStatistics";
    }
}
