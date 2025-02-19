/*4️⃣ Merge two JSON objects into one.*/
package com.day2jsonhandling.practiceproblems.mergejson;

import org.json.JSONObject;
import java.time.LocalDate;

public class MergeTwoJSONObject {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONObject jsonObject1 = new JSONObject();//Object one of JSON
        //Putting data in Object one
        jsonObject1.put("Name","Vidhi");
        jsonObject1.put("Age",20);
        jsonObject1.put("Country", "India");

        JSONObject jsonObject2 = new JSONObject();//Object two of JSON
        //Putting data in Object two
        jsonObject2.put("City","Bhopal");
        jsonObject2.put("DOB", LocalDate.of(2003, 10, 15));

        mergeJSON(jsonObject1,jsonObject2);
        System.out.println(jsonObject1);
    }
    public static JSONObject mergeJSON(JSONObject jsonObject1, JSONObject jsonObject2){
        //Merging data of both objects
        for(String key : jsonObject2.keySet()){
            jsonObject1.put(key,jsonObject2.get(key));
        }

        return jsonObject1;
    }
}
