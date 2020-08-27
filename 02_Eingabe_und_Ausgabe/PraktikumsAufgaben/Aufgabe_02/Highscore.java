import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.Math;
import java.util.Collection;
import java.util.Collections;

public class Highscore{
    FileWriter writer = null;
    BufferedWriter bufferedWriter = null;

    FileReader reader = null;
    BufferedReader bufferedReader = null;

    String path = "C:\\Users\\murat\\Desktop\\TEKO\\Semester_04\\Programming_02\\02_Eingabe_und_Ausgabe\\PraktikumsAufgaben\\Aufgabe_02\\highscore.txt";

    String user;
    int guess;
    int highscore;
    ArrayList<String> scores = new ArrayList<String>();

    Scanner scanner = new Scanner(System.in);

    public String getName(){
        System.out.println("Bitte gib deinen Namen ein:");
        return user = scanner.nextLine();
    }

    public int getGuess(){
        System.out.println("Bitte gib eine Zahl zwischen 1 und 3 ein:");
        boolean numberCorrect = false;
        boolean numberRange = false;
        while (!numberCorrect) {
            try {
                guess = scanner.nextInt();
                while (!numberRange) {
                    if (guess < 1 || guess > 3) {
                        System.out.println("Zahl nich im Range! Probiere nochmals:");
                        guess = scanner.nextInt();
                    } else {
                        numberRange = true;
                    }
                }
                numberCorrect = true;
                System.out.println("Deine Zahl lautet: "+guess);
            } catch (InputMismatchException e) {
                System.out.println("Falsche Eingabe! Probiere nochmals:");
                scanner.nextLine();  // Clear invalid input from scanner buffer.
            }
        }
        return guess;
    }

    public int gaming(){
        boolean wrongGuess = false;
        int number;
        
        while (!wrongGuess) {
            int random = (int) (Math.random()*3)+1;
            number = getGuess();
            if (number == random) {
                System.out.println("Die Random Zahl lautet: "+random);
                highscore++;
            } else {
                wrongGuess = true;
                System.out.println("Die Random Zahl lautet: "+random);
            }
        }
        return highscore;
    }

    //Gets name and guess and puts in ArrayList
    public void addScore(){
        user = getName();
        highscore = gaming();
        scores.add(highscore+" - "+user);
    }

    public void read(){
        if (checkFile()) {
            try {
                reader = new FileReader(path);
                bufferedReader = new BufferedReader(reader);
                String line = " ";
                while (line != null) {
                    line = bufferedReader.readLine();
                    if (line != null) {
                        scores.add(line);
                    }
                }
                Collections.sort(scores);
                System.out.println(scores.get(scores.size()-1));
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void write(){
        try {
            writer = new FileWriter(path);
            bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < scores.size(); i++) {
                bufferedWriter.write(scores.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public boolean checkFile(){
        File f = new File(path);
        boolean fileExists = f.exists();
        return fileExists;
    }

}