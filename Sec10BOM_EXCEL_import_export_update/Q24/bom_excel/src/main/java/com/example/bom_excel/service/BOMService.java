package com.example.bom_excel.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.bom_excel.model.Part;
import com.example.bom_excel.model.PartUsageLink;

import java.io.FileOutputStream;
import java.util.*;

@Service
public class BOMService {

        private final Map<Part, List<PartUsageLink>> bomMap = new HashMap<>();

        public void addUsageLink(PartUsageLink link) {

                bomMap.computeIfAbsent(
                                link.getParentPart(),
                                k -> new ArrayList<>())
                                .add(link);
        }

        public void printBom(Part root) {

                System.out.println(
                                root.getPartName() +
                                                " [" +
                                                root.getPartNumber() +
                                                ", Rev " +
                                                root.getRevision() +
                                                "]");

                printChildren(root, "");
        }

        private void printChildren(Part parent,
                        String indent) {

                List<PartUsageLink> children = bomMap.getOrDefault(parent,
                                Collections.emptyList());

                for (int i = 0; i < children.size(); i++) {

                        PartUsageLink link = children.get(i);

                        boolean last = i == children.size() - 1;

                        String branch = last ? " └── " : " ├── ";

                        System.out.println(
                                        indent +
                                                        branch +
                                                        link.getChildPart().getPartName() +
                                                        " [" +
                                                        link.getChildPart().getPartNumber() +
                                                        ", Rev " +
                                                        link.getChildPart().getRevision() +
                                                        "] Qty: " +
                                                        link.getQuantity() +
                                                        " " +
                                                        link.getUnitOfMeasure());

                        String nextIndent = indent + (last ? "     " : " │   ");

                        printChildren(
                                        link.getChildPart(),
                                        nextIndent);
                }
        }

        public void exportToExcel(
                        Part root,
                        String fileName) throws Exception {

                Workbook workbook = new XSSFWorkbook();

                Sheet sheet = workbook.createSheet("BOM Report");

                String[] headers = {
                                "Level",
                                "Parent Part Number",
                                "Parent Part Name",
                                "Child Part Number",
                                "Child Part Name",
                                "Child Revision",
                                "Child Lifecycle State",
                                "Quantity",
                                "Unit of Measure",
                                "Line Number",
                                "Find Number",
                                "Reference Designator"
                };

                Row headerRow = sheet.createRow(0);

                for (int i = 0; i < headers.length; i++) {
                        headerRow
                                        .createCell(i)
                                        .setCellValue(headers[i]);
                }

                List<Object[]> rows = new ArrayList<>();

                buildRows(root, 1, rows);

                int rowNum = 1;

                for (Object[] data : rows) {

                        Row row = sheet.createRow(rowNum++);

                        for (int i = 0; i < data.length; i++) {

                                row.createCell(i)
                                                .setCellValue(
                                                                String.valueOf(data[i]));
                        }
                }

                for (int i = 0; i < headers.length; i++) {
                        sheet.autoSizeColumn(i);
                }

                FileOutputStream fos = new FileOutputStream(fileName);

                workbook.write(fos);

                fos.close();
                workbook.close();

                System.out.println(
                                "\nExcel Exported Successfully : "
                                                + fileName);
        }

        private void buildRows(
                        Part parent,
                        int level,
                        List<Object[]> rows) {

                List<PartUsageLink> links = bomMap.getOrDefault(parent,
                                Collections.emptyList());

                for (PartUsageLink link : links) {

                        rows.add(new Object[] {
                                        level,
                                        parent.getPartNumber(),
                                        parent.getPartName(),
                                        link.getChildPart().getPartNumber(),
                                        link.getChildPart().getPartName(),
                                        link.getChildPart().getRevision(),
                                        link.getChildPart().getLifecycleState(),
                                        link.getQuantity(),
                                        link.getUnitOfMeasure(),
                                        link.getLineNumber(),
                                        link.getFindNumber(),
                                        link.getReferenceDesignator()
                        });

                        buildRows(
                                        link.getChildPart(),
                                        level + 1,
                                        rows);
                }
        }
}