package com.day1csvdatahandling.advanceproblems.readlargecsv;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ReadLargeCSVTest {

    @Test
    void testReadCSVInChunks() throws IOException {
        File testFile = new File("src/main/resources/large_students.csv");
        createTestCSV(testFile);

        //Calling the method to test with the generated test file
        ReadLargeCSV.readCSVInChunks(testFile.getAbsolutePath());

        //Verifying that the file exists and has data
        assertTrue(testFile.exists(), "Test CSV file should exist.");
        assertTrue(testFile.length() > 0, "Test CSV file should not be empty.");

        //Cleanning up the test file after the test
        testFile.delete();
    }

    //Helper method to create a small test CSV file
    private void createTestCSV(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            for (int i = 1; i <= 1000; i++) { //Writing 1000 records for testing
                writer.write(i + ",Name" + i + "," + (18 + i % 10) + ",85.5,A\n");
            }
        }
    }
}
