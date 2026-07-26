package org.example.Stack_ans_Queue;

import org.example.Stack_and_Queue.Asteroids_collision;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Asteroids_collision_test {

    @Test
    void testExample1() {
        int[] asteroids = {5, 10, -5};
        assertEquals(List.of(5, 10),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testEqualSizeCollision() {
        int[] asteroids = {8, -8};
        assertEquals(List.of(),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testLeftAsteroidWins() {
        int[] asteroids = {10, 2, -5};
        assertEquals(List.of(10),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testRightAsteroidWins() {
        int[] asteroids = {4, 3, -10};
        assertEquals(List.of(-10),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testNoCollisionAllPositive() {
        int[] asteroids = {1, 2, 3, 4};
        assertEquals(List.of(1, 2, 3, 4),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testNoCollisionAllNegative() {
        int[] asteroids = {-1, -2, -3};
        assertEquals(List.of(-1, -2, -3),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testMultipleCollisions() {
        int[] asteroids = {1, 2, 3, -5};
        assertEquals(List.of(-5),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testNegativeBeforePositive() {
        int[] asteroids = {-2, -1, 1, 2};
        assertEquals(List.of(-2, -1, 1, 2),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testChainCollision() {
        int[] asteroids = {3, 5, -2, -5};
        assertEquals(List.of(3),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testSinglePositive() {
        int[] asteroids = {7};
        assertEquals(List.of(7),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testSingleNegative() {
        int[] asteroids = {-7};
        assertEquals(List.of(-7),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testEmptyArray() {
        int[] asteroids = {};
        assertEquals(List.of(),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testLargeChain() {
        int[] asteroids = {10, 5, -2, -5, -20};
        assertEquals(List.of(-20),
                Asteroids_collision.collision(asteroids));
    }

    @Test
    void testComplexCase() {
        int[] asteroids = {-2, -2, 1, -2};
        assertEquals(List.of(-2, -2, -2),
                Asteroids_collision.collision(asteroids));
    }
}