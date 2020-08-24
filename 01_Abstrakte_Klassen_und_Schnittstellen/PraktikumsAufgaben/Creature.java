import java.awt.Graphics;
import java.awt.Color;

public abstract class Creature {
    
    public int x_grid_position;
    public int y_grid_position;
    public Color color;
    public boolean removed = false;

    //Konstruktor welcher als Parameter die Farbe der Figur aufnimmt
    Creature(Color color){

    }

    //Zeichnungsmethode mit Graphics-Parameter
    public void draw(Graphics g){

    }

    //Löschmethode welche den Merker entsprechend setzt (keine Parameter)
    public void delete(){
        removed = true;
    }

    //Methode um die Position des Lebewesens zu setzten (x, y als Parameter)
    public void setPosition(int x, int y){

    }

    //Abstrakte Methode für den Schritt (keine Parameter)
    public abstract void step();

}