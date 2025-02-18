/*1️⃣ Read a CSV File and Print Data
Read a CSV file containing student details (ID, Name, Age, Marks).
Print each record in a structured format.
*/
package com.day1csvdatahandling.basicproblems.readandprintcsv;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadPrintCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/Student.csv"; // Main file
        readAndPrintCSV(filePath);
    }

    // Ensure this method is public for access in tests
    public static void readAndPrintCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",");
                System.out.printf("ID: %s | Name: %s | Age: %s | Marks: %s%n",
                        values[0], values[1], values[2], values[3]);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
