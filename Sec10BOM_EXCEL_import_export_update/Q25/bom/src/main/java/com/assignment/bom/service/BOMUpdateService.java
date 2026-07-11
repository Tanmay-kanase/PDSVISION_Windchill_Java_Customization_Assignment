package com.assignment.bom.service;

import com.assignment.bom.model.BOMImportRow;
import com.assignment.bom.model.BOMProcessingResult;
import com.assignment.bom.model.Part;
import com.assignment.bom.model.PartUsageLink;
import java.util.ArrayList;
import java.util.List;

public class BOMUpdateService {
    private final BOMService bomService;
    private final BOMValidationService validationService;

    public BOMUpdateService(BOMService bomService, BOMValidationService validationService) {
        this.bomService = bomService;
        this.validationService = validationService;
    }

    public List<BOMProcessingResult> processImport(List<BOMImportRow> rows) {
        List<BOMProcessingResult> results = new ArrayList<>();

        for (BOMImportRow row : rows) {
            String validationMsg = validationService.validateRow(row);

            if (!validationMsg.equals("VALID")) {
                results.add(new BOMProcessingResult(row.getRowNumber(), row.getParentPartNumber(),
                        row.getChildPartNumber(), row.getAction(), "FAILED", validationMsg)); // [cite: 258]
                continue;
            }

            // Ensure parent and child exist in DB (Mock behavior: auto-create if missing)
            Part parent = bomService.getPart(row.getParentPartNumber());
            if (parent == null) {
                parent = new Part(row.getParentPartNumber(), "Auto-Gen Name", "A", "INWORK");
                bomService.addPart(parent);
            }
            Part child = bomService.getPart(row.getChildPartNumber());
            if (child == null) {
                child = new Part(row.getChildPartNumber(), "Auto-Gen Name", "A", "INWORK");
                bomService.addPart(child);
            }

            // Process Actions [cite: 241, 242]
            try {
                if (row.getAction().equals("CREATE")) {
                    PartUsageLink link = new PartUsageLink(parent, child, row.getQuantity(), row.getUnitOfMeasure(),
                            row.getLineNumber());
                    bomService.addLink(link);
                    results.add(new BOMProcessingResult(row.getRowNumber(), row.getParentPartNumber(),
                            row.getChildPartNumber(), row.getAction(), "SUCCESS", "BOM link created successfully"));
                } else if (row.getAction().equals("UPDATE")) {
                    PartUsageLink link = bomService.getLink(row.getParentPartNumber(), row.getChildPartNumber());
                    link.setQuantity(row.getQuantity());
                    results.add(new BOMProcessingResult(row.getRowNumber(), row.getParentPartNumber(),
                            row.getChildPartNumber(), row.getAction(), "SUCCESS", "BOM link updated successfully"));
                } else if (row.getAction().equals("DELETE")) {
                    PartUsageLink link = bomService.getLink(row.getParentPartNumber(), row.getChildPartNumber());
                    bomService.removeLink(link);
                    results.add(new BOMProcessingResult(row.getRowNumber(), row.getParentPartNumber(),
                            row.getChildPartNumber(), row.getAction(), "SUCCESS", "BOM link deleted successfully"));
                }
            } catch (Exception e) {
                results.add(new BOMProcessingResult(row.getRowNumber(), row.getParentPartNumber(),
                        row.getChildPartNumber(), row.getAction(), "FAILED", e.getMessage()));
            }
        }
        return results;
    }
}