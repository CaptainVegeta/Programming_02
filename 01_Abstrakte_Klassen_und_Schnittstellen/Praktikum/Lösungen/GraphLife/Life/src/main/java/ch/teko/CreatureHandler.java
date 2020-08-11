package ch.teko;

import java.awt.Graphics;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CreatureHandler {
    public static int MAX_NUMBER_OF_CREATURES = 160000;

    public Creature creatures[];
    public XYSeries rabbit_series;
    public XYSeries fox_series;
    public XYSeries grass_series;
    public int setp_number = 0;
    
    public CreatureHandler(){
        creatures = new Creature[MAX_NUMBER_OF_CREATURES];
        fox_series = new XYSeries("foxes");
        rabbit_series = new XYSeries("rabbits");
        grass_series = new XYSeries("grasses");
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
        setp_number++;
    }

    public int numberOfCreature(String name){
        int number = 0;

        if(name.equals("fox")){
            for(int i = 0; i < creatures.length; i++){
                if(creatures[i] instanceof Fox && !creatures[i].removed){
                    number++;
                }
            }
        } else if(name.equals("rabbit")){
            for(int i = 0; i < creatures.length; i++){
                if(creatures[i] instanceof Rabbit && !creatures[i].removed){
                    number++;
                }
            }
        } else if(name.equals("grass")){
            for(int i = 0; i < creatures.length; i++){
                if(creatures[i] instanceof Grass && !creatures[i].removed){
                    number++;
                }
            }
        }

        return number;
    }

    public void updateSeries(){
        fox_series.add(setp_number, numberOfCreature("fox"));
        rabbit_series.add(setp_number, numberOfCreature("rabbit"));
        grass_series.add(setp_number, numberOfCreature("grass"));
    }

    public XYDataset getDataset(){
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(fox_series);
        dataset.addSeries(rabbit_series);
        dataset.addSeries(grass_series);
        return dataset;
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