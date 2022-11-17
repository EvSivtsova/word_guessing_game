package game;

class InvalidNumberOfPlayersException extends Exception {
    public InvalidNumberOfPlayersException (String message) {
        super(message);
    }
}

public class InvalidNumberOfPlayers extends Throwable {

    static void checkNumberOfPlayers(String number) throws InvalidNumberOfPlayersException {
        if(number.equals("1") || number.equals("2")) {
            String s = number.equals("2") ? "s" : "";
            System.out.println("You have " + number + " player" + s + ".");
        } else {
            throw new InvalidNumberOfPlayersException("Please enter 1 or 2.");
        }
    }
}