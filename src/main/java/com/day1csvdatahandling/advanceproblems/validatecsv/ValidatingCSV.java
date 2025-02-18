/*8️⃣ Validate CSV Data Before Processing
Ensure that the "Email" column follows a valid email format using regex.
Ensure that "Phone Numbers" contain exactly 10 digits.
Print any invalid rows with an error message.
*/
package com.day1csvdatahandling.advanceproblems.validatecsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class ValidatingCSV {
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    public static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$"); //Exactly 10 digits

    public static void main(String[] args) {
        String filePath = "src/main/resources/Data.csv";
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            for (int i = 1; i < records.size(); i++) { //Skipping header row
                String[] row = records.get(i);
                String email = row[2]; //Assuming email is in the 3rd column
                String phone = row[3]; //Assuming phone is in the 4th column

                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.println("Invalid Email at row " + (i + 1) + ": " + email);
                }

                if (!PHONE_PATTERN.matcher(phone).matches()) {
                    System.out.println("Invalid Phone Number at row " + (i + 1) + ": " + phone);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

