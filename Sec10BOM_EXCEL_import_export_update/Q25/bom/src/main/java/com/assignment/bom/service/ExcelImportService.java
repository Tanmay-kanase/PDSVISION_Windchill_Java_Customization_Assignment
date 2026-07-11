package com.assignment.bom.service;

import com.assignment.bom.model.BOMImportRow;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelImportService {
    public List<BOMImportRow> readExcel(String filePath) throws Exception {
        List<BOMImportRow> rows = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header
                Row excelRow = sheet.getRow(i);
                if (excelRow == null)
                    continue;

                BOMImportRow row = new BOMImportRow();
                row.setRowNumber(i + 1);
                row.setLevel((int) excelRow.getCell(0).getNumericCellValue());
                row.setParentPartNumber(excelRow.getCell(1).getStringCellValue());
                row.setChildPartNumber(excelRow.getCell(3).getStringCellValue());
                row.setQuantity(excelRow.getCell(7).getNumericCellValue());
                row.setUnitOfMeasure(excelRow.getCell(8).getStringCellValue());

                Cell lineNoCell = excelRow.getCell(9);
                if (lineNoCell != null) {
                    if (lineNoCell.getCellType() == CellType.NUMERIC) {
                        row.setLineNumber(String.valueOf((int) lineNoCell.getNumericCellValue()));
                    } else {
                        row.setLineNumber(lineNoCell.getStringCellValue());
                    }
                }

                // Read the extra Action column [cite: 237, 246]
                row.setAction(excelRow.getCell(12).getStringCellValue().toUpperCase());

                rows.add(row);
            }
        }
        return rows;
    }
}