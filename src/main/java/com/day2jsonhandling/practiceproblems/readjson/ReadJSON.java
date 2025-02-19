/*3️⃣ Read a JSON file and extract only specific fields (e.g., name, email).*/
package com.day2jsonhandling.practiceproblems.readjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJSON {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(new File("src/main/resources/Employee.json"));

            for (JsonNode userNode : node) {
                String name = userNode.get("name").asText();
                String email = userNode.get("email").asText();
                System.out.println("Name: " + name + " | Email: " + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}