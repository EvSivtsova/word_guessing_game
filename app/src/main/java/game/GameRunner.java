package game;

public class GameRunner {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    Print print = new Print();
    UserInput input = new UserInput();

    public void concludeGame_WhenOnePlayer(Game game) {
        if (game.gameWon() == true) {
            print.congratulateWinner(game.getPlayerName());
        } else {
            print.displayYouLostMessage(game.getPlayerName(), 1);
        }
    }

    public void getLetter(Game game) {
        Character guessedLetter = input.getGuessedLetter();
        if (game.guessLetter(guessedLetter)) {
            print.printThatTheGuessIsCorrect();
        } else {
            print.printThatTheGuessIsWrong();
        }
    }

    public void run() {
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
                this.getLetter(game);
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
                    print.askToInputLetter(textColour, game.getPlayers()[i].getPlayerName(), game.getPlayers()[i].getRemainingAttempts());
                    this.getLetter(game.getPlayers()[i]);
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
