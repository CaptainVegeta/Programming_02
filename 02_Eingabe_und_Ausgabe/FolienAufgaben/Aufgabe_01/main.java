/**
 * main
 */
public class main {

    public static void main(String[] args) {
        int divident = 10;
        int divisor = 0;
        try {
            int ergebnis = divident / divisor;
            System.out.println(ergebnis);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}