/*🔟 Merge Two CSV Files
You have two CSV files:
students1.csv (contains ID, Name, Age)
students2.csv (contains ID, Marks, Grade)
Merge both files based on ID and create a new file containing all details.*/
package com.day1csvdatahandling.advanceproblems.mergecsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "src/main/resources/students1.csv"; //Contains ID, Name, Age
        String file2 = "src/main/resources/students2.csv"; //Contains ID, Marks, Grade
        String outputFile = "src/main/resources/merged_students.csv"; //Output file

        mergeCSVFiles(file1, file2, outputFile);
        System.out.println("Merged CSV file created: " + outputFile);
    }

    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<String, String[]> studentData = new HashMap<>();

        //Reading first CSV (students1.csv)
        try (CSVReader reader = new CSVReader(new FileReader(file1))) {
            List<String[]> records = reader.readAll();
            for (int i = 1; i < records.size(); i++) { //Skipping header
                studentData.put(records.get(i)[0], records.get(i)); //ID as key
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        //Reading second CSV (students2.csv) and merge data
        try (CSVReader reader = new CSVReader(new FileReader(file2))) {
            List<String[]> records = reader.readAll();
            for (int i = 1; i < records.size(); i++) { // Skipping header
                String[] row = records.get(i);
                if (studentData.containsKey(row[0])) {
                    // Append Marks & Grade to existing record
                    String[] existingRow = studentData.get(row[0]);
                    studentData.put(row[0], new String[]{
                            existingRow[0], existingRow[1], existingRow[2], row[1], row[2]
                    });
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        //Writing merged data to output file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"}); // Header
            for (String[] row : studentData.values()) {
                writer.writeNext(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

