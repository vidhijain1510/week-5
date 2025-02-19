/*1️⃣ Create a JSON object for a Student with fields: name, age, and subjects (array).*/
package com.day2jsonhandling.practiceproblems.studentjson;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJSON{
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name","Vidhi");
        student.put("age",21);

        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Chemistry");
        subjects.put("Physics");

        student.put("Subjects", subjects);
        System.out.println(student.toString(4));
    }
}
