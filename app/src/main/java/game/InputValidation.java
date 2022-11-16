package game;

import static java.lang.Character.isLetter;

public class InputValidation {
    public Boolean validateLetter(char letter) {
        return isLetter(letter);
    }

    public Boolean validateName(String name) {
        for (char letter : name.toCharArray()) {
            if (!this.validateLetter(letter)) {
                return false;
            }
        }
        return true;
    }

    public Boolean validateNumberOfPlayers(String number) {
        if (number == "1") {
            return true;
        } else {
            return false;
        }
    }
}
