package game;

public class Game {
    Integer remainingAttempts;
    String word;
    
    public Game(WordChoser wordChoser) {
        this.word = wordChoser.getRandomWordFromDictionary();
        this.remainingAttempts = 10;
    }
    
    public Integer getRemainingAttempts() {
        return this.remainingAttempts;
    }

    public String getWordToGuess() {
        StringBuilder stringBuilder = new StringBuilder(this.word); 
        
        for (int i = 1; i < this.word.length(); i++) {
            stringBuilder.replace(i, this.word.length() - 1, "_");
        } 
        return stringBuilder.toString();
    }
    public static void main(String[] args) {}
}
