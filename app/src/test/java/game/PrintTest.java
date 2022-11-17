package game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintTest {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Print print;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        print = new Print();
    }

    @Test
    public void testAsksToInputPlayerNumber() {
        print.askToInputPlayerNumber();
        Assert.assertEquals("\nPlease enter the number of players: 1 or 2\n", outContent.toString());
    }

    @Test
    public void testAsksToInputPlayerName_OnePlayerGame() {
        print.askToEnterNameForOnePlayer();
        Assert.assertEquals("\nPlease enter your name:\n", outContent.toString());
    }

    @Test
    public void testDisplaysWelcomeMessage_OnePlayerGame() {
        String expectedResult = "\n" + ANSI_BLUE + "Welcome, Alex! Today the word to guess is:" + ANSI_RESET + "\n\n";

        String playerName = "Alex";
        print.displayWelcomeMessageOnePlayer(playerName);
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testDisplaysWordToGuess_OnePlayerGame() {
        String expectedResult = ANSI_GREEN + "word" + ANSI_RESET + "\n\n";

        String word = "word";
        print.displayWordToGuessOnePlayer(word);
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testAsksToInputLetter() {
        String expectedResult = "Enter one letter to guess (10 attempts remaining):\n";

        Integer remainingAttempts = 10;
        print.askToInputLetter(remainingAttempts);
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPrintsThatTheGuessIsCorrect() {
        print.printThatTheGuessIsCorrect();
        Assert.assertEquals("Right!\n\n", outContent.toString());
    }

    @Test
    public void testPrintsThatTheGuessIsWrong() {
        print.printThatTheGuessIsWrong();
        Assert.assertEquals("Wrong...\n\n", outContent.toString());
    }

    @Test
    public void testCongratulatesWinner_OnePlayerGame() {
        String expectedResult = ANSI_BLUE_BACKGROUND + ANSI_BLACK + "         Congratulations, Alex! You won!          " + ANSI_RESET + "\n\n";

        String playerName = "Alex";
        print.congratulateWinner(playerName);
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testDisplaysYouLostMessage() {
        String expectedResult = ANSI_YELLOW + "Alex, you lost this time! Try your luck again!" + ANSI_RESET + "\n\n";

        String playerName = "Alex";
        print.displayYouLostMessage(playerName);
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
