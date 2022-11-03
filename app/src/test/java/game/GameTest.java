package game;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    @Test
    public void testGetsWordToGuess() {
        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn("BAKERS");
        Game game = new Game(mockedWChooser);
        assertEquals("The method should return mocked word", game.getWordToGuess(), "B_____");
    }

    @Test
    public void testGetsWordToGuess2() {
        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Game game = new Game(mockedWChooser);
        String word = "M_____";
        
        assertEquals("The method should return mocked word2", game.getWordToGuess(), word);
    }
    
    @Test
    public void testGetsTenInitialAttempts() {
        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Game game = new Game(mockedWChooser);
        String word = "M_____";
        assertEquals("The method should return mocked word", game.getWordToGuess(), word);
        assertEquals("The method should return 10 initial attempts", game.getRemainingAttempts(), Integer.valueOf(10));
    }

    @Test
    public void testChecksForGuessedLetterTrue() {
        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Game game = new Game(mockedWChooser);
        assertTrue("The word contains guessed letter", game.guessLetter('A'));
    }
      
    @Test
    public void testChecksForGuessedLetterFalse() {
        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Game game = new Game(mockedWChooser);
        assertFalse("The word does not contain guessed letter", game.guessLetter('D'));
        assertEquals("The method should return 9 attempts after one guess", game.getRemainingAttempts(), Integer.valueOf(9));
    }
}