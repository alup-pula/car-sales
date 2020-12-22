package com.example.carsales.service.impl;

import com.example.carsales.dao.CustomerDao;
import com.example.carsales.entity.Customer;
import com.example.carsales.service.CustomerService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public List<Customer> getCustomerList() {
        return customerDao.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDao.deleteById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.findById(id).orElse(null);
    }

    @Override
    public Customer editCustomer(Customer customer) {
        Customer customerDb = customerDao.findById(customer.getId()).orElse(null);
        if (null == customerDb) {
            return null;
        }
        BeanUtils.copyProperties(customer, customerDb);
        customerDao.save(customerDb);
        return customerDb;
    }
}
