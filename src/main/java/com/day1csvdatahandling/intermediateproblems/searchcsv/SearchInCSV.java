package com.day1csvdatahandling.intermediateproblems.searchcsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class SearchInCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/EmployeeDetails.csv";
        String employeeName = "Vidhi";

        Optional<String[]> employee = searchEmployeeByName(filePath, employeeName);

        if (employee.isPresent()) {
            System.out.println("Department: " + employee.get()[2]);
            System.out.println("Salary: " + employee.get()[3]);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static Optional<String[]> searchEmployeeByName(String filePath, String name) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            return records.stream()
                    .skip(1) // Skipping header
                    .filter(row -> row[1].equalsIgnoreCase(name))
                    .findFirst();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
