package com.example.carsales.entity;

import javax.persistence.*;

/**
 * 汽车表
 */
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    /**
     * 汽车品牌
     */
    @Column
    private String carBrand;
    /**
     * 名字
     */
    @Column
    private String name;
    /**
     * 排量
     */
    @Column
    private String displacement;
    /**
     * 变速箱
     */
    @Column
    private String gearbox;
    /**
     * 汽车尺寸
     */
    @Column
    private String dimension;
    /**
     * 重量
     */
    @Column
    private String weight;
    /**
     * 备注
     */
    @Column
    private String remark;
    /**
     * 库存
     */
    @Column
    private Integer inventory;

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String earbox) {
        this.gearbox = earbox;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
