package org.example.BinarySearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Snapshot_Array_Test {

    @Test
    @DisplayName("Given example: set then snap then set again -> get returns value at snap time")
    void testGivenExample() {
        // Arrange
        Snapshot_Array arr = new Snapshot_Array(3);
        arr.set(0, 5);
        int s0 = arr.snap();
        arr.set(0, 6);

        // Act
        int result = arr.get_snap_id(0, s0);

        // Assert
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Get before any set or snap -> default value 0")
    void testGetBeforeAnySetOrSnap() {
        // Arrange
        Snapshot_Array arr = new Snapshot_Array(2);

        // Act
        int result = arr.get_snap_id(0, 0);

        // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Multiple snapshots on same index -> each snap preserves its own value")
    void testMultipleSnapshotsSameIndex() {
        // Arrange
        Snapshot_Array arr = new Snapshot_Array(1);
        arr.set(0, 10);
        int s0 = arr.snap();
        arr.set(0, 20);
        int s1 = arr.snap();
        arr.set(0, 30);

        // Act & Assert
        assertEquals(10, arr.get_snap_id(0, s0));
        assertEquals(20, arr.get_snap_id(0, s1));
        assertEquals(30, arr.get_snap_id(0, 2));
    }

    @Test
    @DisplayName("Multiple indices -> independent snapshot history")
    void testMultipleIndicesIndependent() {
        // Arrange
        Snapshot_Array arr = new Snapshot_Array(2);
        arr.set(0, 100);
        arr.set(1, 200);
        int s0 = arr.snap();
        arr.set(0, 999);

        // Act & Assert
        assertEquals(100, arr.get_snap_id(0, s0));
        assertEquals(200, arr.get_snap_id(1, s0));
    }

    @Test
    @DisplayName("Multiple sets before a single snap -> get returns latest set before snap")
    void testMultipleSetsBeforeSnap() {
        // Arrange
        Snapshot_Array arr = new Snapshot_Array(1);
        arr.set(0, 1);
        arr.set(0, 2);
        arr.set(0, 3);
        int s0 = arr.snap();

        // Act
        int result = arr.get_snap_id(0, s0);

        // Assert
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Snap taken with no prior set -> returns default value 0")
    void testSnapWithNoPriorSet() {
        // Arrange
        Snapshot_Array arr = new Snapshot_Array(1);
        int s0 = arr.snap();
        arr.set(0, 5);

        // Act
        int result = arr.get_snap_id(0, s0);

        // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Query an old snapshot after many later updates -> returns value at that snapshot")
    void testQueryOldSnapshotAfterLaterUpdates() {
        // Arrange
        Snapshot_Array arr = new Snapshot_Array(1);
        int s0 = arr.snap();
        arr.set(0, 5);
        int s1 = arr.snap();
        arr.set(0, 10);
        int s2 = arr.snap();

        // Act & Assert
        assertEquals(0, arr.get_snap_id(0, s0));
        assertEquals(5, arr.get_snap_id(0, s1));
        assertEquals(10, arr.get_snap_id(0, s2));
    }

    @Test
    @DisplayName("Large number of snapshots on one index -> binary search finds correct value")
    void testManySnapshotsStress() {
        // Arrange
        Snapshot_Array arr = new Snapshot_Array(1);
        int[] snapIds = new int[50];
        for (int i = 0; i < 50; i++) {
            arr.set(0, i * 10);
            snapIds[i] = arr.snap();
        }

        // Act & Assert
        assertEquals(0, arr.get_snap_id(0, snapIds[0]));
        assertEquals(250, arr.get_snap_id(0, snapIds[25]));
        assertEquals(490, arr.get_snap_id(0, snapIds[49]));
    }

    @Test
    @DisplayName("Set on one index does not affect another index's snapshot value")
    void testSetDoesNotLeakAcrossIndices() {
        // Arrange
        Snapshot_Array arr = new Snapshot_Array(3);
        arr.set(0, 42);
        int s0 = arr.snap();
        arr.set(1, 999);
        arr.set(2, 999);

        // Act
        int result = arr.get_snap_id(0, s0);

        // Assert
        assertEquals(42, result);
    }
}