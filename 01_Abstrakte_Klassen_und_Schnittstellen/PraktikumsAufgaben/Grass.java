import java.awt.Color;

public class Grass extends Creature{
    
    public Grass(){
        super(Color.GREEN);
        x_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_WIDTH);
        y_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_HEIGHT);
    }

    public void step(){

    }
}