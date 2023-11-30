package com.lunchsystem.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product")
public class Product {

    public Product() {}

    public Product(Category category_id, String title, String description, Integer sumMoney) {
        this.category_id = category_id;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category_id;

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
