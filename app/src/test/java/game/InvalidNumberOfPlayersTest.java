package game;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InvalidNumberOfPlayersTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Print print;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        print = new Print();
    }

    @Test(expected = NullPointerException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        String test = null;
        test.length();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenExceptionThrown_thenRuleIsApplied() throws InvalidNumberOfPlayersException {
        exceptionRule.expect(InvalidNumberOfPlayersException.class);
        exceptionRule.expectMessage("Please enter 1 or 2.");
        InvalidNumberOfPlayers.checkNumberOfPlayers("a");
    }

    @Test
    public void whenExceptionNotThrown_thenRuleIsApplied() throws InvalidNumberOfPlayersException {
        String expectedResult = "You have 1 player.\n";
        InvalidNumberOfPlayers.checkNumberOfPlayers("1");
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void whenExceptionNotThrown_thenRuleIsApplied2() throws InvalidNumberOfPlayersException {
        String expectedResult = "You have 2 players.\n";
        InvalidNumberOfPlayers.checkNumberOfPlayers("2");
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
