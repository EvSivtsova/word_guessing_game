package game;

public class Print {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void askToInputPlayerNumber() {
        System.out.println("\nPlease enter the number of players: 1 or 2");
    }

    public void askToEnterNameForOnePlayer() {
        System.out.println("\nPlease enter your name:");
    }

    public void displayWelcomeMessageOnePlayer(String playerName) {
        System.out.printf("\n%sWelcome, %s! Today the word to guess is:%s\n\n", ANSI_BLUE, playerName, ANSI_RESET);
    }

    public void displayWordToGuessOnePlayer(String word) {
        System.out.println(ANSI_GREEN + word + ANSI_RESET + "\n");
    }
}
