package com.tausif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tausif.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
