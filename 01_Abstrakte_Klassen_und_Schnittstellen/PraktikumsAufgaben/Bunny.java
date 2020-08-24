import java.awt.Color;

public class Bunny extends Creature implements Animal{
    
    public Bunny(){
        super(Color.BLUE);
        x_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_WIDTH);
        y_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_HEIGHT);
    }

    public void step(){

    }

    public void eat(Creature kreatur){
        if (kreatur instanceof Grass) {
            kreatur.delete();   
        }
    }
}