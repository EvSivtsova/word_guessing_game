package game;

import java.util.Random;

public class WordChoser {
    public static final String[] DICTIONNARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

    public String getRandomWordFromDictionary() {
        Integer maxIndex = DICTIONNARY.length;
        Random rand = new Random();
        Integer index = rand.nextInt(maxIndex);

        return DICTIONNARY[index];
    }
}

