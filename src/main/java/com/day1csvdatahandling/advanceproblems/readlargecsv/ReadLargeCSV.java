/*1️⃣1️⃣ Read Large CSV File Efficiently
Given a large CSV file (500MB+), implement a memory-efficient way to read it in chunks.
Process only 100 lines at a time and display the count of records processed.
*/
package com.day1csvdatahandling.advanceproblems.readlargecsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLargeCSV {
    private static final int CHUNK_SIZE = 100; //Process 100 lines at a time

    public static void main(String[] args) {
        String filePath = "src/main/resources/large_students.csv"; //Path to large CSV file
        readCSVInChunks(filePath);
    }

    public static void readCSVInChunks(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> chunk = new ArrayList<>();
            int totalRecords = 0;

            //Reading the header first
            String[] header = reader.readNext();
            System.out.println("Header: " + String.join(", ", header));

            String[] line;
            while ((line = reader.readNext()) != null) {
                chunk.add(line);

                //When chunk size is reached, process the chunk
                if (chunk.size() >= CHUNK_SIZE) {
                    totalRecords += processChunk(chunk);
                    chunk.clear(); // Clear the chunk for the next set of records
                    System.out.println("Processed " + totalRecords + " records...");
                }
            }

            //Process any remaining records that didn't fill the last chunk
            if (!chunk.isEmpty()) {
                totalRecords += processChunk(chunk);
                System.out.println("Processed " + totalRecords + " records...");
            }

            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    //Simulate processing of a chunk of records
    private static int processChunk(List<String[]> chunk) {
        for (String[] row : chunk) {
            System.out.println("Processing record: " + String.join(", ", row));
        }
        return chunk.size();
    }
}
