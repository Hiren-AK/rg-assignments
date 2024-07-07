package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo2.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
