package org.example.Graph.BFS_ans_DFS_Question;

import org.example.Graph.BFS_AND_DFS_Question.Rotten_Oranges;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RottenOrangesTest {

    @Test
    void classicExampleTakesFourMinutes() {
        int[][] mat = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        assertEquals(4, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void unreachableFreshOrangeReturnsMinusOne() {
        int[][] mat = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        assertEquals(-1, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void noFreshOrangesReturnsZero() {
        int[][] mat = {
                {0, 2},
                {2, 0}
        };
        assertEquals(0, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void allZerosReturnsZero() {
        int[][] mat = {
                {0, 0},
                {0, 0}
        };
        assertEquals(0, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void singleCellZero() {
        int[][] mat = {{0}};
        assertEquals(0, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void singleCellRotten() {
        int[][] mat = {{2}};
        assertEquals(0, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void singleCellFreshNeverRots() {
        int[][] mat = {{1}};
        assertEquals(-1, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void freshOrangeBlockedByZeroWall() {
        int[][] mat = {
                {2, 0, 1}
        };
        assertEquals(-1, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void multipleSourcesRotFasterThanOne() {
        // rotten at both ends should reach the middle in 2 minutes, not 4
        int[][] mat = {
                {2, 1, 1, 1, 2}
        };
        assertEquals(2, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void allOrangesAlreadyRotten() {
        int[][] mat = {
                {2, 2},
                {2, 2}
        };
        assertEquals(0, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void diagonalFreshOrangeIsUnreachable() {
        // only diagonally adjacent to the rotten cell -> unreachable in 4-directional BFS
        int[][] mat = {
                {2, 0},
                {0, 1}
        };
        assertEquals(-1, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void twoByTwoAllReachable() {
        int[][] mat = {
                {2, 1},
                {1, 1}
        };
        assertEquals(2, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void samefreshCellAdjacentToTwoRottenSourcesNoDuplicateEnqueue() {
        // regresion check: previously, fresh cell between two rotten sources
        // could be enqueued twice in one round if not marked immediately
        int[][] mat = {
                {2, 1, 2}
        };
        assertEquals(1, new Rotten_Oranges().orangesRot(mat));
    }

    @Test
    void largerGridWithMultiplePockets() {
        int[][] mat = {
                {2, 1, 0, 0},
                {1, 1, 0, 2},
                {0, 0, 0, 1},
                {0, 1, 1, 1}
        };
        // (3,1) is reachable via (1,3) -> (2,3) -> (3,3) -> (3,2) -> (3,1), takes 4 minutes total
        assertEquals(4, new Rotten_Oranges().orangesRot(mat));
    }
}