package com.day1csvdatahandling.advanceproblems.readlargecsv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class LargeCSVGenerator {
    private static final int TOTAL_RECORDS = 500000; //500K records
    private static final String FILE_NAME = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week-5\\src\\main\\resources\\large_students.csv";

    public static void main(String[] args) {
        generateLargeCSV(FILE_NAME, TOTAL_RECORDS);
        System.out.println("Large CSV file generated: " + FILE_NAME);
    }

    public static void generateLargeCSV(String fileName, int records) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack"};
        String[] grades = {"A", "B", "C", "D", "E"};

        Random random = new Random();

        try (FileWriter writer = new FileWriter(fileName)) {
            //Writing header
            writer.write("ID,Name,Age,Marks,Grade\n");

            for (int i = 1; i <= records; i++) {
                String name = names[random.nextInt(names.length)];
                int age = 18 + random.nextInt(10); // Random age between 18-27
                double marks = 50 + random.nextDouble() * 50; // Random marks between 50-100
                String grade = grades[random.nextInt(grades.length)];

                writer.write(i + "," + name + "," + age + "," + String.format("%.2f", marks) + "," + grade + "\n");

                if (i % 100000 == 0) {
                    System.out.println(i + " records written...");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

