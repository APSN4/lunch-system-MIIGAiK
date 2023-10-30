package com.lunchsystem.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "category")
public class Category {

    public Category(){}

    public Category(String title) {
        this.title = title;
        this.products = new ArrayList<>();
        this.isVisible = true;
        this.isClickable = true;
        this.createdAt = LocalDateTime.now();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "products")
    private ArrayList<String> products;

    @Column(name = "is_visible")
    private Boolean isVisible;

    @Column(name = "is_clickable")
    private Boolean isClickable;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
