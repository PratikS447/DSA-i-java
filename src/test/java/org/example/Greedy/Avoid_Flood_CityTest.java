package org.example.Greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Avoid_Flood_CityTest {

    @Test
    void testAvoidFloodSuccess() {
        int[] arr = {1, 2, 0, 0, 2, 1};
        // Expected: Rain on 1 & 2, dry lake 2 on day 2, dry lake 1 on day 3
        int[] expected = {-1, -1, 2, 1, -1, -1};
        int[] result = Avoid_Flood_City.avoid_flood(arr);
        assertArrayEquals(expected, result);
    }

    @Test
    void testAvoidFloodFailureNoDryDays() {
        int[] arr = {1, 2, 1, 2};
        // Lake 1 fills again before any dry day occurs -> Flood
        int[] expected = {};
        int[] result = Avoid_Flood_City.avoid_flood(arr);
        assertArrayEquals(expected, result);
    }

    @Test
    void testAvoidFloodFailureInsufficientDryDays() {
        int[] arr = {1, 2, 0, 1, 2};
        // Only 1 dry day available for 2 lakes that flood -> Flood
        int[] expected = {};
        int[] result = Avoid_Flood_City.avoid_flood(arr);
        assertArrayEquals(expected, result);
    }

    @Test
    void testAllDryDays() {
        int[] arr = {0, 0, 0};
        int[] expected = {1, 1, 1};
        int[] result = Avoid_Flood_City.avoid_flood(arr);
        assertArrayEquals(expected, result);
    }

    @Test
    void testNoDuplicateRains() {
        int[] arr = {1, 2, 3, 4};
        int[] expected = {-1, -1, -1, -1};
        int[] result = Avoid_Flood_City.avoid_flood(arr);
        assertArrayEquals(expected, result);
    }
}
