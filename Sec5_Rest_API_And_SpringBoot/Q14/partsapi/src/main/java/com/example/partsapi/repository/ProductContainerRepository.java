package com.example.partsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.String;
import com.example.partsapi.model.ProductContainer;

public interface ProductContainerRepository extends JpaRepository<ProductContainer, Long> {
    boolean existsByContainerCode(String containerCode);
}
