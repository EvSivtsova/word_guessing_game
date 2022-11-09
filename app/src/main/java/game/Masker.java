package game;

import java.util.ArrayList;

public class Masker {

    public Masker() {}

    public String getMaskedWord(String word, ArrayList<Character> guessedLetters) {
        StringBuilder stringBuilder = new StringBuilder(word); 
        
        for (int i = 1; i < word.length(); i++) {
            Character letter = stringBuilder.charAt(i);
            if (guessedLetters.indexOf(letter) == -1) {
                stringBuilder.replace(i, i + 1, "_");
            }
        } 
        return stringBuilder.toString();
    }

//    public static void main(String[] args) {}
}
