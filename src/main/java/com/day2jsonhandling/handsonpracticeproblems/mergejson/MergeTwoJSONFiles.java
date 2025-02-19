/*5️⃣ Merge two JSON files into a single JSON object.
*/
package com.day2jsonhandling.handsonpracticeproblems.mergejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MergeTwoJSONFiles {
    public static JsonNode mergeJsonFiles(String filePath1, String filePath2) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode1 = objectMapper.readTree(new File(filePath1));
            JsonNode jsonNode2 = objectMapper.readTree(new File(filePath2));

            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) jsonNode1);
            mergedJson.setAll((ObjectNode) jsonNode2);

            return mergedJson;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        JsonNode mergedJson = mergeJsonFiles("src/main/resources/Student1.json", "src/main/resources/Student.json");

        if (mergedJson != null) {
            System.out.println("Merged JSON: " + mergedJson.toPrettyString());
        } else {
            System.out.println("Merging failed.");
        }
    }
}

