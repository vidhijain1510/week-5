package com.day1csvdatahandling.intermediateproblems.searchcsv;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class SearchInCSVTest {
    @Test
    void testSearchEmployeeByName() {
        String testFilePath = "src/main/resources/EmployeeDetails.csv";

        Optional<String[]> result = SearchInCSV.searchEmployeeByName(testFilePath, "Suhani");

        assertTrue(result.isPresent(), "Employee should be found");
        assertEquals("IT", result.get()[2], "Department should be IT");
        assertEquals("50000", result.get()[3], "Salary should be 50000");
    }

    @Test
    void testSearchEmployeeNotFound() {
        String testFilePath = "src/main/resources/EmployeeDetails.csv";

        Optional<String[]> result = SearchInCSV.searchEmployeeByName(testFilePath, "Unknown");

        assertFalse(result.isPresent(), "Employee should not be found");
    }

}