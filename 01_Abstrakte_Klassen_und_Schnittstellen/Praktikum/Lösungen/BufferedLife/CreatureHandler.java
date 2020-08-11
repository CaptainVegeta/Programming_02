import java.awt.Graphics;

public class CreatureHandler {
    public static int MAX_NUMBER_OF_CREATURES = 160000;

    public Creature creatures[];
    
    public CreatureHandler(){
        creatures = new Creature[MAX_NUMBER_OF_CREATURES];
    }

    public void addCreature(Creature creature){
        for(int i = 0; i < creatures.length; i++){
            if(creatures[i] == null || creatures[i].removed){
                creatures[i] = creature;
                break;
            }
        }
    }

    public void doStep(){
        for(int i = 0; i < creatures.length; i++){
            if(creatures[i] != null && !creatures[i].removed){
                creatures[i].doStep();
            }
        }
    }

    public void draw(Graphics g){
        for(int i = 0; i < creatures.length; i++){
            if(creatures[i] != null && !creatures[i].removed){
                creatures[i].draw(g);
            }
        }
    }

    public void checkForFood(){
        for(int i = 0; i < creatures.length; i++){
            if(creatures[i] != null && !creatures[i].removed){
                if(creatures[i] instanceof Animal){
                    Animal animal = (Animal) creatures[i];
                    Creature[] collided_creatures = getCreaturesOnPosition(creatures[i].x, creatures[i].y);
                    if(collided_creatures.length > 1){
                        for(int j = 0; j < collided_creatures.length; j++){
                            if(collided_creatures[j] != creatures[i]){
                                animal.eat(collided_creatures[j]);
                            }
                        }
                    }
                }
            }
        }
    }

    public Creature[] getCreaturesOnPosition(int x, int y){
        int number = 0;
        for(int i = 0; i < creatures.length; i++){
            if(creatures[i] != null && !creatures[i].removed){
                if(creatures[i].x == x && creatures[i].y == y){
                    number++;
                }
            }
        }

        Creature point_creatures[] = new Creature[number];
        int index = 0;

        for(int i = 0; i < creatures.length; i++){
            if(creatures[i] != null && !creatures[i].removed){
                if(creatures[i].x == x && creatures[i].y == y){
                    point_creatures[index] = creatures[i];
                    index = index + 1;
                }
            }
        }

        return point_creatures;
    }

    public void sortCreature(){
        boolean sorted;
        do{
            sorted = false;
            for(int i = 0; i < creatures.length - 1; i++){
                if(creatures[i] != null & creatures[i + 1] != null){
                    if(creatures[i].layer > creatures[i + 1].layer){
                        Creature creature_tmp = creatures[i + 1];
                        creatures[i + 1] = creatures[i];
                        creatures[i] = creature_tmp;
                        sorted = true;
                    }
                } else {
                    break;
                }
            }
        }while(sorted);
    }
}