package com.day1csvdatahandling.basicproblems.readandprintcsv;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ReadPrintCSVTest {

    @Test
    void testReadCSVOutput() throws Exception {
        String testFilePath = "src/test/resources/Test_Student.csv";

        //Capturing console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        //Using reflection to call the readAndPrintCSV method directly
        Method method = ReadPrintCSV.class.getDeclaredMethod("readAndPrintCSV", String.class);
        method.setAccessible(true);  // Allow access to the private method
        method.invoke(null, testFilePath);  // Call with test file path

        //Restoring System.out
        System.setOut(originalOut);

        String output = outputStream.toString().trim();

        System.out.println("Captured Output:\n" + output);

        // Expected Output
        String expectedOutput = "ID: 101 | Name: John Doe | Age: 20 | Marks: 85\n" +
                "ID: 102 | Name: Jane Smith | Age: 22 | Marks: 90\n" +
                "ID: 103 | Name: Sam Brown | Age: 21 | Marks: 78";

        output = output.replace("\r\n", "\n").trim();
        expectedOutput = expectedOutput.replace("\r\n", "\n").trim();

        assertEquals(expectedOutput, output);
    }
}
