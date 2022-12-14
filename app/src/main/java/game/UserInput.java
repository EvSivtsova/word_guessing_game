package game;

import java.util.Scanner;

public class UserInput {
    Scanner scanner;
    Print print = new Print();
    public int getNumberOfPlayers() {
        print.askToInputNumberOfPlayers();
        String numberOfPlayers;
        while (true) {
            try {
                scanner = new Scanner(System.in);
                numberOfPlayers = scanner.nextLine();
                InvalidNumberOfPlayers.checkNumberOfPlayers(numberOfPlayers);
                break;
            } catch (InvalidNumberOfPlayersException exception) {
                System.err.println(exception.getMessage());
            }
        }
        return Integer.parseInt(numberOfPlayers);
    }

    public Character getGuessedLetter() {
        Character guessedLetter;
        while (true) {
            try {
                scanner = new Scanner(System.in);
                guessedLetter = scanner.nextLine().charAt(0);
                InvalidGuessedLetter.checkGuessedLetter(guessedLetter);
                break;
            } catch (InvalidGuessedLetterException exception) {
                System.err.println(exception.getMessage());
            }
        }
        return guessedLetter;
    }

    public String getPlayerName() {
        String name;
        while (true) {
            try {
                scanner = new Scanner(System.in);
                name = scanner.nextLine();
                InvalidPlayerName.checkPlayerName(name);
                break;
            } catch (InvalidPlayerNameException exception) {
                System.err.println(exception.getMessage());
            }
        }
        return name;
    }
}
