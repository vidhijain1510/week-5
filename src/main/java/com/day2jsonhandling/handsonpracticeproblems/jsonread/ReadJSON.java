/*1️⃣ Read a JSON file and print all keys and values.*/
package com.day2jsonhandling.handsonpracticeproblems.jsonread;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJSON {
    public static void printJson(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), prefix + entry.getKey() + ": ");
            }
        } else if (node.isArray()) {
            for (JsonNode arrayElement : node) {
                printJson(arrayElement, prefix);
            }
        } else {
            System.out.println(prefix + node.asText());
        }
    }

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/Employee.json"));
            printJson(jsonNode, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
