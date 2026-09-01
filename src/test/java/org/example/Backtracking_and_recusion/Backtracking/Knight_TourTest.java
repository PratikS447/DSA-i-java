package org.example.Backtracking_and_recusion.Backtracking;

import org.example.Backtracking_and_recusion.backtracking.Knight_Tour;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Knight_Tour.
 *
 * Because the knight's tour has many valid solutions for a given n
 * (the exact path returned isn't fixed), these tests don't compare
 * against one hardcoded expected grid. Instead, isValidTour() checks
 * that whatever grid comes back genuinely satisfies the rules of a
 * knight's tour: every cell visited exactly once, and each
 * consecutive step is a legal knight move away from the last.
 */
class Knight_TourTest {

    private final Knight_Tour solution = new Knight_Tour();

    // All the (dr, dc) offsets a legal knight move can have.
    private static final int[][] KNIGHT_DELTAS = {
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };

    private boolean isKnightMove(int r1, int c1, int r2, int c2) {
        int dr = r2 - r1;
        int dc = c2 - c1;
        for (int[] delta : KNIGHT_DELTAS) {
            if (delta[0] == dr && delta[1] == dc) return true;
        }
        return false;
    }

    /**
     * Validates that `grid` is a genuine n x n knight's tour:
     * - correct dimensions
     * - contains every value 0..n*n-1 exactly once
     * - consecutive step numbers are knight-move-adjacent on the board
     * - step 0 is at (0, 0), matching the stated starting square
     */
    private void assertValidTour(ArrayList<ArrayList<Integer>> grid, int n) {
        assertEquals(n, grid.size(), "grid should have n rows");
        for (ArrayList<Integer> row : grid) {
            assertEquals(n, row.size(), "each row should have n columns");
        }

        // Map step number -> (row, col), and check every value 0..n*n-1 appears exactly once.
        int[] rowOf = new int[n * n];
        int[] colOf = new int[n * n];
        Set<Integer> seen = new HashSet<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int step = grid.get(r).get(c);
                assertTrue(step >= 0 && step < n * n,
                        "step value out of range: " + step);
                assertTrue(seen.add(step),
                        "step " + step + " appears more than once");
                rowOf[step] = r;
                colOf[step] = c;
            }
        }
        assertEquals(n * n, seen.size(), "not all step numbers 0.." + (n * n - 1) + " were used");

        // Starting square must be (0, 0).
        assertEquals(0, rowOf[0], "step 0 should be at row 0");
        assertEquals(0, colOf[0], "step 0 should be at col 0");

        // Every consecutive pair of steps must be a legal knight move apart.
        for (int step = 0; step < n * n - 1; step++) {
            assertTrue(
                    isKnightMove(rowOf[step], colOf[step], rowOf[step + 1], colOf[step + 1]),
                    "step " + step + " -> " + (step + 1) + " is not a valid knight move"
            );
        }
    }

    @Test
    void n1_trivialSingleCellBoard() {
        ArrayList<ArrayList<Integer>> result = solution.tour(1);
        assertValidTour(result, 1);
        assertEquals(0, result.get(0).get(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void noTourExists_returnsEmptyResult(int n) {
        // It's a known result that no open knight's tour exists on
        // 2x2, 3x3, or 4x4 boards. This implementation returns an
        // empty ArrayList in that case (found == false).
        ArrayList<ArrayList<Integer>> result = solution.tour(n);
        assertTrue(result.isEmpty(),
                "expected no tour to be found for n=" + n + ", but got: " + result);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8})
    void tourExists_isValidForVariousBoardSizes(int n) {
        ArrayList<ArrayList<Integer>> result = solution.tour(n);
        assertFalse(result.isEmpty(), "expected a tour to be found for n=" + n);
        assertValidTour(result, n);
    }

    @Test
    void n0_edgeCase_throwsRatherThanReturningEmpty() {
        // NOTE: this documents an actual bug, not desired behavior.
        // With n=0, `mat` is a 0-length array, so `mat[0][0] = 0`
        // in tour() throws ArrayIndexOutOfBoundsException before the
        // helper()/found logic is ever reached. If tour(0) should
        // instead return an empty list, tour() needs an early
        // `if (n == 0) return new ArrayList<>();` guard.
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> solution.tour(0));
    }
}