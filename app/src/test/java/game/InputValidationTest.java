package game;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidationTest {
    @Test
    public void testValidatesGuessedLetter() {
        char letter = 'A';
        InputValidation check = new InputValidation();
        assertTrue("Returns true of char is a letter", check.validateLetter(letter));
    }

    @Test
    public void testValidatesGuessedLetter_WhenNotALetter() {
        char letter = '1';
        InputValidation check = new InputValidation();
        assertFalse("Returns false of char is not a letter", check.validateLetter(letter));
    }
}
