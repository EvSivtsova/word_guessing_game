package game;

public class Game {
    // String word;
    
    public Game(String word) {
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
