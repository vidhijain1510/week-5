package com.day1csvdatahandling.advanceproblems.mergecsv;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class MergeCSVTest {

    @Test
    void testMergeCSVFiles() {
        String testFile1 = "src/test/resources/test_student1.csv";
        String testFile2 = "src/test/resources/test_student2.csv";
        String outputFile = "src/test/resources/test_merged_students.csv";

        MergeCSV.mergeCSVFiles(testFile1, testFile2, outputFile);

        File output = new File(outputFile);
        assertTrue(output.exists(), "Merged CSV file should be created");
    }
}
