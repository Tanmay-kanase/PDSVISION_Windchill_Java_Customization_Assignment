package com.example.partsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.partsapi.model.Part;

public interface PartRepository extends JpaRepository<Part, String> {

}
