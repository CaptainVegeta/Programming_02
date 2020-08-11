package ch.teko;

import java.awt.Color;

public class Grass extends Creature{
    
    public Grass(){
        super(Color.GREEN, 1);
        x = (int) (Math.random() * Life.GRID_WIDTH);
        y = (int) (Math.random() * Life.GRID_HEIGHT);
    }

    @Override
    public void doStep() {
        float random = (float) Math.random();
        
        if(random <= 0.01f){
            if(x + 1 < Life.GRID_WIDTH && Life.leben.handler.getCreaturesOnPosition(x + 1, y).length == 0){
                Grass grass_1 = new Grass();
                grass_1.setPosition(x + 1, y);
                Life.leben.handler.addCreature(grass_1);
            }

            if(x - 1 > 0 && Life.leben.handler.getCreaturesOnPosition(x - 1, y).length == 0){
                Grass grass_2 = new Grass();
                grass_2.setPosition(x - 1, y);
                Life.leben.handler.addCreature(grass_2);
            }

            if(y + 1 < Life.GRID_HEIGHT && Life.leben.handler.getCreaturesOnPosition(x, y + 1).length == 0){
                Grass grass_3 = new Grass();
                grass_3.setPosition(x, y + 1);
                Life.leben.handler.addCreature(grass_3);
            }

            if(y - 1 > 0 && Life.leben.handler.getCreaturesOnPosition(x, y - 1).length == 0){
                Grass grass_4 = new Grass();
                grass_4.setPosition(x, y - 1);
                Life.leben.handler.addCreature(grass_4);
            }
        }
    }
}