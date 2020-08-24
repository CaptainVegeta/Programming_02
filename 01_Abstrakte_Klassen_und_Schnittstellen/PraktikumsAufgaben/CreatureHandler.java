import java.awt.Graphics;

public class CreatureHandler {
    
    public static int MAX_NUMBER_OF_CREATURES = 10000;
    Creature[] allCreatures;

    public CreatureHandler(){
        allCreatures = new Creature[MAX_NUMBER_OF_CREATURES];
    }

    //Methode um Kreaturen hinzuzufügen (Creature als Parameter, welches dem Array hinzugefügt werden soll).
    public void add(Creature kreature){
        for (int i = 0; i < allCreatures.length; i++) {
            if (allCreatures[i] == null || kreature.removed == true){
                allCreatures[i] = kreature;
                break;
            }
        }
    }

    //Schritt-Methode welche alle Schritt-Methoden der Kreaturen aufruft. (keine Parameter)
    public void stepForAll(){
        for (int i = 0; i < allCreatures.length; i++) {
            if (allCreatures[i] != null && !allCreatures[i].removed){
                allCreatures[i].step();
            }
        }
    }

    //Zeichnungsmethode welche alle Zeichnungsmethoden der Kreaturen aufruft. (Graphics als Parameter)
    public void drawForAll(Graphics g){
        for (int i = 0; i < allCreatures.length; i++) {
            if (allCreatures[i] != null && !allCreatures[i].removed){
                allCreatures[i].draw(g);
            }
        }
    }

    //Methode um alle Kreaturen auf einem Punkt zu erhalten. Nimmt als Parameter x und y auf und gibt ein Array mit allen Kreaturen, 
    //welche sich auf diesen Punkt befinden.
    public Creature[] checkCoordinates(int x, int y){
        int number = 0;
        for (int i = 0; i < allCreatures.length; i++) {
            if (allCreatures[i] != null && !allCreatures[i].removed) {
                if (allCreatures[i].x_grid_position == x && allCreatures[i].y_grid_position == y) {
                    number++;
                }
            }
        }
        Creature[] creaturesOnCoordinate = new Creature[number];
        int index = 0;
        for (int i = 0; i < allCreatures.length; i++) {
            if (allCreatures[i] != null && !allCreatures[i].removed) {
                if (allCreatures[i].x_grid_position == x && allCreatures[i].y_grid_position == y) {
                    creaturesOnCoordinate[index] = allCreatures[i];
                    index++;
                }
            }
        }
        return creaturesOnCoordinate;
    }

    //Methode um das Fressen zu überprüfen (keine Parameter). Geht alle Kreaturen durch und
    //führt bei allen Animal-Kreaturen Kollisionstest durch. Dabei wird dessen Position mit der
    //vorherigen Funktion verwendet und alle Kreaturen auf diesem Feld ermittelt. All diese
    //Kreaturen werden der Schnittstellen-Methode eat der entsprechenden Kreatur übergeben.
    public void isEatable(){
        for (int i = 0; i < allCreatures.length; i++) {
            if (allCreatures[i] != null && !allCreatures[i].removed) {
                if (allCreatures[i] instanceof Animal) {
                    //TypeCast Creature->Animal damit Zugriff auf entsprechendes Animal möglich ist
                    Animal animal = (Animal) allCreatures[i];
                    //übergibt x-&y-Position und speichert zurückgegebenes Array in neuem Array ab
                    Creature[] eatablesList = checkCoordinates(allCreatures[i].x_grid_position, allCreatures[i].y_grid_position);
                    //Führe nur aus wenn Liste Inhalt hat
                    if (eatablesList.length > 1) {
                        for (int j = 0; j < eatablesList.length; j++) {
                            if(eatablesList[j] != allCreatures[i]){
                                animal.eat(eatablesList[j]);
                            }
                        }
                    }
                }                
            }

        }
    }
}