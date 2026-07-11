package com.assignment.bom.service;

import com.assignment.bom.model.BOMProcessingResult;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.List;

public class BOMResultExportService {

    // Generates a row-wise processing result report [cite: 243, 258]
    public void exportResult(List<BOMProcessingResult> results, String outputPath) throws Exception {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Processing Results");

            // Header [cite: 258]
            Row header = sheet.createRow(0);
            String[] columns = { "Row Number", "Parent Part Number", "Child Part Number", "Action", "Status",
                    "Message" };
            for (int i = 0; i < columns.length; i++) {
                header.createCell(i).setCellValue(columns[i]);
            }

            // Data
            int rowIdx = 1;
            for (BOMProcessingResult res : results) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(res.getRowNumber());
                row.createCell(1).setCellValue(res.getParentPartNumber());
                row.createCell(2).setCellValue(res.getChildPartNumber());
                row.createCell(3).setCellValue(res.getAction());
                row.createCell(4).setCellValue(res.getStatus());
                row.createCell(5).setCellValue(res.getMessage());
            }

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                workbook.write(fos);
            }
        }
    }
}