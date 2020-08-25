import java.util.InputMismatchException;
import java.util.Scanner;

public class Dice {
    public static int round_point = 1;

    public Scanner scanner;
    public int points;
    public String player_name;

    public Dice(){
        scanner = new Scanner(System.in);
        points = 0;
    }

    public int generateRandomNumber(){
        return (int) Math.round(Math.random() * 2 + 1);
    }

    public void askPlayerName(){
        System.out.println("Bitte gebe deinen Namen ein:");
        try {
            player_name = scanner.nextLine();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public boolean letPlayerGuess(){
        int number = generateRandomNumber();
        try {
            System.out.println("Gib eine Zahl zwischen 1 und 3 ein:");
            int input = scanner.nextInt();
            if(number == input){
                System.out.println("Die gesuchte Zahl ist richtig!");
                points = points + round_point;
                System.out.println("Aktueller Punktestand: " + points);
                return true;
            } else {
                System.out.println("Die gesuchte Zahl ist falsch! GameOver!");
                return false;
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPlayerName(){
        return player_name;
    }

    public int getPlayerScore(){
        return points;
    }
}