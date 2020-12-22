package com.example.carsales.controller;

import com.example.carsales.entity.Customer;
import com.example.carsales.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/toCustomerManage")
    public String toCustomerManage(Model model) {
        model.addAttribute("customers", customerService.getCustomerList());
        return "/customerManage";
    }

    @GetMapping("/toAddCustomer")
    public String toAddCustomer() {
        return "/addCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(Customer customer, Model model) {
        Customer cdb = customerService.addCustomer(customer);
        if (cdb != null) {
            model.addAttribute("msg", "保存成功");
        } else {
            model.addAttribute("msg", "保存失败");
        }
        return "/addCustomer";
    }

    @GetMapping("/delCustomer/{id}")
    public String delCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/toCustomerManage";
    }

    @GetMapping("/toEditCustomer/{id}")
    public String toEditCustomer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "/editCustomer";
    }

    @PostMapping("/editCustomer")
    public String editCustomer(Customer customer, Model model) {
        Customer customerDb = customerService.editCustomer(customer);
        if (null == customerDb) {
            model.addAttribute("msg", "修改失败，请重试");
            model.addAttribute("customer", customer);
            return "/editCustomer";
        }
        model.addAttribute("msg", "修改成功");
        model.addAttribute("customer", customerDb);
        return "/editCustomer";
    }
}
