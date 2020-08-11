import java.awt.*;
import javax.swing.*;

/**
 * Life
 */

public class Life {

    public static int WINDOW_WIDTH = 400;
    public static int WINDOW_HEIGHT = 400;
    public static int BLOCK_SIZE;
    public static int GRID_WIDTH;
    public static int GRID_HEIGHT;
    public static int NUMBER_OF_FOXES;
    public static int NUMBER_OF_RABBITS;
    public static int NUMBER_OF_GRASS;
    public static int STEP_TIME;

    public static void main(String[] args) {

        JFrame window = new JFrame("Life");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setVisible(true);
        window.setLocation(700, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}