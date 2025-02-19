package com.day2jsonhandling.handsonpracticeproblems.iplanalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class IPLDataProcessor {
    private static final String REDACTED = "REDACTED";

    private static String maskTeamName(String teamName) {
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            return parts[0] + " *";
        }
        return "*";
    }

    private static void processJson(String inputFile, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, IPLMatch.class);
        List<IPLMatch> matches = objectMapper.readValue(new File(inputFile), listType);

        for (IPLMatch match : matches) {
            match.team1 = maskTeamName(match.team1);
            match.team2 = maskTeamName(match.team2);
            match.winner = maskTeamName(match.winner);
            match.player_of_match = REDACTED;
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
    }

    private static void processCsv(String inputFile, String outputFile) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> data = reader.readAll();

            //Debugging: Checking if data is read
            if (data.isEmpty()) {
                System.out.println("Error: CSV file is empty or not read properly.");
                return;
            }

            List<String[]> censoredData = new ArrayList<>();
            censoredData.add(data.get(0)); //headers

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                if (row.length < 7) { //Ensures the row has all expected columns
                    System.out.println("Skipping malformed row at index " + i + ": " + Arrays.toString(row));
                    continue;
                }

                row[1] = maskTeamName(row[1]); //team1
                row[2] = maskTeamName(row[2]); //team2
                row[5] = maskTeamName(row[5]); //winner
                row[6] = REDACTED; //player_of_match
                censoredData.add(row);
            }

            writer.writeAll(censoredData);
            System.out.println("CSV processing completed successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: CSV file not found - " + inputFile);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error processing CSV file.");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            processJson("src/main/resources/ipl_datas.json", "src/main/resources/censored_ipl_data.json");
            processCsv("src/main/resources/ipl_datas.csv", "src/main/resources/censored_ipl_data.csv");
            System.out.println("Processing completed. Check the output files.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
