package com.lunchsystem.backend.controller;

import com.lunchsystem.backend.model.Category;
import com.lunchsystem.backend.model.Customer;
import com.lunchsystem.backend.model.Product;
import com.lunchsystem.backend.repository.CategoryRepository;
import com.lunchsystem.backend.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping()
    public ResponseEntity<Object> getAllProducts() {
        JSONArray jsonArray = new JSONArray();
        Optional<List<Product>> productArrayList = Optional.of(productRepository.findAll());
        for (Product product: productArrayList.get()) {
            JSONObject jsonObject = new JSONObject()
                    .put("category_id", product.getCategory_id())
                    .put("title", product.getTitle())
                    .put("description", product.getDescription())
                    .put("photo_link", product.getPhotoLink())
                    .put("sum_money", product.getSumMoney())
                    .put("is_visible", product.getIsVisible())
                    .put("is_clickable", product.getIsClickable())
                    .put("created_at", product.getCreatedAt());
            jsonArray.put(jsonObject);
        }
        return new ResponseEntity<>(jsonArray.toString(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> createNewProduct(@RequestBody createProduct createProduct) {
        Optional<Category> category = categoryRepository.findById(createProduct.getCategory_id());
        if (category.isPresent()) {
            Product product = new Product(category.get(), createProduct.title, createProduct.getDescription(), createProduct.getSum_money());
            Product savedProduct = productRepository.saveAndFlush(product);
            JSONObject jsonObject = new JSONObject()
                    .put("category_id", savedProduct.getCategory_id())
                    .put("title", savedProduct.getTitle())
                    .put("description", savedProduct.getDescription())
                    .put("photo_link", savedProduct.getPhotoLink())
                    .put("sum_money", savedProduct.getSumMoney())
                    .put("is_visible", savedProduct.getIsVisible())
                    .put("is_clickable", savedProduct.getIsClickable())
                    .put("created_at", savedProduct.getCreatedAt());
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(new JSONObject().put("error", "not found").toString(),
                HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<Object> removeProduct(@RequestBody removeProduct removeProduct) {
        productRepository.deleteById(removeProduct.getId());
        return new ResponseEntity<>(new JSONObject().put("response", "successful").toString(), HttpStatus.OK);
    }

    @Data
    public static class createProduct {
        Long category_id;
        String title;
        String description;
        Integer sum_money;
    }

    @Data
    public static class removeProduct {
        Long id;
    }

}
