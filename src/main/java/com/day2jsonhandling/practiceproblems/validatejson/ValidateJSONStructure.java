/* Validate JSON structure using Jackson.*/
package com.day2jsonhandling.practiceproblems.validatejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSONStructure {
    public static boolean isValidJson(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            return jsonNode != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String jsonString = "{\"Name\":\"Vidhi\", \"Age\":21}";
        boolean isValid = isValidJson(jsonString);
        System.out.println(isValid);
    }
}
