import java.awt.Color;

public class Grass extends Creature{
    
    public Grass(){
        super(Color.GREEN);
        x_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_WIDTH);
        y_grid_position = SimplifiedRandom.getRandomInt(0, Life.GRID_HEIGHT);
    }

    public void step(){
        int random = SimplifiedRandom.getRandomInt(1, 100);
        if (random == 100) {

            //Rechts
            Grass grassRight = new Grass();
            int xRight = x_grid_position + 1;
            if (xRight <= Life.GRID_WIDTH && Life.leben.handler.checkCoordinates(xRight, y_grid_position).length == 0) {
                grassRight.setPosition(xRight, y_grid_position);
                Life.leben.handler.add(grassRight);
            }

            //Unten
            Grass grassDown = new Grass();
            int yDown = y_grid_position + 1;
            if (yDown <= Life.GRID_HEIGHT && Life.leben.handler.checkCoordinates(x_grid_position, yDown).length == 0) {
                grassDown.setPosition(x_grid_position, yDown);
                Life.leben.handler.add(grassDown);
            }

            //Links
            Grass grassLeft = new Grass();
            int xLeft = x_grid_position - 1;
            if (xLeft >= 0 && Life.leben.handler.checkCoordinates(xLeft, y_grid_position).length == 0) {
                grassLeft.setPosition(xLeft, y_grid_position);
                Life.leben.handler.add(grassLeft);
            }

            //Oben
            Grass grassUp = new Grass();
            int yUp = y_grid_position - 1;
            if (yUp >= 0 && Life.leben.handler.checkCoordinates(x_grid_position, yUp).length == 0) {
                grassUp.setPosition(x_grid_position, yUp);
                Life.leben.handler.add(grassUp);
            }
        }
    }
}