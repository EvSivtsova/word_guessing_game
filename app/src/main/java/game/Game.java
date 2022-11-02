package game;

public class Game {
    Integer remainingAttempts;
    
    public Game(String word) {
        this.remainingAttempts = 10;
    }
    
    public Integer getRemainingAttempts() {
        return this.remainingAttempts;
    }

    public String getWordToGuess(String word) {
        StringBuilder stringBuilder = new StringBuilder(word); 
        
        for (int i = 1; i < word.length(); i++) {
            stringBuilder.replace(i, word.length(), "_");
        } 
        return stringBuilder.toString();
    }
    public static void main(String[] args) {}
}
