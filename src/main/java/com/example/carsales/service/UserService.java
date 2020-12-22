package com.example.carsales.service;

import com.example.carsales.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    /**
     * 添加系统用户记录
     */
    String addUser(User user);

    /**
     * 查询系统用户列表
     */
    List<User> getUserList();

    /**
     * 通过id查询系统用户记录
     */
    User getUserById(Long id);

    /**
     * 删除系统用户记录
     */
    void deleteUserById(Long id);

    /**
     * 修改系统用户信息
     */
    User editUser(User user);

    /**
     * 修改自己的信息
     */
    User editMyInfo(User user, HttpServletRequest request);
}
