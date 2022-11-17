package game;

import static java.lang.Character.isLetter;

class InvalidGuessedLetterException extends Exception {
    public InvalidGuessedLetterException (String message) {
        super(message);
    }
}

public class InvalidGuessedLetter extends Throwable {

    static void checkGuessedLetter(char letter) throws InvalidGuessedLetterException {
        if(!isLetter(letter)) {
            throw new InvalidGuessedLetterException("Please enter a letter.");
        }
    }
}