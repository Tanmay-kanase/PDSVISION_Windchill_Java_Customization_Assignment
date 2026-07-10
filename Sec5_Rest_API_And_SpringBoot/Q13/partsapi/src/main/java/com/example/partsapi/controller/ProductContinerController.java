package com.example.partsapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.partsapi.model.ProductContainer;
import com.example.partsapi.service.ProductContainerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product-containers")
@Validated
public class ProductContinerController {

    @Autowired
    private ProductContainerService productContainerService;

    @PostMapping
    public ResponseEntity<Map<String, String>> createContainer(@Valid @RequestBody ProductContainer productContainer) {
        Map<String, String> res = new HashMap<>();
        ProductContainer pd = productContainerService.createContainer(productContainer);
        res.put("message", "Product continer created sucessfully");
        res.put("continerCode", pd.getContainerCode());
        res.put("status", "CREATED");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
