/**
 * 
 * Hauptklasse Mit Main-Methode welches das Fensters erstellt. Besitzt auch eine endlose while-
 * Schleife mit einem Delay (SimplefiedDelay) welcher den Takt der Simulation vorgibt und die
 * Figuren entsprechend Zeichnet. Diese Klasse besitzt alle Grundwerte für die Simulation als
 * statische Variablen.
 * 
 */
import javax.swing.JFrame;

public class Life {

    static int WINDOW_WIDTH = 400;
    static int WINDOW_HEIGHT = 400;
    static int BLOCK_SIZE = 5;
    static int GRID_WIDTH = 300;
    static int GRID_HEIGHT = 300;
    static int NUMBER_OF_FOXES;
    static int NUMBER_OF_RABBITS;
    static int NUMBER_OF_GRASS;
    static int STEP_TIME;

    public static void main(String[] args) {

        JFrame window = new JFrame("Life");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setVisible(true);
        window.setLocation(700, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}