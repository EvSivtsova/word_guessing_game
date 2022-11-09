package game;

import java.util.Random;

public class WordChoser {
    private static final String[] DICTIONNARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

    public String getRandomWordFromDictionary() {
        Integer maxIndex = DICTIONNARY.length;
        Random rand = new Random();
        Integer index = rand.nextInt(maxIndex);

        return DICTIONNARY[index];
    }
}

