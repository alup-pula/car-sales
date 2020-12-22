package com.example.carsales.service;

import com.example.carsales.entity.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * 获得所有客户
     */
    List<Customer> getCustomerList();

    /**
     * 添加客户
     */
    Customer addCustomer(Customer customer);

    /**
     * 通过id删除客户
     */
    void deleteCustomer(Long id);

    /**
     * 通过id查询客户
     */
    Customer getCustomerById(Long id);

    /**
     * 修改客户
     */
    Customer editCustomer(Customer customer);

}
