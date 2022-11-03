package game;

import java.util.ArrayList;

public class Game {
    Integer remainingAttempts;
    String word;
    
    public Game(WordChoser wordChoser) {
        this.word = wordChoser.getRandomWordFromDictionary();
        this.remainingAttempts = 10;
    }
    
    public Integer getRemainingAttempts() {
        return this.remainingAttempts;
    }

    public String getWordToGuess() {
        StringBuilder stringBuilder = new StringBuilder(this.word); 
        
        for (int i = 1; i < this.word.length(); i++) {
            stringBuilder.replace(i, this.word.length() - 1, "_");
        } 
        return stringBuilder.toString();
    }

    public Boolean guessLetter(char letter) {
        char[] letters = this.word.toCharArray();
        ArrayList<Character> lettersInWord = new ArrayList<Character>();
        for (int i = 0; i < this.word.length(); i++) {
            lettersInWord.add(letters[i]);
        }
        return lettersInWord.contains(letter);
    }
    
    public static void main(String[] args) {}
}