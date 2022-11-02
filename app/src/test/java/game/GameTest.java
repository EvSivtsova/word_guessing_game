package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void testGetsWordToGuess() {
        Game game = new Game("B_____");
        assertEquals(game.getWordToGuess("B_____"), "B_____");
    }

    @Test
    public void testGetsWordToGuess2() {
        Game game = new Game("MAKERS");
        assertEquals(game.getWordToGuess("MAKERS"), "M_____");
    }

    @Test
    public void testGetsTenInitialAttempts() {
        Game game = new Game("MAKERS");
        assertEquals(game.getWordToGuess("MAKERS"), "M_____");
        assertEquals(game.getRemainingAttempts(), Integer.valueOf(10));
    }
}