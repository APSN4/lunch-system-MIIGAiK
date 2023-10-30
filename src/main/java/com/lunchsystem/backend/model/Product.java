package com.lunchsystem.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product")
public class Product {

    public Product() {}

    public Product(Integer id_category, String title, String description, Integer sumMoney) {
        this.id_category = id_category;
        this.title = title;
        this.description = description;
        this.sumMoney = sumMoney;
        this.isVisible = true;
        this.isClickable = true;
        this.createdAt = LocalDateTime.now();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_category")
    private Integer id_category;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "photo_link")
    private String photoLink;

    @Column(name = "sum_money")
    private Integer sumMoney;

    @Column(name = "is_visible")
    private Boolean isVisible;

    @Column(name = "is_clickable")
    private Boolean isClickable;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
