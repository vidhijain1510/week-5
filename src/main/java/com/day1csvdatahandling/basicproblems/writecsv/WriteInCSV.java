/*2️⃣ Write Data to a CSV File
Create a CSV file with employee details (ID, Name, Department, Salary).
Write at least 5 records to the file.
*/
package com.day1csvdatahandling.basicproblems.writecsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/EmployeeDetails.csv";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write("ID,Name,Department,Salary\n");
            writer.write("1,Vidhi,IT,50000\n");
            writer.write("2,Suhani,IT,50000\n");
            writer.write("3,Shreasth,HR,45000\n");
            writer.write("4,Kapil,HR,45000\n");
            writer.write("5,Gourav,Testing,40000\n");
            System.out.println("CSV file written successfully!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
