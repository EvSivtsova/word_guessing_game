/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import java.util.Scanner;

public class App {
    // font and background colours:
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        App app = new App();
        Scanner scanner = new Scanner(System.in);
        InputValidation inputCheck = new InputValidation();
        Print print = new Print();

        print.askToInputPlayerNumber();
        String numberOfPlayers = scanner.nextLine();
        while (!inputCheck.validateNumberOfPlayers(numberOfPlayers)) {
            System.out.println(ANSI_RED + "\nPlease enter 1 or 2." + ANSI_RESET);
            numberOfPlayers = scanner.nextLine();
        }

        // Launch one player game
        if (Integer.parseInt(numberOfPlayers) == 1) {
            print.askToEnterNameForOnePlayer();
            String playerName = scanner.nextLine();
            while (!inputCheck.validateName(playerName)) {
                System.out.println(ANSI_RED + "\nPlease enter your name. Use letters only." + ANSI_RESET);
                playerName = scanner.nextLine();
            }
            Game game = new Game(new WordChoser(), playerName);

            print.displayWelcomeMessageOnePlayer(game.getPlayerName());

            // Ask player to input letters
            do { print.displayWordToGuessOnePlayer(game.getWordToGuess(new Masker()));
                print.askToInputLetter(game.getRemainingAttempts());
                Character guessedLetter = scanner.nextLine().charAt(0);
                while (!inputCheck.validateLetter(guessedLetter)) {
                    System.out.println(ANSI_RED + "\nPlease enter a letter." + ANSI_RESET);
                    guessedLetter = scanner.nextLine().charAt(0);
                }
                if (game.guessLetter(guessedLetter)) {
                    print.printThatTheGuessIsCorrect();
                } else {
                    print.printThatTheGuessIsWrong();
                }
            } while (game.getRemainingAttempts() > 0 && !game.gameWon());

            // Determine the outcome of the game
            if (game.gameWon() == true) {
                System.out.printf("%s%s         Congratulations, %s! You won!          %s\n\n", ANSI_BLUE_BACKGROUND, ANSI_BLACK, game.getPlayerName(), ANSI_RESET);
            } else {
                System.out.printf("%s%s, you lost this time! Try your luck again!%s\n\n", ANSI_YELLOW, game.getPlayerName(), ANSI_RESET);
            }

        // launch two player game
        } else if (Integer.parseInt(numberOfPlayers) == 2) {
            TwoPlayerGame game = new TwoPlayerGame();

            // ask players to input their names
            System.out.println("\nPlease enter the name for player 1:");
            String player1Name = scanner.nextLine();
            while (!inputCheck.validateName(player1Name)) {
                System.out.println(ANSI_RED + "\nPlease enter the name for player 1. Use letters only." + ANSI_RESET);
                player1Name = scanner.nextLine();
            }
            Game player1 = new Game(new WordChoser(), player1Name);

            System.out.println("Please enter the name for player 2:");
            String player2Name = scanner.nextLine();
            while (!inputCheck.validateName(player2Name)) {
                System.out.println(ANSI_RED + "\nPlease enter the name for player 2. Use letters only." + ANSI_RESET);
                player2Name = scanner.nextLine();
            }
            Game player2 = new Game(new WordChoser(), player2Name);

            Game[] players =  {player1, player2};
            game.assignPlayerOrder(players);

            // Assign words to guess to players
            System.out.println(ANSI_BLUE + "\nWelcome! Today the word to guess is:\n" + ANSI_RESET);
            System.out.println(ANSI_GREEN + game.getPlayers()[0].getPlayerName() + ": " + game.getPlayers()[0].getWordToGuess(new Masker()) + ANSI_RESET);
            System.out.println(ANSI_YELLOW + game.getPlayers()[1].getPlayerName() + ": " + game.getPlayers()[1].getWordToGuess(new Masker()) + ANSI_RESET + "\n");

            // Ask players to input letters
            do {
                String textColour = ANSI_GREEN;
                for (byte i = 0; i < game.getPlayers().length; i++) {
                    System.out.printf("%s%s%s: Enter one letter to guess (%d attempts remaining):\n ", textColour, game.getPlayers()[i].getPlayerName(), ANSI_RESET, game.getPlayers()[i].getRemainingAttempts());
                    Character guessedLetter = scanner.nextLine().charAt(0);
                    while (!inputCheck.validateLetter(guessedLetter)) {
                        System.out.println(ANSI_RED + "\nPlease enter a letter." + ANSI_RESET);
                        guessedLetter = scanner.nextLine().charAt(0);
                    }
                    if (game.getPlayers()[i].guessLetter(guessedLetter)) {
                        System.out.println("Right!");
                    } else {
                        System.out.println("Wrong...");
                    }
                    System.out.println(textColour + game.getPlayers()[i].getWordToGuess(new Masker()) + ANSI_RESET + "\n");
                    if (!game.twoPlayerGameOn()) {
                        break;
                    }
                    textColour = ANSI_YELLOW;
                }
            } while (game.twoPlayerGameOn());

            // Determine the outcome of the game
            game.identifyWinner();
            String textColour = game.getLoser() == 1 ? ANSI_GREEN : ANSI_YELLOW;
            System.out.printf("%s%s       Congratulations, %s! You won!        %s\n\n", ANSI_BLUE_BACKGROUND, ANSI_BLACK, game.getWinnersName(), ANSI_RESET);
            System.out.printf("%s%s, you lost this time! Try your luck again!%s\n", textColour, game.getLosersName(), ANSI_RESET);
        }
        scanner.close();
    }
}
