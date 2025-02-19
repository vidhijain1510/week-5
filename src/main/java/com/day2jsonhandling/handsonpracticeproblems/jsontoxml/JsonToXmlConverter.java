/*6️⃣ Convert JSON to XML format.*/
package com.day2jsonhandling.handsonpracticeproblems.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/Student.json"));

            XmlMapper xmlMapper = new XmlMapper();
            String xmlString = xmlMapper.writeValueAsString(jsonNode);

            System.out.println(xmlString);

            xmlMapper.writeValue(new File("src/main/resources/output.xml"), jsonNode);

            System.out.println("Conversion completed: JSON to XML");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
