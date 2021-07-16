package com.example.carsales.start;

import com.example.carsales.dao.UserDao;
import com.example.carsales.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动完成后执行
 */
@Component
public class CarSalesStart implements ApplicationRunner {
    @Autowired
    UserDao userDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!userDao.findById(1L).isPresent()) {
            User admin = new User();
            admin.setId(1L);
            admin.setName("管理员");
            admin.setUsername("admin");
            admin.setPassword("admin");
            userDao.save(admin);
        }
    }
}
