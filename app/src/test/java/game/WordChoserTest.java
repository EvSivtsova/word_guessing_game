package game;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class WordChoserTest {
    @Test
    public void shouldGetRandomWordFromDictionary() {
        WordChoser wordChoser = new WordChoser();
        String[] MOCK_DICTIONNARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};  
    
        assertTrue(Arrays.asList(MOCK_DICTIONNARY).contains(wordChoser.getRandomWordFromDictionary()));

    }
}
