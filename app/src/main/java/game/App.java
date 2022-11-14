/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import java.util.Scanner;

public class App {
//    font and background colours:
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RESET = "\u001B[0m";

//    class attributes:
    Game[] players = new Game[2];
    Game player1;
    Game player2;
    byte winner;
    byte loser;

    public App () {
        player1 = new Game(new WordChoser());
        player2 = new Game(new WordChoser());
        this.assignPlayerOrder();
    }

    private int chooseFirstPlayer() {
        return (int)Math.random() * 2 + 1;
    }

    private void assignPlayerOrder() {
        this.chooseFirstPlayer();
        this.players[0] = this.chooseFirstPlayer() == 1 ? player1 : player2;
        this.players[1] = this.chooseFirstPlayer() == 1 ? player2 : player1;
    }
    private void identifyWinner() {
        for (byte i = 0; i < this.players.length; i++ ) {
            if (this.players[i].gameWon()) {
                this.winner = (byte) (i + 1);
                this.loser = (byte) (this.players.length - this.winner + 1);
            } else {
                if (players[i].getRemainingAttempts() < 1) {
                    this.loser = (byte) (i + 1);
                    this.winner = (byte) (this.players.length - this.loser + 1);
                }
            }
        }
    }

    private boolean twoPlayerGameOn() {
        for (byte i = 0; i < this.players.length; i++ ) {
            if (players[i].gameOver()) {
                this.identifyWinner();
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        App app = new App();

        System.out.println(ANSI_BLUE + "\nWelcome! Today the word to guess is:\n" + ANSI_RESET);
        System.out.printf(ANSI_GREEN + "Player %d: %s\n", 1, app.players[0].getWordToGuess(new Masker()) + ANSI_RESET);
        System.out.printf(ANSI_YELLOW + "Player %d: %s\n\n", 2, app.players[1].getWordToGuess(new Masker()) + ANSI_RESET);

        Scanner scanner = new Scanner(System.in);
        do {
           byte playerNumber = 1;
           String textColour = ANSI_GREEN;
           for (byte i = 0; i < app.players.length; i++) {
               System.out.printf(textColour + "Player %d:" + ANSI_RESET + " Enter one letter to guess (%d attempts remaining):\n ", playerNumber, app.players[i].getRemainingAttempts());
               Character guessedLetter = scanner.nextLine().charAt(0);
               if (app.players[i].guessLetter(guessedLetter)) {
                   System.out.println("Right!");
               } else {
                   System.out.println("Wrong...");
               }
               System.out.println(textColour + app.players[i].getWordToGuess(new Masker()) + "\n" + ANSI_RESET);
               if (!app.twoPlayerGameOn()) {
                   break;
               }
               textColour = ANSI_YELLOW;
               playerNumber++;
           }
        }  while (app.twoPlayerGameOn());
       scanner.close();
       String textColour = app.winner == 0 ? ANSI_GREEN : ANSI_YELLOW;
       System.out.printf("%s%s       Congratulations, Player %d! You won!        %s\n\n", ANSI_BLUE_BACKGROUND, ANSI_BLACK, app.winner, ANSI_RESET);
       System.out.printf("%sPlayer %d, you lost this time! Try your luck again!%s\n", textColour, app.loser, ANSI_RESET );
    }
}
