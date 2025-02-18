package com.day1csvdatahandling.advanceproblems.csvdatatojavaobjects;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CSVToObjectTest {
    @Test
    void testReadStudentsFromCSV() {
        String testFilePath = "src/test/resources/Test_Student.csv";
        List<Student> students = CSVToObject.readStudentsFromCSV(testFilePath);

        assertFalse(students.isEmpty(), "Student list should not be empty");

        //Checking the first student's details
        Student firstStudent = students.get(0);
        assertEquals("John Doe", firstStudent.getName());
        assertEquals(20, firstStudent.getAge());
        assertEquals(85, firstStudent.getMarks(), 0.1);
    }
}