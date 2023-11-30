package com.lunchsystem.backend.controller;

import com.lunchsystem.backend.model.Category;
import com.lunchsystem.backend.repository.CategoryRepository;
import com.lunchsystem.backend.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.Data;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public ResponseEntity<Object> createNewCategory(@RequestBody newCategory newCategory) {
        Category category = new Category(newCategory.getTitle());
        Category savedCategory = categoryRepository.saveAndFlush(category);
        JSONObject jsonObject = new JSONObject()
                .put("title", savedCategory.getTitle())
                .put("products_id", savedCategory.getProducts())
                .put("is_visible", savedCategory.getIsVisible())
                .put("is_clickable", savedCategory.getIsClickable())
                .put("created_at", savedCategory.getCreatedAt());
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

    @Data
    public static class newCategory {
        String title;
    }
}
