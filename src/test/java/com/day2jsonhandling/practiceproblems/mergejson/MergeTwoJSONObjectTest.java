package com.day2jsonhandling.practiceproblems.mergejson;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeTwoJSONObjectTest {

    @Test
    void testMergeJSONObjects() {
        JSONObject object1 = new JSONObject("{\"Name\": \"Suhani\", \"Age\": 22}");
        JSONObject object2 = new JSONObject("{\"Degree\": \"B-Tech\"}");
        JSONObject actual = MergeTwoJSONObject.mergeJSON(object1, object2);

        JSONObject expected = new JSONObject("{\"Degree\": \"B-Tech\", \"Age\": 22, \"Name\": \"Suhani\"}");
        assertEquals(expected.toString(), actual.toString());
    }
}
