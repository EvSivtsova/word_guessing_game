package game;

import java.util.ArrayList;

public class Game {
    private Integer remainingAttempts;
    private String word;
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();
    
    public Game(WordChoser wordChoser) {
        this.word = wordChoser.getRandomWordFromDictionary();
        this.remainingAttempts = 10;
    }
    
    public Integer getRemainingAttempts() {
        return this.remainingAttempts;
    }

    public ArrayList<Character> getGuessedLetters(){ return this.guessedLetters; }

    public String getWordToGuess(Masker masker) {
        return masker.getMaskedWord(this.word, guessedLetters);
    }

    public Boolean guessLetter(Character guessedLetter) {
        Character letter = Character.toUpperCase(guessedLetter);
        if (this.word.indexOf(letter) != - 1) {
            guessedLetters.add(letter);
            return true;
        } else {
            this.remainingAttempts -= 1;
            return false;
        }
    }

    public Boolean on() {
        for (int i = 1; i < this.word.length(); i++) {
            char letter = this.word.charAt(i);
            if (!this.guessedLetters.contains(letter)) {
                return true;
            }
        }
        return false;
    }
}