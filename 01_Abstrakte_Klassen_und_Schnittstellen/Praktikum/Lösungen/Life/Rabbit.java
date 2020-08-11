import java.awt.Color;

public class Rabbit extends Creature implements Animal{
    public int leben = 100;

    public Rabbit(){
        super(Color.BLUE);
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

        if(leben <= 0){
            remove();
        } else {
            leben--;
        }
    }

    @Override
    public void eat(Creature other_creature) {
        if(other_creature instanceof Grass){
            other_creature.remove();
            float random = (float) Math.random();
            if(random < 0.1){
                Rabbit rabbit = new Rabbit();
                rabbit.setPosition(x, y);
                Life.leben.handler.addCreature(rabbit);
            }

            leben = 100;
        }
    }
}