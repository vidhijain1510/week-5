package com.day1csvdatahandling.advanceproblems.csvfordatabase;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateCSVReportTest {

    @Test
    void testExportEmployeesToCSV() {
        GenerateCSVReport.exportEmployeesToCSV();
        File file = new File("employees_report.csv");
        assertTrue(file.exists(), "CSV file should be generated.");
        assertTrue(file.length() > 0, "CSV file should not be empty.");

        file.delete();
    }
}
