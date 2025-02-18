package com.day1csvdatahandling.advanceproblems.csvencryption;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class DecryptCSVReader {
    private static final String CSV_FILE = "employees_encrypted.csv";

    public static void main(String[] args) {
        readDecryptedCSV();
    }

    public static void readDecryptedCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] row;
            boolean isHeader = true;

            while ((row = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    System.out.println(String.join(", ", row)); // Print Header
                    continue;
                }

                // Decrypt Salary & Email
                row[3] = AESUtil.decrypt(row[3]);
                row[4] = AESUtil.decrypt(row[4]);

                System.out.println(String.join(", ", row));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
