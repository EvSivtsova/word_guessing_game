package game;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameRunnerTest {
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

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
        String expectedResult = ANSI_BLUE_BACKGROUND + ANSI_BLACK + "         Congratulations, Alex! You won!          " + ANSI_RESET + "\n\n";

        GameRunner gameRunner = new GameRunner();
        gameRunner.concludeOnePlayerGame(game);
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testDisplaysGameLostMessage_WhenOnePlayerGame() {
        Game game = mock(Game.class);
        when(game.gameWon()).thenReturn(false);
        when(game.getPlayerName()).thenReturn("Alex");
        String expectedResult = ANSI_GREEN + "Alex, you lost this time! Try your luck again!" + ANSI_RESET + "\n\n";

        GameRunner gameRunner = new GameRunner();
        gameRunner.concludeOnePlayerGame(game);
        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testDisplaysWinnerAndLoserMessages_WhenTwoPlayerGame() {
        TwoPlayerGame game = mock(TwoPlayerGame.class);
        when(game.getWinnersName()).thenReturn("Alex");
        when(game.getLosersName()).thenReturn("Steve");
        when(game.getLoser()).thenReturn((byte) 2);

        String expectedWinnerMessage = ANSI_BLUE_BACKGROUND + ANSI_BLACK + "         Congratulations, Alex! You won!          " + ANSI_RESET + "\n\n" +
                ANSI_YELLOW + "Steve, you lost this time! Try your luck again!" + ANSI_RESET + "\n\n";

        GameRunner gameRunner = new GameRunner();
        gameRunner.concludeTwoPlayerGame(game);
        Assert.assertEquals(expectedWinnerMessage, outContent.toString());
        Assert.assertEquals(expectedWinnerMessage, outContent.toString());
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
