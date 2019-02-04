package ro.sci.ale.ian09.max;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ro.sci.ale.ian09.max.MaxNumber.getMax;

class MaxNumberTest {

    @org.junit.jupiter.api.Test
    void main() {
        int num1 = 10;
        int num2 = 5;
        int num3 = 8;
        int result = getMax(getMax(num1, num2), num3);

        assertEquals(10, result);
    }

    @Test
    void mainEquals() {
        assertEquals(10, getMax(getMax(10, 10), 10));
    }

    @Test
    void getMaxBiggest() {
        assertEquals(11, getMax(5, 11));
    }

    @Test
    void getMaxEquals() {
        assertEquals(10, getMax(10, 10));
    }
}