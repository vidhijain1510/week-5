package com.day1csvdatahandling.basicproblems.readcountcsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadCountRowsInCSVTest {

    private File csvFile;

    @BeforeEach
    void setUp(@TempDir File tempDir) throws IOException {
        csvFile = new File(tempDir, "EmployeeDetails.csv");
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            //Writing header and 5 rows of data
            writer.writeNext(new String[]{"ID", "Name", "Department"});
            writer.writeNext(new String[]{"1", "Alice", "HR"});
            writer.writeNext(new String[]{"2", "Bob", "IT"});
            writer.writeNext(new String[]{"3", "Charlie", "Finance"});
            writer.writeNext(new String[]{"4", "David", "Sales"});
            writer.writeNext(new String[]{"5", "Emma", "Marketing"});
        }
    }
    @Test
    void testReadCountRows() throws IOException, CsvValidationException {
        int expectedRowCount = 5; //Since the header is skipped
        int actualRowCount = countRows(csvFile.getAbsolutePath());
        assertEquals(expectedRowCount, actualRowCount, "Row count should be 5");
    }

    private int countRows(String filePath) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            int count = 0;
            reader.readNext(); //Skip header
            while ((nextLine = reader.readNext()) != null) {
                count++;
            }
            return count;
        }
    }
}
