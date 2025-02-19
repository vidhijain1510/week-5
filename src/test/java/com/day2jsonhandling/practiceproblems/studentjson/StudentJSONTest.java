package com.day2jsonhandling.practiceproblems.studentjson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentJSONTest {

    @Test
    void testStudentJsonObject() {
        JSONObject student = new JSONObject();
        student.put("name", "Kapil");
        student.put("age", 20);

        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Physics");
        subjects.put("Computer Science");

        student.put("subjects", subjects);

        assertEquals("Kapil", student.getString("name"));
        assertEquals(20, student.getInt("age"));

        JSONArray retrievedSubjects = student.getJSONArray("subjects");
        assertEquals(3, retrievedSubjects.length());
        assertTrue(retrievedSubjects.toList().contains("Mathematics"));
        assertTrue(retrievedSubjects.toList().contains("Physics"));
        assertTrue(retrievedSubjects.toList().contains("Computer Science"));

        JSONObject expectedJson = new JSONObject();
        expectedJson.put("name", "Kapil");
        expectedJson.put("age", 20);
        expectedJson.put("subjects", new JSONArray().put("Mathematics").put("Physics").put("Computer Science"));

        assertEquals(expectedJson.toMap(), student.toMap());
    }
}
