package com.lunchsystem.backend.repository;

import com.lunchsystem.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
