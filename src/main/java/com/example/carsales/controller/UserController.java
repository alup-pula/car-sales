package com.example.carsales.controller;

import com.example.carsales.dao.UserDao;
import com.example.carsales.entity.User;
import com.example.carsales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    /**
     * 跳转添加系统用户页面
     */
    @GetMapping("/toAddUser")
    public String toAddUser() {
        return "addUser";
    }

    /**
     * 添加用户
     */
    @PostMapping("/addUser")
    public String addUser(User user, Model model) {
        String msg = userService.addUser(user);
        model.addAttribute("msg", msg);
        return "addUser";
    }

    /**
     * 跳转系统用户管理页面
     */
    @GetMapping("/userList")
    public String userList(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "userList";
    }

    /**
     * 删除系统用户
     */
    @GetMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/userList";
    }

    /**
     * 跳转修改用户信息界面
     */
    @GetMapping("/toEditUser/{id}")
    public String toEditUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    /**
     * 修改系统用户信息
     */
    @PostMapping("/editUser")
    public String editUser(User user, Model model) {
        User userDb = userService.editUser(user);
        if (userDb != null) {
            model.addAttribute("user", userDb);
            model.addAttribute("msg", "保存成功");
        } else {
            model.addAttribute("user", user);
            model.addAttribute("msg", "失败");
        }
        return "editUser";
    }

    /**
     * 跳转修改我的信息页面
     */
    @GetMapping("/toEditMyInfo/{id}")
    public String toEditInfo(@PathVariable("id") Long id, Model model) {
        User userDb = userService.getUserById(id);
        model.addAttribute("user", userDb);
        return "editMyInfo";
    }

    /**
     * 修改我的信息
     */
    @PostMapping("/editMyInfo")
    public String editMyInfo(User user, Model model, HttpServletRequest request) {
        User userDb = userService.editMyInfo(user, request);
        if (userDb != null) {
            model.addAttribute("msg", "保存成功");
            model.addAttribute("user", userDb);
        } else {
            model.addAttribute("msg", "保存失败");
            model.addAttribute("user", user);
        }
        return "editMyInfo";
    }
}
