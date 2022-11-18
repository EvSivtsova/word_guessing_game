package game;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class InvalidGuessedLetterTest {

    @Test(expected = NullPointerException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        String test = null;
        test.length();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenExceptionThrown_thenRuleIsApplied_WhenNumber() throws InvalidGuessedLetterException {
        exceptionRule.expect(InvalidGuessedLetterException.class);
        exceptionRule.expectMessage("Please enter a letter.");
        InvalidGuessedLetter.checkGuessedLetter('1');
    }

    @Test
    public void whenExceptionThrown_thenRuleIsApplied_WhenSymbol() throws InvalidGuessedLetterException {
        exceptionRule.expect(InvalidGuessedLetterException.class);
        exceptionRule.expectMessage("Please enter a letter.");
        InvalidGuessedLetter.checkGuessedLetter('&');
    }

    @Test
    public void whenExceptionNotThrown_thenRuleIsApplied() throws InvalidGuessedLetterException {
        InvalidGuessedLetter.checkGuessedLetter('a');
    }

    @Test
    public void whenExceptionNotThrown_thenRuleIsApplied2() throws InvalidGuessedLetterException {
        InvalidGuessedLetter.checkGuessedLetter('Z');
    }
}
