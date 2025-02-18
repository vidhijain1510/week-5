package com.day1csvdatahandling.intermediateproblems.sortcsv;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SortCSVRecordsByColumnTest {
    @Test
    void testGetTopPaidEmployees() {
        String testFilePath = "src/test/resources/Test_employee.csv";
        List<String[]> result = SortCSVRecordsByColumn.getTopPaidEmployees(testFilePath, 3);

        assertEquals(3, result.size(), "Should return top 3 employees");

        //Checking if salaries are sorted in descending order
        double prevSalary = Double.MAX_VALUE;
        for (String[] emp : result) {
            double currentSalary = Double.parseDouble(emp[3]);
            assertTrue(currentSalary <= prevSalary, "Salaries should be in descending order");
            prevSalary = currentSalary;
        }
    }
}