/*6️⃣ Modify a CSV File (Update a Value)
Read a CSV file and increase the salary of employees from the "IT" department by 10%.
Save the updated records back to a new CSV file.
*/
package com.day1csvdatahandling.intermediateproblems.modifycsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.List;

public class ModifyInCSV {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/EmployeeDetails.csv";
        String outputFilePath = "src/main/resources/updated_employees.csv";

        updateSalaries(inputFilePath, outputFilePath);
        System.out.println("Salary updates completed. Check " + outputFilePath);
    }

    public static void updateSalaries(String inputFile, String outputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> records = reader.readAll();

            //Writing updated records
            for (int i = 0; i < records.size(); i++) {
                String[] row = records.get(i);

                if (i == 0) {
                    //Writing header row as is
                    writer.writeNext(row);
                } else if (row[2].equalsIgnoreCase("IT")) {
                    //Increasing salary by 10% for IT department employees
                    double salary = Double.parseDouble(row[3]);
                    row[3] = String.valueOf(salary * 1.1);
                    writer.writeNext(row);
                } else {
                    writer.writeNext(row);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
