package com.day2jsonhandling.practiceproblems.validatejson;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidateJSONStructureTest {
    @Test
    void testValidJson() {
        String validJson = "{\"Name\":\"Vidhi\", \"Age\":21}";
        assertTrue(ValidateJSONStructure.isValidJson(validJson));
    }

    @Test
    void testInvalidJson() {
        String invalidJson = "{\"Name\":\"Vidhi\", \"Age\":21"; // Missing closing bracket
        assertFalse(ValidateJSONStructure.isValidJson(invalidJson));
    }

}