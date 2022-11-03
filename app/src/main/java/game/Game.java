package game;

import java.util.ArrayList;

public class Game {
    Integer remainingAttempts;
    String word;
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();
    
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

    public Boolean guessLetter(Character letter) {
        if (this.word.indexOf(letter) != - 1) {
            guessedLetters.add(letter);
            return true;
        } else {
            this.remainingAttempts -= 1;
            return false;
        }
    }
    
    public static void main(String[] args) {}
}