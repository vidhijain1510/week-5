/*4️⃣ Filter Records from CSV
Read a CSV file and filter students who have scored more than 80 marks.
Print only the qualifying records.
*/
package com.day1csvdatahandling.intermediateproblems.filterrecordscsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FilterRecordsCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/Student.csv";
        List<String[]> filteredStudents = filterStudents(filePath, 80);

        //Printing filtered students
        filteredStudents.forEach(student ->
                System.out.println(String.join(", ", student))
        );
    }

    public static List<String[]> filterStudents(String filePath, int minMarks) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            //Assuming CSV format:ID, Name, Age, Marks
            return records.stream()
                    .skip(1) //Skipping header
                    .filter(row -> {
                        try {
                            return Integer.parseInt(row[3]) > minMarks;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    })
                    .collect(Collectors.toList());
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}

