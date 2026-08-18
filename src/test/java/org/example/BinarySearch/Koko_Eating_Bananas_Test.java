package org.example.BinarySearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Koko_Eating_Bananas_Test {

    @Test
    @DisplayName("Classic example: [3,6,7,11], hrs=8 -> 4")
    void testClassicExample() {
        // Arrange
        int[] piles = {3, 6, 7, 11};
        int hrs = 8;
        // Act
        int result = Koko_Eating_Bananas.eating_bananas(piles, hrs);
        // Assert
        assertEquals(4, result);
    }

    @Test
    @DisplayName("hrs equals number of piles -> forces max speed")
    void testHoursEqualsPiles() {
        // Arrange: with hrs == arr.length, Koko must finish each pile in 1 hour
        int[] piles = {30, 11, 23, 4, 20};
        int hrs = 5;
        // Act
        int result = Koko_Eating_Bananas.eating_bananas(piles, hrs);
        // Assert
        assertEquals(30, result); // must eat fastest pile in one sitting
    }

    @Test
    @DisplayName("Generous hours -> minimum speed of 1 suffices")
    void testAmpleHours() {
        // Arrange
        int[] piles = {30, 11, 23, 4, 20};
        int hrs = 100; // way more hours than needed
        // Act
        int result = Koko_Eating_Bananas.eating_bananas(piles, hrs);
        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Single pile, exact division")
    void testSinglePileExactDivision() {
        // Arrange
        int[] piles = {10};
        int hrs = 2;
        // Act
        int result = Koko_Eating_Bananas.eating_bananas(piles, hrs);
        // Assert
        assertEquals(5, result); // 10/5 = 2 hrs exactly
    }

    @Test
    @DisplayName("Single pile, non-exact division requires ceiling")
    void testSinglePileCeilingDivision() {
        // Arrange
        int[] piles = {11};
        int hrs = 3;
        // Act
        int result = Koko_Eating_Bananas.eating_bananas(piles, hrs);
        // Assert
        assertEquals(4, result); // ceil(11/4)=3 <=3hrs; ceil(11/3)=4>3hrs, so 4 is min
    }

    @Test
    @DisplayName("All piles equal size")
    void testAllPilesEqual() {
        // Arrange
        int[] piles = {5, 5, 5, 5};
        int hrs = 4;
        // Act
        int result = Koko_Eating_Bananas.eating_bananas(piles, hrs);
        // Assert
        assertEquals(5, result); // 1 hour per pile forces eating whole pile at once
    }

    @Test
    @DisplayName("One large pile among small ones")
    void testOneDominantPile() {
        // Arrange
        int[] piles = {1, 1, 1, 1000000000};
        int hrs = 4;
        // Act
        int result = Koko_Eating_Bananas.eating_bananas(piles, hrs);
        // Assert
        assertEquals(1000000000, result); // only 1 hr left for the huge pile
    }

    @Test
    @DisplayName("hrs exactly length of array with mixed sizes")
    void testTightHoursMixedPiles() {
        // Arrange
        int[] piles = {312884469};
        int hrs = 968709470;
        // Act
        int result = Koko_Eating_Bananas.eating_bananas(piles, hrs);
        // Assert
        assertEquals(1, result); // hrs far exceeds what's needed even at speed 1
    }

    @Test
    @DisplayName("Two piles requiring boundary check between candidate speeds")
    void testBoundarySpeedCheck() {
        // Arrange
        int[] piles = {30, 30};
        int hrs = 4;
        // Act
        int result = Koko_Eating_Bananas.eating_bananas(piles, hrs);
        // Assert
        // speed 15: ceil(30/15)=2 each -> total 4 <= 4 ✓
        // speed 14: ceil(30/14)=3 each -> total 6 > 4 ✗
        assertEquals(15, result);
    }
}