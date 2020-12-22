package com.example.carsales.entity;

import javax.persistence.*;

/**
 * 汽车销售记录表
 */
@Entity
@Table(name = "car_sell")
public class CarSell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    /**
     * 客户id
     */
    @Column
    private Long customerId;
    /**
     * 客户名称
     */
    @Column
    private String customerName;
    /**
     * 汽车ID
     */
    @Column
    private Long carId;
    /**
     * 汽车名称
     */
    @Column
    private String carName;
    /**
     * 单价
     */
    @Column
    private Double price;
    /**
     * 数量
     */
    @Column
    private Integer number;
    /**
     * 时间
     */
    @Column
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
