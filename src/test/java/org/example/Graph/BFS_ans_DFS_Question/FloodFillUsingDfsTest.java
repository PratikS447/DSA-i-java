package org.example.Graph.BFS_ans_DFS_Question;

import org.example.Graph.BFS_AND_DFS_Question.Flood_Fill_Using_Dfs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FloodFillUsingDfsTest {

    @Test
    @DisplayName("Basic flood fill from LeetCode example")
    void testBasicFloodFill() {
        // Arrange
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] expected = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };

        // Act
        int[][] result = Flood_Fill_Using_Dfs.flood_fill(image, 1, 1, 2);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("New color same as starting color returns image unchanged")
    void testNewColorSameAsOldColor() {
        // Arrange
        int[][] image = {
                {0, 0, 0},
                {0, 1, 1}
        };
        int[][] expected = {
                {0, 0, 0},
                {0, 1, 1}
        };

        // Act
        int[][] result = Flood_Fill_Using_Dfs.flood_fill(image, 1, 1, 1);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Single cell image gets filled")
    void testSingleCellImage() {
        // Arrange
        int[][] image = {{0}};
        int[][] expected = {{5}};

        // Act
        int[][] result = Flood_Fill_Using_Dfs.flood_fill(image, 0, 0, 5);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Entire uniform grid gets filled with new color")
    void testUniformGridFillsCompletely() {
        // Arrange
        int[][] image = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {9, 9, 9},
                {9, 9, 9},
                {9, 9, 9}
        };

        // Act
        int[][] result = Flood_Fill_Using_Dfs.flood_fill(image, 0, 0, 9);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Fill does not cross into disconnected region of same color")
    void testDoesNotCrossDisconnectedRegion() {
        // Arrange: two 1-colored regions separated by a 0-wall
        int[][] image = {
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1}
        };
        int[][] expected = {
                {3, 3, 0, 1, 1},
                {3, 3, 0, 1, 1}
        };

        // Act
        int[][] result = Flood_Fill_Using_Dfs.flood_fill(image, 0, 0, 3);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Starting pixel on the border of the grid")
    void testStartOnBorder() {
        // Arrange
        int[][] image = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] expected = {
                {4, 4, 4},
                {4, 4, 4},
                {4, 4, 4}
        };

        // Act
        int[][] result = Flood_Fill_Using_Dfs.flood_fill(image, 2, 2, 4);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Diagonal cells are not filled (only 4-directional)")
    void testDiagonalNotConnected() {
        // Arrange: diagonal 1s should stay untouched since flood fill is 4-directional
        int[][] image = {
                {1, 0},
                {0, 1}
        };
        int[][] expected = {
                {7, 0},
                {0, 1}
        };

        // Act
        int[][] result = Flood_Fill_Using_Dfs.flood_fill(image, 0, 0, 7);

        // Assert
        assertArrayEquals(expected, result);
    }
}