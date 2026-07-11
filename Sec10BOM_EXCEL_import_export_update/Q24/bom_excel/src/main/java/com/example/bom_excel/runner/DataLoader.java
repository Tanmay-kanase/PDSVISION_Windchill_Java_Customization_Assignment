package com.example.bom_excel.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bom_excel.model.Part;
import com.example.bom_excel.model.PartUsageLink;
import com.example.bom_excel.service.BOMService;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final BOMService bomService;

    public DataLoader(BOMService bomService) {
        this.bomService = bomService;
    }

    @Override
    public void run(String... args) throws Exception {

        Part batteryAssembly =
                new Part(
                        "P-1001",
                        "Battery Assembly",
                        "A",
                        "INWORK",
                        "Assembly",
                        "Admin",
                        LocalDateTime.now());

        Part batteryCell =
                new Part(
                        "P-1002",
                        "Battery Cell",
                        "A",
                        "INWORK",
                        "Component",
                        "Admin",
                        LocalDateTime.now());

        Part batteryCover =
                new Part(
                        "P-1003",
                        "Battery Cover",
                        "A",
                        "INWORK",
                        "Component",
                        "Admin",
                        LocalDateTime.now());

        Part wiringHarness =
                new Part(
                        "P-1004",
                        "Wiring Harness",
                        "A",
                        "INWORK",
                        "Component",
                        "Admin",
                        LocalDateTime.now());

        Part connector =
                new Part(
                        "P-1005",
                        "Connector",
                        "A",
                        "INWORK",
                        "Component",
                        "Admin",
                        LocalDateTime.now());

        Part mountingBracket =
                new Part(
                        "P-1006",
                        "Mounting Bracket",
                        "A",
                        "INWORK",
                        "Component",
                        "Admin",
                        LocalDateTime.now());

        bomService.addUsageLink(
                new PartUsageLink(
                        batteryAssembly,
                        batteryCell,
                        12,
                        "Each",
                        10,
                        "F001",
                        "RD001"));

        bomService.addUsageLink(
                new PartUsageLink(
                        batteryAssembly,
                        batteryCover,
                        1,
                        "Each",
                        20,
                        "F002",
                        "RD002"));

        bomService.addUsageLink(
                new PartUsageLink(
                        batteryAssembly,
                        wiringHarness,
                        1,
                        "Each",
                        30,
                        "F003",
                        "RD003"));

        bomService.addUsageLink(
                new PartUsageLink(
                        wiringHarness,
                        connector,
                        4,
                        "Each",
                        10,
                        "F004",
                        "RD004"));

        bomService.addUsageLink(
                new PartUsageLink(
                        batteryAssembly,
                        mountingBracket,
                        2,
                        "Each",
                        40,
                        "F005",
                        "RD005"));

        System.out.println("\n===== BOM STRUCTURE =====\n");

        bomService.printBom(batteryAssembly);

        bomService.exportToExcel(
                batteryAssembly,
                "BOM_Report.xlsx");
    }
}