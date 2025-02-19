/*3️⃣ Filter JSON data: Print only users older than 25 years.*/
package com.day2jsonhandling.handsonpracticeproblems.filterjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class FilterJSON {
    public static List<String> filterByAge(String jsonString, int ageThreshold) {
        List<String> filteredNames = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.readTree(jsonString);

            for (JsonNode node : jsonArray) {
                int age = node.get("age").asInt();
                if (age > ageThreshold) {
                    filteredNames.add(node.get("name").asText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredNames;
    }

    public static void main(String[] args) {
        String jsonInput = "[{\"name\":\"Vidhi\",\"age\":25},{\"name\":\"Kapil\",\"age\":30},{\"name\":\"Suhani\",\"age\":28},{\"name\":\"Gourav\",\"age\":22}]";
        List<String> filteredNames = filterByAge(jsonInput, 25);
        System.out.println("Filtered Names: " + filteredNames);
    }
}
