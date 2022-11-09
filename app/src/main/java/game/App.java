/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import java.util.Scanner;

import org.checkerframework.checker.units.qual.A;  

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        Game game = new Game(new WordChoser());
        System.out.printf("Welcome! Today the word to guess is:");
        Scanner scanner = new Scanner(System.in);
        do { System.out.println(game.getWordToGuess(new Masker()));
            System.out.printf("Enter one letter to guess (%d attempts remaining):\n", game.getRemainingAttempts());
            Character guessedLetter = scanner.nextLine().charAt(0);
            if (game.guessLetter(guessedLetter)) {
                System.out.println("Right!");
            } else {
                System.out.println("Wrong...");
            }
        } while (game.getRemainingAttempts() > 0 && game.on());
        if (game.on() == false) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("You lost this time! Try your luck again!");
        }
        scanner.close();
    }
}
