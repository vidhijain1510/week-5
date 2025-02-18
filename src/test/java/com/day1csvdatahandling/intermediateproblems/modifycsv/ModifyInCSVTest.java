package com.day1csvdatahandling.intermediateproblems.modifycsv;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ModifyInCSVTest {
    @Test
    void testUpdateSalaries() throws Exception {
        String testInput = "src/test/resources/Test_employee.csv";
        String testOutput = "src/test/resources/test_updated_employees.csv";

        //Running the update method
        ModifyInCSV.updateSalaries(testInput, testOutput);

        //Reading updated file
        List<String> lines = Files.readAllLines(new File(testOutput).toPath());

        //Checking if IT employees' salaries are updated
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts[2].equalsIgnoreCase("IT")) {
                double originalSalary = 50000.0; // Assume initial salary
                double updatedSalary = Double.parseDouble(parts[3]);
                assertEquals(originalSalary * 1.1, updatedSalary, 0.1, "IT salary should increase by 10%");
            }
        }
    }
}