package game;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class GameTest {
    @Test
    public void testGetsWordToGuess() {
        String wordToGuess = "MAKERS";
        String expectedResult = "M_____";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();

        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn(wordToGuess);
        Masker mockedMasker = mock(Masker.class);
        when(mockedMasker.getMaskedWord(wordToGuess, guessedLetters)).thenReturn(expectedResult);

        Game game = new Game(mockedWChooser);
        assertEquals("The method should return mocked word", expectedResult, game.getWordToGuess(mockedMasker));
    }
    
    @Test
    public void testGetsTenInitialAttempts() {
        String wordToGuess = "MAKERS";
        String expectedResult = "M_____";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();

        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn(wordToGuess);
        Masker mockedMasker = mock(Masker.class);
        when(mockedMasker.getMaskedWord(wordToGuess, guessedLetters)).thenReturn(expectedResult);
        
        Game game = new Game(mockedWChooser);
        assertEquals("The method should return mocked word", expectedResult, game.getWordToGuess(mockedMasker));
        assertEquals("The method should return 10 initial attempts", Integer.valueOf(10), game.getRemainingAttempts());
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
        assertEquals("The method should return 9 attempts after one guess", Integer.valueOf(9), game.getRemainingAttempts());
    }

    @Test
    public void testChecksForGuessedLowerCaseLetter() {
        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Game game = new Game(mockedWChooser);
        assertTrue("The word contains guessed letter", game.guessLetter('a'));
        assertTrue("The guessLetters array contains guessed letter", game.guessedLetters.indexOf('a') == -1);
    }

    @Test
    public void testGetsWordWithGuessedLetters() {
        String wordToGuess = "MAKERS";
        String expectedResult = "M_A___";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        guessedLetters.add('A');

        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn(wordToGuess);
        Masker mockedMasker = mock(Masker.class);
        when(mockedMasker.getMaskedWord(wordToGuess, guessedLetters)).thenReturn(expectedResult);

        Game game = new Game(mockedWChooser);
        game.guessLetter('A');
        assertEquals("Returns word with guessed letters", expectedResult, game.getWordToGuess(mockedMasker));
    }
}