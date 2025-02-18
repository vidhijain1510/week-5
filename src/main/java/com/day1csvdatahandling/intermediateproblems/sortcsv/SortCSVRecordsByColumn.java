/*7️⃣ Sort CSV Records by a Column
Read a CSV file and sort the records by Salary in descending order.
Print the top 5 highest-paid employees.
*/
package com.day1csvdatahandling.intermediateproblems.sortcsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortCSVRecordsByColumn {
    public static void main(String[] args) {
        String filePath = "src/main/resources/EmployeeDetails.csv";
        List<String[]> topEmployees = getTopPaidEmployees(filePath, 5);

        System.out.println("Top 5 Highest-Paid Employees:");
        topEmployees.forEach(emp ->
                System.out.println(String.join(", ", emp))
        );
    }

    public static List<String[]> getTopPaidEmployees(String filePath, int topN) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            return records.stream()
                    .skip(1) //Skipping header row
                    .sorted(Comparator.comparingDouble(row -> -Double.parseDouble(row[3]))) //Sorting by salary desc
                    .limit(topN) //Getting top N records
                    .collect(Collectors.toList());

        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
