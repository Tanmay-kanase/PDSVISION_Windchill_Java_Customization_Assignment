package com.example.partsapi.service;

import com.example.partsapi.exception.ResourceNotFound;
import com.example.partsapi.model.Part;
import com.example.partsapi.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;

    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    public Part getPartByNumber(String partNumber) {
        return partRepository.findById(partNumber)
                .orElseThrow(() -> new ResourceNotFound("Part not found with number: " + partNumber));
    }

    public Part createPart(Part part) {
        // Prevent overwriting if the part already exists (optional business logic)
        if (partRepository.existsById(part.getPartNumber())) {
            throw new RuntimeException("Part with number " + part.getPartNumber() + " already exists.");
        }
        return partRepository.save(part);
    }

    public Part updatePartState(String partNumber, Map<String, String> stateUpdate) {
        Part existingPart = partRepository.findById(partNumber)
                .orElseThrow(() -> new ResourceNotFound("Part not found with number: " + partNumber));

        if (stateUpdate.containsKey("state")) {
            existingPart.setState(stateUpdate.get("state"));
            return partRepository.save(existingPart);
        } else {
            throw new IllegalArgumentException("Request body must contain a 'state' key.");
        }
    }

    public void deletePart(String partNumber) {
        Part existingPart = partRepository.findById(partNumber)
                .orElseThrow(() -> new ResourceNotFound("Part not found with number: " + partNumber));
        partRepository.delete(existingPart);
    }
}