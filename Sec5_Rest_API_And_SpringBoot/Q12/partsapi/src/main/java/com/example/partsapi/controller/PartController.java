package com.example.partsapi.controller;

import com.example.partsapi.model.Part;
import com.example.partsapi.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/parts")
public class PartController {

    @Autowired
    private PartService partService;

    // GET /parts
    @GetMapping
    public ResponseEntity<List<Part>> getAllParts() {
        return ResponseEntity.ok(partService.getAllParts());
    }

    // GET /parts/{partNumber}
    @GetMapping("/{partNumber}")
    public ResponseEntity<Part> getPartByNumber(@PathVariable String partNumber) {
        return ResponseEntity.ok(partService.getPartByNumber(partNumber));
    }

    // POST /parts
    @PostMapping
    public ResponseEntity<Part> createPart(@RequestBody Part part) {
        Part createdPart = partService.createPart(part);
        return new ResponseEntity<>(createdPart, HttpStatus.CREATED);
    }

    // PUT /parts/{partNumber}/state
    // Expects JSON: { "state": "NEW_STATE" }
    @PutMapping("/{partNumber}/state")
    public ResponseEntity<Part> updatePartState(
            @PathVariable String partNumber,
            @RequestBody Map<String, String> stateUpdate) {
        return ResponseEntity.ok(partService.updatePartState(partNumber, stateUpdate));
    }

    // DELETE /parts/{partNumber}
    @DeleteMapping("/{partNumber}")
    public ResponseEntity<Void> deletePart(@PathVariable String partNumber) {
        partService.deletePart(partNumber);
        return ResponseEntity.noContent().build();
    }
}