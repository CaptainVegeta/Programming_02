import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        System.out.println("Gib den Divisor an: ");
        boolean succesfull = false;
        while(!succesfull){
            try {
                String eingabe = new Scanner(System.in).nextLine();
                int divident = 10;
                int divisor = 0;
                divisor = Integer.parseInt(eingabe);
                int ergebnis = divident / divisor;
                System.out.println("Das Ergebnis lautet: "+ergebnis);
                succesfull = true;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage()+" | Division durch 0 |");
                System.out.println("Probiere es erneut: ");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage()+" Falsche Eingabe!");
                System.out.println("Probiere es erneut: ");
            }
        }
        
    }
}