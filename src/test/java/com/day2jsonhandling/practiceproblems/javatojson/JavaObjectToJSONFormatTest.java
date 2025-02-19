package com.day2jsonhandling.practiceproblems.javatojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaObjectToJSONFormatTest {
    @Test
    void testCarObjectToJsonConversion() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Swift", 5_000_00, "White");

        String jsonString = objectMapper.writeValueAsString(car);

        assertTrue(jsonString.contains("\"model\":\"Swift\""));
        assertTrue(jsonString.contains("\"price\":500000.0"));
        assertTrue(jsonString.contains("\"color\":\"White\""));

        String expectedJson = "{\"model\":\"Swift\",\"price\":500000.0,\"color\":\"White\"}";
        assertEquals(expectedJson, jsonString);
    }

}