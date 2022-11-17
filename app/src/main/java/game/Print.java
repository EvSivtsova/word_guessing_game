package game;

public class Print {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

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

    public void askToInputLetter(Integer remainingAttempts) {
        System.out.printf("Enter one letter to guess (%d attempts remaining):\n", remainingAttempts);
    }

    public void printThatTheGuessIsCorrect() {
        System.out.println("Right!\n");
    }

    public void printThatTheGuessIsWrong() {
        System.out.println("Wrong...\n");
    }

    public void congratulateWinner(String playerName) {
        System.out.printf("%s%s         Congratulations, %s! You won!          %s\n\n", ANSI_BLUE_BACKGROUND, ANSI_BLACK, playerName, ANSI_RESET);
    }

    public void displayYouLostMessage(String playerName) {
        System.out.printf("%s%s, you lost this time! Try your luck again!%s\n\n", ANSI_YELLOW, playerName, ANSI_RESET);

    }
}
