/*9️⃣ Convert CSV Data into Java Objects
Read a CSV file and convert each row into a Student Java object.
Store the objects in a List<Student> and print them.*/
package com.day1csvdatahandling.advanceproblems.csvdatatojavaobjects;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToObject {
    public static void main(String[] args) {
        String filePath = "src/main/resources/Student.csv";
        List<Student> students = readStudentsFromCSV(filePath);

        //Printing all student objects
        students.forEach(System.out::println);
    }

    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            for (int i = 1; i < records.size(); i++) { //Skipping header row
                String[] row = records.get(i);
                String name = row[1];
                int age = Integer.parseInt(row[2]);
                double marks = Double.parseDouble(row[3]);
                studentList.add(new Student(name, age, marks));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
