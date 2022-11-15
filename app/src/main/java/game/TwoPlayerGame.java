package game;

public class TwoPlayerGame{
//    this class manages rules of two player game
    private Game[] players = new Game[2];
    private byte winner;
    private byte loser;

    private int chooseFirstPlayer() {
        return (int)Math.random() * 2 + 1;
    }

    public void assignPlayerOrder(Game[] gamePlayers) {
        int firstPlayer = this.chooseFirstPlayer();
        this.players[0] = firstPlayer == 1 ? gamePlayers[0] : gamePlayers[1];
        this.players[1] = firstPlayer == 1 ? gamePlayers[1] : gamePlayers[0];
    }

    public Game[] getPlayers() {
        return this.players;
    }

    public String getWinnersName() {
        return this.players[this.winner - 1].getPlayerName();
    }

    public byte getWinner() {
        return this.winner;
    }

    public byte getLoser() {
        return this.loser;
    }

    public void identifyWinner() {
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

    public boolean twoPlayerGameOn() {
        for (byte i = 0; i < this.players.length; i++ ) {
            if (this.players[i].gameOver()) {
                return false;
            }
        }
        return true;
    }
}
