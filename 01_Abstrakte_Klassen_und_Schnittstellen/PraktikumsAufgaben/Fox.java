import java.awt.Color;

public class Fox extends Creature implements Animal {
    
    public Fox(){
        super(Color.RED);
        x_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_WIDTH);
        y_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_HEIGHT);
    }

    public void step(){
        int direction = SimplifiedRandom.getRandomInt(1, 4);
        switch (direction) {
            case 1: //rechts
                x_grid_position += 1;
                if (x_grid_position >= Life.GRID_WIDTH) {
                    x_grid_position -=1;
                }
                break;
            case 2: //unten
                y_grid_position += 1;
                if (y_grid_position >= Life.GRID_HEIGHT) {
                    y_grid_position -=1;
                }
                break;                
            case 3: //links
                x_grid_position -= 1;
                if (x_grid_position <= 0) {
                    x_grid_position +=1;
                }
                break;
            case 4: //oben
                y_grid_position -= 1;
                if (y_grid_position <= 0) {
                    y_grid_position +=1;
                }  
            default:
                break;
        }
    }

    public void eat(Creature kreatur){
        if (kreatur instanceof Bunny) {
            kreatur.delete();
        }
    }
}