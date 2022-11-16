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

    @Test
    public void testValidatesName() {
        String name = "Steve";
        InputValidation check = new InputValidation();
        assertTrue("Returns true of name contains only letters", check.validateName(name));
    }

    @Test
    public void testValidatesName_WhenItContainsNumbers() {
        String name = "123";
        InputValidation check = new InputValidation();
        assertFalse("Returns false of name contains numbers", check.validateName(name));
    }

    @Test
    public void testValidatesName2() {
        String name = "Sara";
        InputValidation check = new InputValidation();
        assertTrue("Returns true of name contains only letters", check.validateName(name));
    }

    @Test
    public void testValidatesName3() {
        String name = "Alex";
        InputValidation check = new InputValidation();
        assertTrue("Returns true of name contains only letters", check.validateName(name));
    }

    @Test
    public void testValidatesName_WhenItContainsSymbols() {
        String name = "Alex&";
        InputValidation check = new InputValidation();
        assertFalse("Returns false of name contains symbols", check.validateName(name));
    }

    @Test
    public void testValidatesNumberOfPlayers_WhenItIs1() {
        String numberOfPlayer = "1";
        InputValidation check = new InputValidation();
        assertTrue("Returns true of number of players is 1", check.validateNumberOfPlayers(numberOfPlayer));
    }

    @Test
    public void testValidatesNumberOfPlayers_WhenItIsNotANumber() {
        String numberOfPlayer = "A";
        InputValidation check = new InputValidation();
        assertFalse("Returns false of number of players is not a number", check.validateNumberOfPlayers(numberOfPlayer));
    }

    @Test
    public void testValidatesNumberOfPlayers_WhenItIs2() {
        String numberOfPlayer = "2";
        InputValidation check = new InputValidation();
        assertTrue("Returns true of number of players is 2", check.validateNumberOfPlayers(numberOfPlayer));
    }
}
