package com.lunchsystem.backend.model;

import com.lunchsystem.backend.services.OrderNumberGenerator;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    public Customer() {}

    public Customer(ArrayList<Integer> products, Integer sumMoney) {
        this.products = products;
        this.sumMoney = sumMoney;
        this.orderNumber = new OrderNumberGenerator().generateFourDigits();
        this.isCompleted = false;
        this.createdAt = LocalDateTime.now();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "products")
    private ArrayList<Integer> products;

    @Column(name = "sum_money")
    private Integer sumMoney;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
