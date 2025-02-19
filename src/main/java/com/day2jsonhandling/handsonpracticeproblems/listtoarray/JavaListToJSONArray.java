/*2️⃣ Convert a list of Java objects into a JSON array.*/
package com.day2jsonhandling.handsonpracticeproblems.listtoarray;

import com.day2jsonhandling.practiceproblems.listtojsonarray.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class JavaListToJSONArray {
    public static String convertListToJSON(List<com.day2jsonhandling.practiceproblems.listtojsonarray.Person> personList){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(personList);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        List<com.day2jsonhandling.practiceproblems.listtojsonarray.Person> people = Arrays.asList(
                new com.day2jsonhandling.practiceproblems.listtojsonarray.Person("Vedant", 20),
                new Person("Vedvyas", 52)
        );
        String jsonArray = convertListToJSON(people);
        System.out.println(jsonArray);
    }
}
