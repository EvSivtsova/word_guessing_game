package game;

import java.util.ArrayList;

public class Game {
    Integer remainingAttempts;
    String word;
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    String maskedWord;
    
    public Game(WordChoser wordChoser) {
        this.word = wordChoser.getRandomWordFromDictionary();
        this.remainingAttempts = 10;
    }
    
    public Integer getRemainingAttempts() {
        return this.remainingAttempts;
    }

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
        return guessedLetters.size() != (this.word.length() - 1);
    
    }

    
    public static void main(String[] args) {}
}