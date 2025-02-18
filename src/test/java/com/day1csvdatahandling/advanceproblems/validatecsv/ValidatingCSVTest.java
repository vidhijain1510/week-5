package com.day1csvdatahandling.advanceproblems.validatecsv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidatingCSVTest {
    @Test
    void testValidEmail() {
        assertTrue(ValidatingCSV.EMAIL_PATTERN.matcher("test@example.com").matches(), "Valid email should pass");
        assertFalse(ValidatingCSV.EMAIL_PATTERN.matcher("invalid-email").matches(), "Invalid email should fail");
    }

    @Test
    void testValidPhoneNumber() {
        assertTrue(ValidatingCSV.PHONE_PATTERN.matcher("9876543210").matches(), "Valid phone should pass");
        assertFalse(ValidatingCSV.PHONE_PATTERN.matcher("12345").matches(), "Short phone number should fail");
        assertFalse(ValidatingCSV.PHONE_PATTERN.matcher("123456789012").matches(), "Too long phone number should fail");
    }
}