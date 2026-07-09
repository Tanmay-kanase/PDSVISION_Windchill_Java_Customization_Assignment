package com.example.partsapi.service;

import com.example.partsapi.exception.ResourceNotFound;
import com.example.partsapi.model.Part;
import com.example.partsapi.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PartService extends LifecycleValidation {

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
        if (partRepository.existsById(part.getPartNumber())) {
            throw new IllegalArgumentException("Part number '" + part.getPartNumber() + "' already exists.");
        }
        part.getState().toUpperCase();
        String state = part.getState();
        if (!"INWORK".equals(state)
                && !"UNDER_REVIEW".equals(state)
                && !"RELEASED".equals(state)
                && !"OBSOLETE".equals(state)) {

            throw new IllegalArgumentException(
                    "State must be one of: INWORK, UNDER_REVIEW, RELEASED, OBSOLETE");
        }
        return partRepository.save(part);
    }

    public Part updatePartState(String partNumber, Map<String, String> stateUpdate) {

        Part existingPart = partRepository.findById(partNumber)
                .orElseThrow(() -> new ResourceNotFound(
                        "Part not found with number: " + partNumber));

        String targetState = stateUpdate.get("state");

        if (targetState == null || targetState.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Allowed values: INWORK, UNDER_REVIEW, RELEASED, OBSOLETE");
        }

        targetState = targetState.trim().toUpperCase();

        String currentState = existingPart.getState();

        System.out.println(currentState + "    " + targetState);
        if (!isValidTransition(currentState, targetState)) {
            throw new IllegalArgumentException(
                    "Invalid transition from "
                            + currentState
                            + " to "
                            + targetState
                            + ". Valid lifecycle: INWORK → UNDER_REVIEW → RELEASED → OBSOLETE");
        }

        existingPart.setState(targetState);

        return partRepository.save(existingPart);
    }

    public void deletePart(String partNumber) {
        Part existingPart = partRepository.findById(partNumber)
                .orElseThrow(() -> new ResourceNotFound("Part not found with number: " + partNumber));
        partRepository.delete(existingPart);
    }
}