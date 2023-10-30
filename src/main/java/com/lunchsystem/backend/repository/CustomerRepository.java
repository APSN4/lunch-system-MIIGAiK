package com.lunchsystem.backend.repository;

import com.lunchsystem.backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByOrderNumber(Integer orderNumber);
}
