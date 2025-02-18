/*1️⃣3️⃣ Generate a CSV Report from Database
Fetch employee records from a database and write them into a CSV file.
Include headers: Employee ID, Name, Department, Salary.*/
package com.day1csvdatahandling.advanceproblems.csvfordatabase;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GenerateCSVReport {
    private static final String CSV_FILE = "employees_report.csv";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        exportEmployeesToCSV();
    }

    public static void exportEmployeesToCSV() {
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {

            //Writing CSV header
            String[] header = {"Employee ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            //Writing data rows
            while (rs.next()) {
                String[] row = {
                        String.valueOf(rs.getInt("employee_id")),
                        rs.getString("name"),
                        rs.getString("department"),
                        String.valueOf(rs.getDouble("salary"))
                };
                writer.writeNext(row);
            }

            System.out.println("CSV report generated successfully: " + CSV_FILE);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

