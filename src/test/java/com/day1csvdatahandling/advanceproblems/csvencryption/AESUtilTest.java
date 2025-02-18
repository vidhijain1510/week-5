package com.day1csvdatahandling.advanceproblems.csvencryption;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AESUtilTest {

    @Test
    void testEncryptionDecryption() {
        String original = "secretData";
        String encrypted = AESUtil.encrypt(original);
        String decrypted = AESUtil.decrypt(encrypted);

        assertNotNull(encrypted);
        assertNotEquals(original, encrypted); // Ensure it's encrypted
        assertEquals(original, decrypted); // Ensure correct decryption
    }
}
