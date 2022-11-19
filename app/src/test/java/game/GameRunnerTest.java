package game;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameRunnerTest {
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Print print;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        print = new Print();
    }
    @Test
    public void testCongratulatesWinner_WhenOnePlayerGame() {
        Game game = mock(Game.class);
        when(game.gameWon()).thenReturn(true);
        when(game.getPlayerName()).thenReturn("Alex");
        String expectedResult = ANSI_BLUE_BACKGROUND + ANSI_BLACK + "         Congratulations, Alex! You won!          " + ANSI_RESET + "\n\n";;

        GameRunner gameRunner = new GameRunner();
        gameRunner.concludeOnePlayerGame(game);
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
