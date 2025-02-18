/*1️⃣2️⃣ Detect Duplicates in a CSV File
Read a CSV file and detect duplicate entries based on the ID column.
Print all duplicate records.
*/
package com.day1csvdatahandling.advanceproblems.detectduplicate;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/Student.csv"; //Path to CSV file
        findDuplicateRecords(filePath);
    }

    public static void findDuplicateRecords(String filePath) {
        Map<String, List<String[]>> recordMap = new HashMap<>();
        List<String[]> duplicates = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); //Reading header
            System.out.println("Header: " + String.join(", ", header));

            String[] line;
            while ((line = reader.readNext()) != null) {
                String id = line[0]; //ID is assumed to be in column 0

                if (recordMap.containsKey(id)) {
                    duplicates.add(line);
                } else {
                    recordMap.put(id, new ArrayList<>());
                }
                recordMap.get(id).add(line);
            }

            //Printing duplicate records
            if (!duplicates.isEmpty()) {
                System.out.println("Duplicate Records Found:");
                for (String[] dup : duplicates) {
                    System.out.println(String.join(", ", dup));
                }
            } else {
                System.out.println("No duplicate records found.");
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

