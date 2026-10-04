package org.example.DynamicProgramming.Dp_1_Dimensional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Runs the same cases against both Frog_jump implementations (memoization + tabulation).
 * Inputs follow the LeetCode 403 contract: at least 2 stones, sorted, strictly increasing, first stone at 0.
 */
class Frog_jumpTest {

    // ---------- Providers ----------

    static Stream<Named<Predicate<int[]>>> implementations() {
        return Stream.of(
                Named.of("memoization", s -> new Frog_jump().memoization(s)),
                Named.of("tabulation", s -> new Frog_jump().tabulation(s))
        );
    }

    /** Every (stones, expected) case runs against every implementation. */
    static Stream<Arguments> knownCases() {
        Object[][] data = {
                // ----- frog can cross -----
                {new int[]{0, 1, 3, 5, 6, 8, 12, 17}, true},              // LeetCode example 1
                {new int[]{0, 1}, true},                                  // single valid first jump
                {new int[]{0, 1, 2}, true},                               // 1, 1
                {new int[]{0, 1, 3}, true},                               // 1, 2
                {new int[]{0, 1, 3, 6, 10, 15, 21, 28}, true},            // triangular numbers: jumps 1,2,3,4,5,6,7
                {new int[]{0, 1, 3, 6, 10, 15, 16, 21}, true},            // needs a larger jump (6) to skip stone 16
                {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, true},          // all jumps of size 1

                // ----- frog cannot cross -----
                {new int[]{0, 1, 2, 3, 4, 8, 9, 11}, false},              // LeetCode example 2: gap of 4 after k=1
                {new int[]{0, 2}, false},                                 // first jump must be exactly 1
                {new int[]{0, 5, 6}, false},                              // first jump must be exactly 1
                {new int[]{0, 1, 4}, false},                              // would need a jump of 3 after a jump of 1
                {new int[]{0, 1, 3, 6, 7}, false},                        // last jump was 3, so 1 is not allowed
                {new int[]{0, 1, 2, 3, 100}, false},                      // huge final gap
                {new int[]{0, 1, 3, 6, 10, 13, 15, 16, 19, 21, 25}, false},
                {new int[]{0, 1, Integer.MAX_VALUE}, false}               // stones[i] + k must not overflow into a false match
        };
        return implementations().flatMap(impl ->
                Stream.of(data).map(row -> Arguments.of(impl, row[0], row[1])));
    }

    // ---------- Known input/output pairs ----------

    @ParameterizedTest(name = "[{0}] {1} -> {2}")
    @MethodSource("knownCases")
    @DisplayName("Known input/output pairs")
    void knownCases(Predicate<int[]> canCross, int[] stones, boolean expected) {
        assertEquals(expected, canCross.test(stones));
    }

    // ---------- Behaviour checks ----------

    @ParameterizedTest(name = "[{0}]")
    @MethodSource("implementations")
    @DisplayName("Does not modify the input array")
    void doesNotMutateInput(Predicate<int[]> canCross) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] copy = Arrays.copyOf(stones, stones.length);
        canCross.test(stones);
        assertEquals(Arrays.toString(copy), Arrays.toString(stones));
    }

    @Test
    @DisplayName("Same instance can be reused across calls (both methods)")
    void reusableInstance() {
        Frog_jump obj = new Frog_jump();
        int[] reachable = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] unreachable = {0, 1, 2, 3, 4, 8, 9, 11};
        assertTrue(obj.memoization(reachable));
        assertFalse(obj.memoization(unreachable));
        assertTrue(obj.tabulation(reachable));
        assertFalse(obj.tabulation(unreachable));
        assertTrue(obj.memoization(reachable));
    }

    @Test
    @DisplayName("memoization: single stone means the frog is already on the last stone")
    void singleStoneMemoization() {
        // Note: tabulation() reads stones[1] unconditionally, so it throws
        // ArrayIndexOutOfBoundsException for a 1-stone input. LeetCode guarantees n >= 2,
        // so that case is intentionally not tested for tabulation.
        assertTrue(new Frog_jump().memoization(new int[]{0}));
    }

    // ---------- Cross-check ----------

    @Test
    @DisplayName("Memoization and tabulation agree on random valid inputs")
    void implementationsAgreeOnRandomInput() {
        Frog_jump obj = new Frog_jump();
        Random random = new Random(42); // fixed seed -> reproducible failures
        for (int i = 0; i < 500; i++) {
            int[] stones = randomStones(random, 2 + random.nextInt(12), 40);
            assertEquals(obj.memoization(stones), obj.tabulation(stones),
                    "Mismatch for " + Arrays.toString(stones));
        }
    }

    /** Sorted, distinct stones starting 0, 1 (so the first jump is always possible). */
    private static int[] randomStones(Random random, int count, int maxPosition) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(1);
        while (set.size() < count) {
            set.add(random.nextInt(maxPosition));
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    // ---------- Larger input (LeetCode max n = 2000) ----------

    @ParameterizedTest(name = "[{0}]")
    @MethodSource("implementations")
    @DisplayName("2000 consecutive stones -> true")
    void largeReachable(Predicate<int[]> canCross) {
        int[] stones = IntStream.range(0, 2000).toArray();
        assertTrue(canCross.test(stones));
    }

    @ParameterizedTest(name = "[{0}]")
    @MethodSource("implementations")
    @DisplayName("2000 stones with an unreachable last stone -> false")
    void largeUnreachable(Predicate<int[]> canCross) {
        int[] stones = IntStream.range(0, 2000).toArray();
        stones[1999] = 5000; // gap far larger than any reachable jump
        assertFalse(canCross.test(stones));
    }
}