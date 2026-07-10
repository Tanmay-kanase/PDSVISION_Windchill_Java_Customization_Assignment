package com.example.partsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.partsapi.exception.ResourceNotFound;
import com.example.partsapi.model.ProductContainer;
import com.example.partsapi.repository.ProductContainerRepository;

@Service
public class ProductContainerService {

    @Autowired
    private ProductContainerRepository productContainerRepository;

    public ProductContainer createContainer(ProductContainer productContainer) {

        String region = productContainer.getRegion();

        if (!"APAC".equals(region)
                && !"EMEA".equals(region)
                && !"NATAM".equals(region)
                && !"LATAM".equals(region)) {

            throw new IllegalArgumentException(
                    "Region must be one of: APAC, EMEA, NATAM, LATAM");
        }
        if (productContainerRepository.existsByContainerCode(productContainer.getContainerCode())) {
            throw new IllegalArgumentException(
                    "Container code '" + productContainer.getContainerCode() + "' already exists.");
        }
        return productContainerRepository.save(productContainer);
    }

    public List<ProductContainer> getAllContainer() {
        return productContainerRepository.findAll();
    }

    public void deleteContainer(Long id) {
        productContainerRepository.deleteById(id);
        return;
    }

    public ProductContainer updateContainer(Long id, ProductContainer productContainer) {
        ProductContainer existingConainer = productContainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Cannot find container with " + id));

        existingConainer.setContainerName(productContainer.getCustomerName());
        existingConainer.setCustomerName(productContainer.getCustomerName());
        existingConainer.setRegion(productContainer.getRegion());
        existingConainer.setOwnerEmail(productContainer.getOwnerEmail());
        return productContainerRepository.save(existingConainer);
    }

    public ProductContainer getById(Long id) {
        return productContainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Container not found with container code " + id));
    }
}
