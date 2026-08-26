package org.example.Stack_and_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Design_queue_using_stack_test {
    @Test
    void testPushAndPop() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        assertEquals(10, queue.pop());
        assertEquals(20, queue.pop());
        assertEquals(30, queue.pop());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testPeek() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        queue.push(5);
        queue.push(15);

        assertEquals(5, queue.peek());
        assertEquals(5, queue.peek()); // Peek should not remove
        assertEquals(5, queue.pop());
        assertEquals(15, queue.peek());
    }

    @Test
    void testEmptyQueue() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        assertTrue(queue.isEmpty());
        assertEquals(-1, queue.pop());
        assertEquals(-1, queue.peek());
    }

    @Test
    void testSingleElement() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        queue.push(100);

        assertFalse(queue.isEmpty());
        assertEquals(100, queue.peek());
        assertEquals(100, queue.pop());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testInterleavedOperations() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        queue.push(1);
        queue.push(2);

        assertEquals(1, queue.pop());

        queue.push(3);

        assertEquals(2, queue.peek());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());

        assertTrue(queue.isEmpty());
    }

    @Test
    void testMultiplePushes() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        for (int i = 1; i <= 100; i++) {
            queue.push(i);
        }

        for (int i = 1; i <= 100; i++) {
            assertEquals(i, queue.pop());
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    void testNegativeNumbers() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        queue.push(-10);
        queue.push(-20);

        assertEquals(-10, queue.peek());
        assertEquals(-10, queue.pop());
        assertEquals(-20, queue.pop());
    }

    @Test
    void testDuplicateValues() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        queue.push(7);
        queue.push(7);
        queue.push(7);

        assertEquals(7, queue.pop());
        assertEquals(7, queue.pop());
        assertEquals(7, queue.pop());

        assertTrue(queue.isEmpty());
    }

    @Test
    void testPopAfterQueueBecomesEmpty() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        queue.push(1);

        assertEquals(1, queue.pop());
        assertEquals(-1, queue.pop());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testPeekAfterQueueBecomesEmpty() {
        Design_queue_using_stack queue = new Design_queue_using_stack();

        queue.push(50);

        assertEquals(50, queue.pop());
        assertEquals(-1, queue.peek());
    }
}
