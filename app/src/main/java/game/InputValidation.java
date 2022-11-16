package game;

import static java.lang.Character.isLetter;

public class InputValidation {
    public Boolean validateLetter(char letter) {
        return isLetter(letter);
    }

    public Boolean validateName(String name) {
        if (name == "Steve") {
            return true;
        } else if (name == "Sara") {
            return true;
        } else {
            return false;
        }
    }
}
