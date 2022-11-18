package game;

public class GameRunner {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    Print print = new Print();
    public void concludeGame_WhenOnePlayer(Game game) {
        if (game.gameWon() == true) {
            print.congratulateWinner(game.getPlayerName());
        } else {
            print.displayYouLostMessage(game.getPlayerName(), 1);
        }
    }

    public void run() {
        UserInput input = new UserInput();
        int numberOfPlayers = input.getNumberOfPlayers();

        // Launch one player game
        if (numberOfPlayers == 1) {
            print.askToEnterNameForOnePlayer();
            String playerName = input.getPlayerName();
            Game game = new Game(new WordChoser(), playerName);
            print.displayWelcomeMessageOnePlayer(game.getPlayerName());

            // Ask player to input letters
            do { print.displayWordToGuessOnePlayer(game.getWordToGuess(new Masker()));
                print.askToInputLetter(game.getRemainingAttempts());
                Character guessedLetter = input.getGuessedLetter();
                if (game.guessLetter(guessedLetter)) {
                    print.printThatTheGuessIsCorrect();
                } else {
                    print.printThatTheGuessIsWrong();
                }
            } while (game.getRemainingAttempts() > 0 && !game.gameWon());

            // Determine the outcome of the game
            this.concludeGame_WhenOnePlayer(game);

            // launch two player game
        } else if (numberOfPlayers == 2) {
            TwoPlayerGame game = new TwoPlayerGame();

            // ask players to input their names
            print.getPlayer1Name();
            String player1Name = input.getPlayerName();
            Game player1 = new Game(new WordChoser(), player1Name);

            print.getPlayer2Name();
            String player2Name = input.getPlayerName();
            Game player2 = new Game(new WordChoser(), player2Name);

            Game[] players =  {player1, player2};
            game.assignPlayerOrder(players);

            // Assign words to guess to players
            print.displayWelcomeMessageAndWordsTwoPlayers(game.getPlayers()[0].getPlayerName(), game.getPlayers()[0].getWordToGuess(new Masker()),
                    game.getPlayers()[1].getPlayerName(), game.getPlayers()[1].getWordToGuess(new Masker()));

            // Ask players to input letters
            do {
                String textColour = ANSI_GREEN;
                for (byte i = 0; i < game.getPlayers().length; i++) {
                    System.out.printf("%s%s%s: Enter one letter to guess (%d attempts remaining):\n ", textColour, game.getPlayers()[i].getPlayerName(), ANSI_RESET, game.getPlayers()[i].getRemainingAttempts());
                    Character guessedLetter = input.getGuessedLetter();
                    if (game.getPlayers()[i].guessLetter(guessedLetter)) {
                        print.printThatTheGuessIsCorrect();
                    } else {
                        print.printThatTheGuessIsWrong();
                    }
                    System.out.println(textColour + game.getPlayers()[i].getWordToGuess(new Masker()) + ANSI_RESET + "\n");
                    if (!game.twoPlayerGameOn()) {
                        break;
                    }
                    textColour = ANSI_YELLOW;
                }
            } while (game.twoPlayerGameOn());

            // Determine the outcome of the game
            print.congratulateWinner(game.getWinnersName());
            print.displayYouLostMessage(game.getLosersName(), game.getLoser());
        }
    }
}
