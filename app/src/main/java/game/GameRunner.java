package game;

public class GameRunner {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    Print print = new Print();
    UserInput input = new UserInput();

    public void concludeOnePlayerGame(Game game) {
        if (game.gameWon() == true) {
            print.congratulateWinner(game.getPlayerName());
        } else {
            print.displayYouLostMessage(game.getPlayerName(), 1);
        }
    }

    public void concludeTwoPlayerGame(TwoPlayerGame game) {
        game.identifyWinner();
        print.congratulateWinner(game.getWinnersName());
        print.displayYouLostMessage(game.getLosersName(), game.getLoser());
    }

    public void getLetter(Game game) {
        Character guessedLetter = input.getGuessedLetter();
        if (game.guessLetter(guessedLetter)) {
            print.printThatTheGuessIsCorrect();
        } else {
            print.printThatTheGuessIsWrong();
        }
    }

    public void launchTwoPlayerGame(TwoPlayerGame game) {
        print.getPlayerNameTwoPlayerGame(1);
        String player1Name = input.getPlayerName();
        Game player1 = new Game(new WordChoser(), player1Name);

        print.getPlayerNameTwoPlayerGame(2);
        String player2Name = input.getPlayerName();
        Game player2 = new Game(new WordChoser(), player2Name);

        Game[] players =  {player1, player2};
        game.assignPlayerOrder(players);

        print.displayWelcomeMessageAndWordsTwoPlayers(game.getPlayers()[0].getPlayerName(), game.getPlayers()[0].getWordToGuess(new Masker()),
                game.getPlayers()[1].getPlayerName(), game.getPlayers()[1].getWordToGuess(new Masker()));
    }

    public void runOnePlayerGame() {
        print.askToEnterNameForOnePlayer();
        String playerName = input.getPlayerName();
        Game game = new Game(new WordChoser(), playerName);
        print.displayWelcomeMessageOnePlayer(game.getPlayerName());

        do { print.displayWordToGuess(game.getWordToGuess(new Masker()), "");
            print.askToInputLetter(game.getRemainingAttempts());
            this.getLetter(game);
        } while (game.getRemainingAttempts() > 0 && !game.gameWon());

        this.concludeOnePlayerGame(game);
    }

    public void runTwoPlayerGame() {
        TwoPlayerGame game = new TwoPlayerGame();
        launchTwoPlayerGame(game);

        do {
            String textColour = ANSI_GREEN;
            for (byte i = 0; i < game.getPlayers().length; i++) {
                print.askToInputLetter(textColour, game.getPlayers()[i].getPlayerName(), game.getPlayers()[i].getRemainingAttempts());
                this.getLetter(game.getPlayers()[i]);
                print.displayWordToGuess(game.getPlayers()[i].getWordToGuess(new Masker()), textColour);
                if (!game.twoPlayerGameOn()) {
                    break;
                }
                textColour = ANSI_YELLOW;
            }
        } while (game.twoPlayerGameOn());
        this.concludeTwoPlayerGame(game);
    }

    public void run() {
        int numberOfPlayers = input.getNumberOfPlayers();

        if (numberOfPlayers == 1) {
            this.runOnePlayerGame();
        } else if (numberOfPlayers == 2) {
            this.runTwoPlayerGame();
        }
    }
}
