package com.day1csvdatahandling.advanceproblems.csvencryption;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptCSVWriter {
    private static final String CSV_FILE = "employees_encrypted.csv";

    public static void main(String[] args) {
        writeEncryptedCSV();
    }

    public static void writeEncryptedCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            // Header
            String[] header = {"EmployeeID", "Name", "Department", "Salary", "Email"};
            writer.writeNext(header);

            // Sample Data (Encrypt Salary & Email)
            String[] employee1 = {"101", "Alice", "HR", AESUtil.encrypt("60000"), AESUtil.encrypt("alice@example.com")};
            String[] employee2 = {"102", "Bob", "IT", AESUtil.encrypt("75000"), AESUtil.encrypt("bob@example.com")};
            String[] employee3 = {"103", "Charlie", "Finance", AESUtil.encrypt("90000"), AESUtil.encrypt("charlie@example.com")};

            writer.writeNext(employee1);
            writer.writeNext(employee2);
            writer.writeNext(employee3);

            System.out.println("Encrypted CSV file written: " + CSV_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

