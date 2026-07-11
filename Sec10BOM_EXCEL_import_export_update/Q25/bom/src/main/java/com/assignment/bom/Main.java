package com.assignment.bom;

import com.assignment.bom.model.BOMImportRow;
import com.assignment.bom.model.BOMProcessingResult;
import com.assignment.bom.service.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting BOM Processing Assignment...");

        // Initialize Services
        BOMService bomService = new BOMService();
        BOMValidationService validationService = new BOMValidationService(bomService);
        BOMUpdateService updateService = new BOMUpdateService(bomService, validationService);
        BOMResultExportService resultExportService = new BOMResultExportService();

        // Simulate reading rows from ExcelImportService manually for demonstration
        List<BOMImportRow> simulatedImport = new ArrayList<>();

        // CREATE - valid [cite: 258]
        BOMImportRow row1 = createMockRow(2, "P-1001", "P-1002", "CREATE", 12, "Each");

        // CREATE - fail (Parent and child same) [cite: 255, 258]
        BOMImportRow row2 = createMockRow(7, "P-1001", "P-1001", "CREATE", 1, "Each");

        simulatedImport.add(row1);
        simulatedImport.add(row2);

        // Process the rows [cite: 240, 241, 242]
        List<BOMProcessingResult> results = updateService.processImport(simulatedImport);

        // Export Results [cite: 243]
        try {
            resultExportService.exportResult(results, "BOM_Processing_Report.xlsx");
            System.out.println("Processing complete. Report generated at BOM_Processing_Report.xlsx");
        } catch (Exception e) {
            System.err.println("Failed to export results: " + e.getMessage());
        }
    }

    private static BOMImportRow createMockRow(int rowNum, String parent, String child, String action, double qty,
            String uom) {
        BOMImportRow row = new BOMImportRow();
        row.setRowNumber(rowNum);
        row.setLevel(1); // [cite: 248]
        row.setParentPartNumber(parent);
        row.setChildPartNumber(child);
        row.setAction(action); // [cite: 238]
        row.setQuantity(qty);
        row.setUnitOfMeasure(uom);
        row.setLineNumber("10");
        return row;
    }
}