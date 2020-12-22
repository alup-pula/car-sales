package com.example.carsales.dao;

import com.example.carsales.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseDao extends JpaRepository<Warehouse, Long> {
}
