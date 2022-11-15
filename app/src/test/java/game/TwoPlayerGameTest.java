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


}
