package ro.sci.ale.ian09.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void fahrenheitToCelsiusTest() {
        double result = Temperature.fahrenheitToCelsius(98.6);
        assertEquals(37, result);
    }

    @Test
    void fahrenheitToCelsiusEquals() {
        double result = Temperature.fahrenheitToCelsius(98.6);
        assertNotEquals(-37, result);

    }
}

