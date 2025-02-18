package com.day1csvdatahandling.advanceproblems.jsontocsv;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVToJSONConverterTest {

    @Test
    void testCSVToJSONConversion() {
        JSONToCSVConverter.convertJSONToCSV("src/main/resources/Student.json", "src/main/resources/StudentJSON.csv");

        File file = new File("test_students_output.json");
        assertTrue(file.exists(), "JSON file should be created.");
        assertTrue(file.length() > 0, "JSON file should not be empty.");
    }
}
