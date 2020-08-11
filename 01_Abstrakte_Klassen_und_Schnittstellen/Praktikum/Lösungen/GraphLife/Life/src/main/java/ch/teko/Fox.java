package ch.teko;

import java.awt.Color;

public class Fox extends Creature implements Animal{
    
    public Fox(){
        super(Color.RED, 3);
        x = (int) (Math.random() * Life.GRID_WIDTH);
        y = (int) (Math.random() * Life.GRID_HEIGHT);
    }

    @Override
    public void doStep() {
        float random = (float) Math.random();
        
        if(random <= 0.25f){
            x = x - 1;
        } else if(random <= 0.5f){
            x = x + 1;
        } else if(random <= 0.75f){
            y = y - 1;
        } else if(random <= 1f){
            y = y + 1;
        }

        if(x < 0){
            x = 0;
        } else if(x > Life.GRID_WIDTH){
            x = Life.GRID_WIDTH;
        }

        if(y < 0){
            y = 0;
        } else if(y > Life.GRID_HEIGHT){
            y = Life.GRID_WIDTH;
        }
    }

    @Override
    public void eat(Creature other_creature) {
        if(other_creature instanceof Rabbit){
            other_creature.remove();
        }
    }
}