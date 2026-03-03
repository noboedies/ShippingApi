package com.tausif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tausif.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
