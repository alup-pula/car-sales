package com.example.carsales;

import com.example.carsales.dao.UserDao;
import com.example.carsales.entity.User;
import com.example.carsales.service.UserService;
import com.example.carsales.start.CarSalesStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarSalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarSalesApplication.class, args);
    }
}
