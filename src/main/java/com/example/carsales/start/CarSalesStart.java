package com.example.carsales.start;

import com.example.carsales.dao.UserDao;
import com.example.carsales.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CarSalesStart implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    UserDao userDao;

    public void init() {
        User admin = userDao.findUserByUsername("admin");
        if (admin == null) {
            admin = new User();
            admin.setName("管理员");
            admin.setUsername("admin");
            admin.setPassword("admin");
            userDao.save(admin);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }
}
