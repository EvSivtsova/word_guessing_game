package game;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TwoPlayerGameTest {
    @Test
    public void testGameIsOn_WhenNoPlayerLostOrWon() {
        Game mockedGame1 = mock(Game.class);
        when(mockedGame1.gameOver()).thenReturn(false);
        Game mockedGame2 = mock(Game.class);
        when(mockedGame2.gameOver()).thenReturn(false);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        assertTrue("Returns true if neither of the players won or lost.", game.twoPlayerGameOn(players));
    }

    @Test
    public void testGameIsOver_WhenFirstPlayerLostOrWon() {
        Game mockedGame1 = mock(Game.class);
        when(mockedGame1.gameOver()).thenReturn(true);
        Game mockedGame2 = mock(Game.class);
        when(mockedGame2.gameOver()).thenReturn(false);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        assertFalse("Returns false if the first player won or lost.", game.twoPlayerGameOn(players));
    }

    @Test
    public void testGameIsOver_WhenSecondPlayerLostOrWon() {
        Game mockedGame1 = mock(Game.class);
        when(mockedGame1.gameOver()).thenReturn(false);
        Game mockedGame2 = mock(Game.class);
        when(mockedGame2.gameOver()).thenReturn(true);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        assertFalse("Returns false if the second player won or lost.", game.twoPlayerGameOn(players));
    }

    @Test
    public void testIdentifiesWinner_WhenTheFistPlayerWon() {
        Game mockedGame1 = mock(Game.class);
        when(mockedGame1.gameWon()).thenReturn(true);
        Game mockedGame2 = mock(Game.class);
        when(mockedGame2.gameWon()).thenReturn(false);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.identifyWinner(players);
        assertEquals("The first player is the winner if they won the game.", 1, game.getWinner());
        assertEquals("The second player lost if the first player won the game.", 2, game.getLoser());
    }

    @Test
    public void testIdentifiesWinner_WhenTheSecondPlayerWon() {
        Game mockedGame1 = mock(Game.class);
        when(mockedGame1.gameWon()).thenReturn(false);
        Game mockedGame2 = mock(Game.class);
        when(mockedGame2.gameWon()).thenReturn(true);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.identifyWinner(players);
        assertEquals("The second player is the winner if they won the game.", 2, game.getWinner());
        assertEquals("The first player lost if the second player won the game.", 1, game.getLoser());
    }

    @Test
    public void testIdentifiesWinner_FirstPlayerWins_WhenTheSecondPlayerLost() {
        Game mockedGame1 = mock(Game.class);
        when(mockedGame1.getRemainingAttempts()).thenReturn(1);
        Game mockedGame2 = mock(Game.class);
        when(mockedGame2.getRemainingAttempts()).thenReturn(0);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.identifyWinner(players);
        assertEquals("The first player is the winner if the second player lost the game.", 1, game.getWinner());
        assertEquals("The second player is the loser if they lost the game.", 2, game.getLoser());
    }

    @Test
    public void testIdentifiesWinner_SecondPlayerWins_WhenTheFirstPlayerLost() {
        Game mockedGame1 = mock(Game.class);
        when(mockedGame1.getRemainingAttempts()).thenReturn(0);
        Game mockedGame2 = mock(Game.class);
        when(mockedGame2.getRemainingAttempts()).thenReturn(1);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.identifyWinner(players);
        assertEquals("The second player is the winner if the first player lost the game.", 2, game.getWinner());
        assertEquals("The first player is the loser if they lost the game.", 1, game.getLoser());
    }
}
