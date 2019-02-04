package ro.sci.ale.ian09.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidationTest {

    @Test
    void validateDateTrue() {
        assertTrue(DataValidation.validateDate(02, 03));
    }

    @Test
    void validateDateFalse() {
        assertFalse(DataValidation.validateDate(-02, -03));
    }
}