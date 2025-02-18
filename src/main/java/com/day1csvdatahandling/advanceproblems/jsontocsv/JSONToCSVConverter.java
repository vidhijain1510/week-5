/*1️⃣4️⃣ Convert JSON to CSV and Vice Versa
Read a JSON file containing a list of students.
Convert it into CSV format and save it.
Implement another method to read CSV and convert it back to JSON.
*/
package com.day1csvdatahandling.advanceproblems.jsontocsv;

import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class JSONToCSVConverter {
    private static final String JSON_FILE = "src/main/resources/Student.json";
    private static final String CSV_FILE = "src/main/resources/StudentJSON.csv";

    public static void main(String[] args) {
        convertJSONToCSV(JSON_FILE, CSV_FILE);
    }

    public static void convertJSONToCSV(String jsonFilePath, String csvFilePath) {
        try (FileReader reader = new FileReader(jsonFilePath);
             FileWriter fileWriter = new FileWriter(csvFilePath);
             CSVWriter csvWriter = new CSVWriter(fileWriter)) {

            //Reading JSON file
            StringBuilder jsonText = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                jsonText.append((char) i);
            }

            JSONArray jsonArray = new JSONArray(jsonText.toString());

            //Extracting headers from first JSON object
            JSONObject firstObj = jsonArray.getJSONObject(0);
            Iterator<String> keys = firstObj.keys();
            String[] headers = new String[firstObj.length()];
            int index = 0;
            while (keys.hasNext()) {
                headers[index++] = keys.next();
            }
            csvWriter.writeNext(headers);

            //Writing data rows
            for (int j = 0; j < jsonArray.length(); j++) {
                JSONObject obj = jsonArray.getJSONObject(j);
                String[] row = new String[headers.length];
                for (int k = 0; k < headers.length; k++) {
                    row[k] = obj.getString(headers[k]);
                }
                csvWriter.writeNext(row);
            }

            System.out.println("JSON to CSV conversion successful: " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

