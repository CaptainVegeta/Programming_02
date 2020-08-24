import java.awt.Graphics;
import java.awt.Color;

public abstract class Creature {
    
    public int x_grid_position;
    public int y_grid_position;
    public Color color;
    public boolean removed = false;

    //Konstruktor welcher als Parameter die Farbe der Figur aufnimmt
    Creature(Color color){
        this.color = color;
    }

    //Zeichnungsmethode mit Graphics-Parameter
    public void draw(Graphics g){
        if (!removed) {
            int centered_x = x_grid_position * Life.BLOCK_SIZE;
            int centered_y = y_grid_position * Life.BLOCK_SIZE;
            g.setColor(color);
            g.fillRect(centered_x, centered_y, Life.BLOCK_SIZE, Life.BLOCK_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(centered_x, centered_y, Life.BLOCK_SIZE, Life.BLOCK_SIZE);
        }

    }

    //Löschmethode welche den Merker entsprechend setzt (keine Parameter)
    public void delete(){
        removed = true;
    }

    //Methode um die Position des Lebewesens zu setzten (x, y als Parameter)
    public void setPosition(int x, int y){
        x_grid_position = x;
        y_grid_position = y;
    }

    //Abstrakte Methode für den Schritt (keine Parameter)
    public abstract void step();

}