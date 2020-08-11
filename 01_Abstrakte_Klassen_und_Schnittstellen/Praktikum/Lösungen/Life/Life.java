import java.awt.Graphics;

import javax.swing.JFrame;

public class Life extends JFrame{
    public static int WINDOW_WIDTH = 400;
    public static int WINDOW_HEIGHT = 400;
    public static int BLOCK_SIZE = 5;
    public static int GRID_WIDTH = WINDOW_WIDTH / BLOCK_SIZE;
    public static int GRID_HEIGHT = WINDOW_HEIGHT / BLOCK_SIZE;
    public static int NUMBER_OF_FOXES = 20;
    public static int NUMBER_OF_RABBITS = 25;
    public static int NUMBER_OF_GRASS = 80;
    public static int STEP_TIME = 100;
    
    public static Life leben;

    public CreatureHandler handler;
    
    public static void main(String[] args) {
        leben = new Life();

        while(true){
            leben.handler.doStep();
            leben.handler.checkForFood();
            SimplifiedDelay.delay(STEP_TIME);
            leben.repaint();
        }
    }

    public Life(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);

        handler = new CreatureHandler();

        for(int i = 0; i < NUMBER_OF_FOXES; i++){
            handler.addCreature(new Fox());
        }

        for(int i = 0; i < NUMBER_OF_RABBITS; i++){
            handler.addCreature(new Rabbit());
        }

        for(int i = 0; i < NUMBER_OF_GRASS; i++){
            handler.addCreature(new Grass());
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        handler.draw(g);
    }
}