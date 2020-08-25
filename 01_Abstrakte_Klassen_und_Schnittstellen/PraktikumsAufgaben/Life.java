/**
 * 
 * Hauptklasse Mit Main-Methode welches das Fensters erstellt. Besitzt auch eine endlose while-
 * Schleife mit einem Delay (SimplefiedDelay) welcher den Takt der Simulation vorgibt und die
 * Figuren entsprechend Zeichnet. Diese Klasse besitzt alle Grundwerte für die Simulation als
 * statische Variablen.
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Life extends JFrame{

    public static int WINDOW_WIDTH = 400;
    public static int WINDOW_HEIGHT = 400;
    public static int BLOCK_SIZE = 5;
    public static int GRID_WIDTH = WINDOW_WIDTH / BLOCK_SIZE;
    public static int GRID_HEIGHT = WINDOW_HEIGHT / BLOCK_SIZE;
    public static int NUMBER_OF_FOXES = 100;
    public static int NUMBER_OF_RABBITS = 200;
    public static int NUMBER_OF_GRASS = 200;
    public static int STEP_TIME = 500;

    public static Life leben;

    public CreatureHandler handler;

    public static void main(String[] args) {
        leben = new Life();

        while (true) {
            leben.handler.stepForAll();
            leben.handler.isEatable();
            SimplifiedDelay.delay(STEP_TIME);
            leben.repaint();
        }
    }

    public Life(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        handler = new CreatureHandler();

        for (int i = 0; i < NUMBER_OF_FOXES; i++) {
            handler.add(new Fox());
        }

        for (int i = 0; i < NUMBER_OF_RABBITS; i++) {
            handler.add(new Bunny());
        }

        for (int i = 0; i < NUMBER_OF_GRASS; i++) {
            handler.add(new Grass());
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        handler.drawForAll(g);
    }
    
}