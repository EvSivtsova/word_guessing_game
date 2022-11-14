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
        assertFalse("Returns that the game continues", game.gameWon());
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
        assertFalse("Returns that the game continues", game.gameWon());
    }

    @Test
    public void testChecksForGuessedLetterTrue() {
        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Game game = new Game(mockedWChooser);
        assertTrue("The word contains guessed letter", game.guessLetter('A'));
        assertFalse("Returns that the game continues", game.gameWon());
    }
      
    @Test
    public void testChecksForGuessedLetterFalse() {
        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Game game = new Game(mockedWChooser);
        assertFalse("The word does not contain guessed letter", game.guessLetter('D'));
        assertEquals("The method should return 9 attempts after one guess", Integer.valueOf(9), game.getRemainingAttempts());
        assertFalse("Returns that the game continues", game.gameWon());
    }

    @Test
    public void testChecksForGuessedLowerCaseLetter() {
        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Game game = new Game(mockedWChooser);
        assertTrue("The word contains guessed letter", game.guessLetter('a'));
        assertTrue("The guessLetters array contains guessed letter", game.getGuessedLetters().indexOf('a') == -1);
        assertFalse("Returns that the game continues", game.gameWon());
    }

    @Test
    public void testGetsWordWithGuessedLetters() {
        String wordToGuess = "MAKERS";
        String expectedResult = "MA____";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        guessedLetters.add('A');

        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn(wordToGuess);
        Masker mockedMasker = mock(Masker.class);
        when(mockedMasker.getMaskedWord(wordToGuess, guessedLetters)).thenReturn(expectedResult);

        Game game = new Game(mockedWChooser);
        game.guessLetter('A');
        assertEquals("Returns word with guessed letters", expectedResult, game.getWordToGuess(mockedMasker));
        assertFalse("Returns that the game continues", game.gameWon());
    }

    @Test
    public void testEndsGame_WhenWordIsGuessed() {
        String wordToGuess = "MAKERS";
        String expectedResult = "MAKERS";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        guessedLetters.add('A');
        guessedLetters.add('K');
        guessedLetters.add('E');
        guessedLetters.add('R');
        guessedLetters.add('S');

        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn(wordToGuess);
        Masker mockedMasker = mock(Masker.class);
        when(mockedMasker.getMaskedWord(wordToGuess, guessedLetters)).thenReturn(expectedResult);

        Game game = new Game(mockedWChooser);
        game.guessLetter('A');
        game.guessLetter('K');
        game.guessLetter('E');
        game.guessLetter('R');
        game.guessLetter('S');
        String resultWord = game.getWordToGuess(mockedMasker);
        assertEquals("Returns the word with guessed letters", expectedResult, resultWord);
        assertTrue("Returns that the game is not on anymore", game.gameWon());
    }

    @Test
    public void testEndsGame_WhenWordIsGuessed_RepetitiveLetters() {
        String wordToGuess = "LONDON";
        String expectedResult = "LONDON";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        guessedLetters.add('O');
        guessedLetters.add('N');
        guessedLetters.add('D');

        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn(wordToGuess);
        Masker mockedMasker = mock(Masker.class);
        when(mockedMasker.getMaskedWord(wordToGuess, guessedLetters)).thenReturn(expectedResult);

        Game game = new Game(mockedWChooser);
        game.guessLetter('O');
        game.guessLetter('N');
        game.guessLetter('D');
        String resultWord = game.getWordToGuess(mockedMasker);
        assertEquals("Returns the word with guessed letters", expectedResult, resultWord);
        assertTrue("Returns that the game is not on anymore", game.gameWon());
    }

    @Test
    public void testGameOver_WhenWordIsGuessed() {
        String wordToGuess = "LONDON";
        String expectedResult = "LONDON";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        guessedLetters.add('O');
        guessedLetters.add('N');
        guessedLetters.add('D');

        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn(wordToGuess);
        Masker mockedMasker = mock(Masker.class);
        when(mockedMasker.getMaskedWord(wordToGuess, guessedLetters)).thenReturn(expectedResult);

        Game game = new Game(mockedWChooser);
        game.guessLetter('O');
        game.guessLetter('N');
        game.guessLetter('D');
        String resultWord = game.getWordToGuess(mockedMasker);
        assertEquals("Returns the word with guessed letters", expectedResult, resultWord);
        assertTrue("Returns that the game is not on anymore", game.gameOver());
    }

    @Test
    public void testGameOver_WhenZeroAttempsLeft() {
        String wordToGuess = "LONDON";
        String expectedResult = "L_____";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();


        WordChoser mockedWChooser = mock(WordChoser.class);
        when(mockedWChooser.getRandomWordFromDictionary()).thenReturn(wordToGuess);
        Masker mockedMasker = mock(Masker.class);
        when(mockedMasker.getMaskedWord(wordToGuess, guessedLetters)).thenReturn(expectedResult);

        Game game = new Game(mockedWChooser);
        game.guessLetter('Z');
        game.guessLetter('H');
        game.guessLetter('V');
        game.guessLetter('W');
        game.guessLetter('E');
        game.guessLetter('I');
        game.guessLetter('K');
        game.guessLetter('S');
        game.guessLetter('T');
        game.guessLetter('U');
        String resultWord = game.getWordToGuess(mockedMasker);
        assertEquals("Returns the word with guessed letters", expectedResult, resultWord);
        assertTrue("Returns that the game is not on anymore", game.gameOver());
    }

    @Test
    public void testAddPlayerName() {
        String wordToGuess = "LONDON";
        WordChoser mockedWChooser = mock(WordChoser.class);

        String name = "Alex";
        String expectedResult = "Alex";

        Game game = new Game(mockedWChooser);
        assertEquals("Returns the word with guessed letters", null, game.getName());
        game.setName(name);
        assertEquals("Returns the word with guessed letters", expectedResult, game.getName());
    }
}