/*3️⃣ Read and Count Rows in a CSV File
Read a CSV file and count the number of records (excluding the header row).
*/
package com.day1csvdatahandling.basicproblems.readcountcsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;


public class ReadCountRowsInCSV {
    public static void main(String[] args) {
        try(CSVReader reader = new CSVReader(new FileReader("src/main/resources/EmployeeDetails.csv"))){
            String[] nextLine;
            int count = 0;
            reader.readNext();
            while ((nextLine=reader.readNext())!=null){
                count++;
            }
            System.out.println("Total Rows: " + count); //EmployeeDetails have 5 rows
        }catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}
