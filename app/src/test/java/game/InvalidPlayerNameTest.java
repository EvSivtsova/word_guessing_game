package game;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InvalidPlayerNameTest {

    @Test(expected = NullPointerException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        String test = null;
        test.length();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenExceptionThrown_thenRuleIsApplied_WhenHasNumber() throws InvalidPlayerNameException {
        exceptionRule.expect(InvalidPlayerNameException.class);
        exceptionRule.expectMessage("Please only use letters, try again");
        InvalidPlayerName.checkPlayerName("Alex1");
    }

    @Test
    public void whenExceptionThrown_thenRuleIsApplied_WhenHasSymbol() throws InvalidPlayerNameException {
        exceptionRule.expect(InvalidPlayerNameException.class);
        exceptionRule.expectMessage("Please only use letters, try again");
        InvalidPlayerName.checkPlayerName("Alex&");
    }

    @Test
    public void whenExceptionNotThrown_thenRuleIsApplied() throws InvalidPlayerNameException {
        InvalidPlayerName.checkPlayerName("Alex");
    }
}