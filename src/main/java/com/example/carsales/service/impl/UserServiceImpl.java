package com.example.carsales.service.impl;

import com.example.carsales.dao.UserDao;
import com.example.carsales.entity.User;
import com.example.carsales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public String addUser(User user) {
        User userDb = userDao.findUserByUsername(user.getUsername());
        if (userDb == null) {
            userDao.save(user);
            return "保存成功";
        }
        return "用户名已存在";
    }

    @Override
    public List<User> getUserList() {
        return userDao.findUserByIdNot(1L);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(Long id) {
        User userDb = userDao.findById(id).orElse(null);
        if (userDb != null && userDb.getId() == 1L) {
            return;
        }
        userDao.deleteById(id);
    }

    @Override
    public User editUser(User user) {
        User userDb = userDao.findById(user.getId()).orElse(null);
        if (null != userDb) {
            userDb.setName(user.getName());
            userDb.setPassword(user.getPassword());
            userDao.save(userDb);
            return userDb;
        }
        return null;
    }

    @Override
    public User editMyInfo(User user, HttpServletRequest request) {
        Long id = (Long) request.getSession().getAttribute("uid");
        if (id.equals(user.getId())) {
            User userDb = userDao.findById(user.getId()).orElse(null);
            if (userDb != null) {
                userDb.setName(user.getName());
                userDb.setPassword(user.getPassword());
                userDao.save(userDb);
                request.getSession().setAttribute("name", userDb.getName());
                return userDb;
            }
        }
        return null;
    }
}
