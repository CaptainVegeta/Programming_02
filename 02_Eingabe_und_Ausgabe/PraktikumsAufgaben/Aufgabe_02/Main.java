public class Main {
    public static void main(String[] args) {
        Highscore highscore = new Highscore();

        /*
        String name = highscore.getName();
        int score = highscore.gaming();

        System.out.println(name+" hat "+score+" Punkte erreicht.");
        */

        highscore.read();
        highscore.addScore();
        highscore.write();
    }
}