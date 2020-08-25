public class HighscoreGame {
public static String highscore_path = "highscore.txt";

    public static void main(String[] args) {
        Highscore highscore = new Highscore(highscore_path);
        Dice dice = new Dice();

        System.out.println("\nStarte Spiel...");
        highscore.showHighscore();
        dice.askPlayerName();
        while(dice.letPlayerGuess());
        highscore.addScore(dice.getPlayerName(), dice.getPlayerScore());
        System.out.println("Neuer Highscore:");
        highscore.showHighscore();
        System.out.println("Highscore wird abgespeichert");
        highscore.saveHighscore();
    }
}