package com.example.carsales.dao;

import com.example.carsales.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    /**
     * 通过用户名和密码查找用户
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 通过用户名查找用户
     */
    User findUserByUsername(String username);

    /**
     * 查询系统户列表，不包括系统管理员
     */
    List<User> findUserByIdNot(Long id);
}
