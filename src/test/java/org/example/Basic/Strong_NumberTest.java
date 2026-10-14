package org.example.Basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Strong_NumberTest {

    // ---------- isStrong ----------

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 8, 9, 16, 25, 27, 32, 36, 72, 100, 108})
    void isStrong_returnsTrue_forPowerfulNumbers(int n) {
        assertTrue(Strong_Number.isStrong(n), n + " should be strong");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 6, 10, 12, 18, 20, 24, 30, 45, 97})
    void isStrong_returnsFalse_forNonPowerfulNumbers(int n) {
        assertFalse(Strong_Number.isStrong(n), n + " should NOT be strong");
    }

    @Test
    void isStrong_primesAreNeverStrong() {
        // a prime p has p but not p*p as a divisor
        assertFalse(Strong_Number.isStrong(7));
        assertFalse(Strong_Number.isStrong(13));
        assertFalse(Strong_Number.isStrong(101));
    }

    @Test
    void isStrong_primeSquaresAndCubesAreStrong() {
        assertTrue(Strong_Number.isStrong(49));   // 7^2
        assertTrue(Strong_Number.isStrong(125));  // 5^3
    }

    @Test
    void isStrong_mixedFactors_oneBadFactorBreaksIt() {
        assertTrue(Strong_Number.isStrong(36));   // 2^2 * 3^2
        assertFalse(Strong_Number.isStrong(12));  // 2^2 * 3^1
        assertFalse(Strong_Number.isStrong(18));  // 2^1 * 3^2
    }

    @Test
    void isStrong_zeroAndNegatives_shouldBeFalse() {
        // Decide your contract: these are the sensible expectations
        assertFalse(Strong_Number.isStrong(0));
        assertFalse(Strong_Number.isStrong(-4));
    }

    // ---------- isPrime ----------

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 97})
    void isPrime_returnsTrue_forPrimes(int n) {
        assertTrue(Strong_Number.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 15, 25, 49, 100})
    void isPrime_returnsFalse_forComposites(int n) {
        assertFalse(Strong_Number.isPrime(n), n + " is composite");
    }

    @ParameterizedTest
    @ValueSource(ints = {-7, 0, 1})
    void isPrime_returnsFalse_forNumbersBelowTwo(int n) {
        assertFalse(Strong_Number.isPrime(n));
    }
}