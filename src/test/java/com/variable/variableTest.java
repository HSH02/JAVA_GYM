package com.variable;

import org.junit.jupiter.api.Test;

import static com.variable.variable.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class variableTest {

    @Test
    public void testBitwiseOperations() {
        int a = 9; // 0000 1001
        int b = 3; // 0000 0011


        assertEquals(1, and(a, b));
        assertEquals(11, or(a, b));
        assertEquals(10, xor(a, b));
        assertEquals(-10, not(a));
        assertEquals(16, leftShift(2, 3));
        assertEquals(1, rightShift(8, 3));
        assertEquals(0, shiftLeftWithNoSign(2, 3));
    }


}
