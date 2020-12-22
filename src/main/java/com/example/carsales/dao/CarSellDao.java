package com.example.carsales.dao;

import com.example.carsales.entity.CarSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarSellDao extends JpaRepository<CarSell, Long> {
}
