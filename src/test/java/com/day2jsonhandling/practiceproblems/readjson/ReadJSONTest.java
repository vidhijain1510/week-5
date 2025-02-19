package com.day2jsonhandling.practiceproblems.readjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReadJSONTest {

    @Test
    void testReadJsonAndExtractFields() throws Exception {
        String jsonContent = """
            [
                {"name": "Pranjal", "email": "pranjal@gmail.com", "age": 28},
                {"name": "Mohit", "email": "mohit@gmail.com", "age": 34}
            ]
        """;
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonContent);

        assertEquals("Pranjal", rootNode.get(0).get("name").asText());
        assertEquals("pranjal@gmail.com", rootNode.get(0).get("email").asText());

        assertEquals("Mohit", rootNode.get(1).get("name").asText());
        assertEquals("mohit@gmail.com", rootNode.get(1).get("email").asText());
    }
}
