package game;

import java.util.regex.Pattern;

import static java.lang.Character.isLetter;

class InvalidPlayerNameException extends Exception {
    public InvalidPlayerNameException (String message) {
        super(message);
    }
}

public class InvalidPlayerName extends Throwable {

    static void checkPlayerName(String name) throws InvalidPlayerNameException {
        for (char letter : name.toCharArray()) {
            if (!isLetter(letter)) {
                throw new InvalidPlayerNameException("Please only use letters, try again");
            }
        }
    }
}