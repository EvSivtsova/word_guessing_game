package game;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class MaskerTest {
    @Test
    public void testGetsMaskedWordFirstRound() {
        String wordToGuess = "DEVELOPER";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        String expectedResult = "D________";
        
        Masker masker = new Masker();
        String result = masker.getMaskedWord(wordToGuess, guessedLetters);
        assertEquals("Returns word with first letter unmasked", expectedResult, result);
    }

    @Test
    public void testGetsMaskedWordWithGuessedLetters() {
        String wordToGuess = "DEVELOPER";
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        guessedLetters.add('E');
        guessedLetters.add('V');
        String expectedResult = "DEVE___E_";
        
        Masker masker = new Masker();
        String result = masker.getMaskedWord(wordToGuess, guessedLetters);

        assertEquals("Returns word with guessed letters unmasked", expectedResult, result);
    }
}