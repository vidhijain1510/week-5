package com.day1csvdatahandling.advanceproblems.detectduplicate;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DetectDuplicateCSVTest {

    @Test
    void testFindDuplicateRecords() throws IOException {
        File testFile = new File("test_students.csv");
        createTestCSV(testFile);
        DetectDuplicateCSV.findDuplicateRecords(testFile.getAbsolutePath());
        assertTrue(testFile.exists(), "Test CSV file should exist.");
        assertTrue(testFile.length() > 0, "Test CSV file should not be empty.");
        testFile.delete();
    }

    //Helper method to create a small test CSV file with duplicates
    private void createTestCSV(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            writer.write("1,Alice,20,85,A\n");
            writer.write("2,Bob,21,78,B\n");
            writer.write("3,Charlie,22,90,A\n");
            writer.write("2,Bob,21,78,B\n"); // Duplicate
            writer.write("4,David,23,88,A\n");
            writer.write("1,Alice,20,85,A\n"); // Duplicate
        }
    }
}
