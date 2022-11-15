package game;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TwoPlayerGameTest {
    Game mockedGame1 = mock(Game.class);
    Game mockedGame2 = mock(Game.class);

    @Test
    public void testAssignsPlayerOrder() {
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        assertNull(game.getPlayers()[0]);
        assertNull(game.getPlayers()[1]);
        game.assignPlayerOrder(players);
        assertNotNull(game.getPlayers()[0]);
        assertNotNull(game.getPlayers()[1]);
    }

    @Test
    public void testGameIsOn_WhenNoPlayerLostOrWon() {
        when(mockedGame1.gameOver()).thenReturn(false);
        when(mockedGame2.gameOver()).thenReturn(false);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.assignPlayerOrder(players);
        assertTrue("Returns true if neither of the players won or lost.", game.twoPlayerGameOn());
    }

    @Test
    public void testGameIsOver_WhenFirstPlayerLostOrWon() {
        when(mockedGame1.gameOver()).thenReturn(true);
        when(mockedGame2.gameOver()).thenReturn(false);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.assignPlayerOrder(players);
        assertFalse("Returns false if the first player won or lost.", game.twoPlayerGameOn());
    }

    @Test
    public void testGameIsOver_WhenSecondPlayerLostOrWon() {
        when(mockedGame1.gameOver()).thenReturn(false);
        when(mockedGame2.gameOver()).thenReturn(true);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.assignPlayerOrder(players);
        assertFalse("Returns false if the second player won or lost.", game.twoPlayerGameOn());
    }

    @Test
    public void testIdentifiesWinner_WhenTheFistPlayerWon() {
        when(mockedGame1.gameWon()).thenReturn(true);
        when(mockedGame2.gameWon()).thenReturn(false);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.assignPlayerOrder(players);
        game.identifyWinner();
        assertEquals("The first player is the winner if they won the game.", 1, game.getWinner());
        assertEquals("The second player lost if the first player won the game.", 2, game.getLoser());
    }

    @Test
    public void testIdentifiesWinner_WhenTheSecondPlayerWon() {
        when(mockedGame1.gameWon()).thenReturn(false);
        when(mockedGame2.gameWon()).thenReturn(true);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.assignPlayerOrder(players);
        game.identifyWinner();
        assertEquals("The second player is the winner if they won the game.", 2, game.getWinner());
        assertEquals("The first player lost if the second player won the game.", 1, game.getLoser());
    }

    @Test
    public void testIdentifiesWinner_FirstPlayerWins_WhenTheSecondPlayerLost() {
        when(mockedGame1.getRemainingAttempts()).thenReturn(1);
        when(mockedGame2.getRemainingAttempts()).thenReturn(0);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.assignPlayerOrder(players);
        game.identifyWinner();
        assertEquals("The first player is the winner if the second player lost the game.", 1, game.getWinner());
        assertEquals("The second player is the loser if they lost the game.", 2, game.getLoser());
    }

    @Test
    public void testIdentifiesWinner_SecondPlayerWins_WhenTheFirstPlayerLost() {
        when(mockedGame1.getRemainingAttempts()).thenReturn(0);
        when(mockedGame2.getRemainingAttempts()).thenReturn(1);
        Game[] players =  {mockedGame1, mockedGame2};

        TwoPlayerGame game = new TwoPlayerGame();
        game.assignPlayerOrder(players);
        game.identifyWinner();
        assertEquals("The second player is the winner if the first player lost the game.", 2, game.getWinner());
        assertEquals("The first player is the loser if they lost the game.", 1, game.getLoser());
    }
}