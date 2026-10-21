package CodeForce;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class BMaximumTest {

    // ---------- Basic hand-checked cases ----------

    @Test
    void kIsZero_returnsFullSum() {
        assertEquals(6, BMaximum.BMaximum(new long[]{3, 1, 2}, 0));
    }

    @Test
    void k1_prefersRemovingTwoSmallest() {
        // x=0: remove 5 -> 10 | x=1: remove 1,2 -> 12
        assertEquals(12, BMaximum.BMaximum(new long[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    void k2_mixOfBothOperations() {
        // x=0: 6 | x=1: remove 1,2 and 5 -> 7 | x=2: 5
        assertEquals(7, BMaximum.BMaximum(new long[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    void unsortedInput_sameAsSorted() {
        assertEquals(7, BMaximum.BMaximum(new long[]{5, 1, 4, 2, 3}, 2));
    }

    @Test
    void duplicates() {
        // x=0: remove one 5 -> 5 | x=1: remove both 5s -> 0
        assertEquals(5, BMaximum.BMaximum(new long[]{5, 5}, 1));
    }

    // ---------- Edge cases ----------

    @Test
    void singleElement_kZero() {
        assertEquals(10, BMaximum.BMaximum(new long[]{10}, 0));
    }

    @Test
    void singleElement_kOne_removesEverything() {
        assertEquals(0, BMaximum.BMaximum(new long[]{10}, 1));
    }

    @Test
    void kEqualsN_onlyLargestRemovalsFeasible() {
        assertEquals(0, BMaximum.BMaximum(new long[]{1, 2, 3}, 3));
    }

    @Test
    void allEqualElements() {
        // 4 elements of 7, k=2: remove 2 smallest (x=1, +1 largest) leaves 1 -> 7;
        // x=0 leaves 2 -> 14; best is 14
        assertEquals(14, BMaximum.BMaximum(new long[]{7, 7, 7, 7}, 2));
    }

    @Test
    void largeValues_noOverflow() {
        long big = 1_000_000_000_000_000_000L;
        assertEquals(3 * big, BMaximum.BMaximum(new long[]{big, big, big}, 0));
    }

    // ---------- Randomized check against brute force ----------

    @Test
    void randomizedAgainstBruteForce() {
        Random rnd = new Random(42);
        for (int iter = 0; iter < 2000; iter++) {
            int n = 1 + rnd.nextInt(8);
            int k = rnd.nextInt(n + 1);              // k <= n is always feasible
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(20);   // non-negative

            List<Long> list = new ArrayList<>();
            for (long v : arr) list.add(v);
            Collections.sort(list);

            long expected = brute(list, k);
            long actual = BMaximum.BMaximum(arr.clone(), k);
            assertEquals(expected, actual,
                "arr=" + Arrays.toString(arr) + " k=" + k);
        }
    }

    // Tries both operations at every step; `sorted` is always kept sorted.
    private static long brute(List<Long> sorted, int k) {
        if (k == 0) return sorted.stream().mapToLong(Long::longValue).sum();
        long best = Long.MIN_VALUE;
        if (sorted.size() >= 2) {                     // remove two smallest
            best = Math.max(best, brute(sorted.subList(2, sorted.size()), k - 1));
        }
        if (sorted.size() >= 1) {                     // remove largest
            best = Math.max(best, brute(sorted.subList(0, sorted.size() - 1), k - 1));
        }
        return best;
    }
}