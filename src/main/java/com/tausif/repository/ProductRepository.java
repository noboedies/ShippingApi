package com.tausif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tausif.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
