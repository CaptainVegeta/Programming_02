import java.awt.Color;

public class Fox extends Creature implements Animal {
    
    public Fox(){
        super(Color.RED);
        x_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_WIDTH);
        y_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_HEIGHT);
    }

    public void step(){

    }

    public void eat(Creature kreatur){
        if (kreatur instanceof Bunny) {
            kreatur.delete();
        }
    }
}