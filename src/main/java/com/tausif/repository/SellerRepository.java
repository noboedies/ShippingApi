package com.tausif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tausif.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
