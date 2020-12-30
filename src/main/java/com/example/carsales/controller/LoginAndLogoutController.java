package com.example.carsales.controller;

import com.example.carsales.dao.UserDao;
import com.example.carsales.entity.User;
import com.example.carsales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller("/user")
public class LoginAndLogoutController {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    @GetMapping({"/", "/index"})
    public String toIndex() {
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        //跳转到登录页面
        return "login";
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public String login(User user, Model model, HttpServletRequest request) {
        User u = userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (null != u) {
            HttpSession session = request.getSession();
            session.setAttribute("name", u.getName());
            session.setAttribute("uid", u.getId());
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

    /**
     * 登出
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.setAttribute("name", null);
        request.setAttribute("uid", null);
        return "redirect:/toLogin";
    }

}
