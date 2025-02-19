/*2️⃣ Convert a Java object (Car) into JSON format.*/
package com.day2jsonhandling.practiceproblems.javatojson;

import com.fasterxml.jackson.databind.ObjectMapper;

//Can be done Using Jackson Library
public class JavaObjectToJSONFormat {
    public static void main(String[] args) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = new Car("BMW",5_000_000,"White");

            //Converting java object to json String
            String jsonString = objectMapper.writeValueAsString(car);
            System.out.println(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
