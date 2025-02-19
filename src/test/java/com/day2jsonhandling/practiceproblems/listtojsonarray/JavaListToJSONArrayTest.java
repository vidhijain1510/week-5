package com.day2jsonhandling.practiceproblems.listtojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class JavaListToJSONArrayTest {
    @Test
    void testConvertListToJson() throws Exception {
        List<Person> people = Arrays.asList(
                new Person("Vidhi", 25),
                new Person("Kapil", 30)
        );
        String jsonResult = JavaListToJSONArray.convertListToJSON(people);

        String expectedJson = "[{\"name\":\"Vidhi\",\"age\":25},{\"name\":\"Kapil\",\"age\":30}]";
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(objectMapper.readTree(expectedJson), objectMapper.readTree(jsonResult));
    }
}