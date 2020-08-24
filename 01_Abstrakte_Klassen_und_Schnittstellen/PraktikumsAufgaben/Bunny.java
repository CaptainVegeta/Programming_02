import java.awt.Color;

public class Bunny extends Creature implements Animal{
    
    public Bunny(){
        super(Color.BLUE);
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
        if (kreatur instanceof Grass) {
            kreatur.delete();
            int random = SimplifiedRandom.getRandomInt(1, 10);
            if(random == 5){
                Bunny littleBunny = new Bunny();
                littleBunny.setPosition(x_grid_position, y_grid_position);
                Life.leben.handler.add(littleBunny);
            }
        }
    }
}