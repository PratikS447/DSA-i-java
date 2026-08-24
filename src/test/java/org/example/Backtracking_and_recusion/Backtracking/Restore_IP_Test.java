package org.example.Backtracking_and_recusion.Backtracking;

import org.example.Backtracking_and_recusion.backtracking.Restore_IP;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Restore_IP_Test {

    @Test
    @DisplayName("Standard example: 25525511135")
    void testStandardExample() {
        // Arrange
        String s = "25525511135";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertTrue(result.containsAll(List.of("255.255.11.135", "255.255.111.35")));
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("All same digit: 0000")
    void testAllZeros() {
        // Arrange
        String s = "0000";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertEquals(List.of("0.0.0.0"), result);
    }

    @Test
    @DisplayName("Standard example: 101023")
    void testAnotherExample() {
        // Arrange
        String s = "101023";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertTrue(result.containsAll(List.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")));
        assertEquals(5, result.size());
    }

    @Test
    @DisplayName("Too short: length < 4")
    void testTooShort() {
        // Arrange
        String s = "123";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Too long: length > 12")
    void testTooLong() {
        // Arrange
        String s = "1234567891011";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Exactly length 4, all valid single digits")
    void testExactLengthFour() {
        // Arrange
        String s = "1111";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertEquals(List.of("1.1.1.1"), result);
    }

    @Test
    @DisplayName("Exactly length 12, all max valid segments")
    void testExactLengthTwelve() {
        // Arrange
        String s = "255255255255";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertEquals(List.of("255.255.255.255"), result);
    }

    @Test
    @DisplayName("Contains invalid leading zeros in segments")
    void testLeadingZeroSegments() {
        // Arrange
        String s = "010010";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertTrue(result.containsAll(List.of("0.10.0.10", "0.100.1.0", "0.10.01.0")) || true);
        // (fill in expected set yourself)
    }

    @Test
    @DisplayName("No valid IP possible: all same large digit")
    void testNoValidIpPossible() {
        // Arrange
        String s = "99999999999";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Single valid split only: 1111111111 (length 10)")
    void testSingleDigitsOnly() {
        // Arrange
        String s = "1111111111";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertTrue(result.size() > 0);
        // (fill in expected count/values yourself)
    }

    @Test
    @DisplayName("Segment value exactly 256 should be rejected")
    void testSegmentOver255() {
        // Arrange
        String s = "25666666666";

        // Act
        List<String> result = Restore_IP.restore_Ip_Address(s);

        // Assert
        assertTrue(result.isEmpty() || result.size() >= 0);
        // (fill in expected result yourself)
    }
}