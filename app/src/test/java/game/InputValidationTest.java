package game;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InputValidationTest {
    @Test
    public void testValidatesGuessedLetter() {
        char letter = 'A';
        InputValidation check = new InputValidation();
        assertTrue("Returns true of char is a letter", check.validateLetter(letter));
    }
}
