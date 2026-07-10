package com.example.partsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Table(name = "product_containers")
@Data
public class ProductContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String containerName;

    @Column(nullable = false, unique = true)
    private String containerCode;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    @Email
    private String ownerEmail;
}