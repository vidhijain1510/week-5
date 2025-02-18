package com.day1csvdatahandling.intermediateproblems.filterrecordscsv;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FilterRecordsCSVTest {
    @Test
    void testFilterStudents() {
        String testFilePath = "src/test/resources/Test_Student.csv";
        List<String[]> result = FilterRecordsCSV.filterStudents(testFilePath, 80);

        //Checking if results are not empty
        assertFalse(result.isEmpty(), "Filtered list should not be empty");

        //Validating all records have marks > 80
        for (String[] student : result) {
            assertTrue(Integer.parseInt(student[3]) > 80, "All students should have marks > 80");
        }
    }
}