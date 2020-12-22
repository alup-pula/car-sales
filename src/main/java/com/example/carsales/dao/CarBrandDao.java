package com.example.carsales.dao;

import com.example.carsales.entity.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandDao extends JpaRepository<CarBrand, Long> {
}
