package com.day1csvdatahandling.basicproblems.writecsv;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class WriteInCSVTest {

    @Test
    void testWriteInCSV() {
        String filePath = "src/main/resources/EmployeeDetails.csv";

        //the method that writes to the CSV file
        WriteInCSV.main(new String[0]);

        //Verifying if the file is created
        assertTrue(isFileCreated(filePath));

        //Verifying the content of the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            String expectedContent = "ID,Name,Department,Salary\n" +
                    "1,Vidhi,IT,50000\n" +
                    "2,Suhani,IT,50000\n" +
                    "3,Shreasth,HR,45000\n" +
                    "4,Kapil,HR,45000\n" +
                    "5,Gourav,Testing,40000\n";

            assertEquals(expectedContent, content.toString(), "The CSV content is not correct");
        } catch (IOException e) {
            fail("Exception occurred while reading the CSV file: " + e.getMessage());
        }
    }

    // Helper method to check if the file exists
    private boolean isFileCreated(String filePath) {
        return new java.io.File(filePath).exists();
    }
}
