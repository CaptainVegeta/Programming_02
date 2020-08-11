package ch.teko;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;

import javax.swing.JFrame;

public class Life extends JFrame{
    public static int WINDOW_WIDTH = 400;
    public static int WINDOW_HEIGHT = 400;
    public static int BLOCK_SIZE = 5;
    public static int GRID_WIDTH = WINDOW_WIDTH / BLOCK_SIZE;
    public static int GRID_HEIGHT = WINDOW_HEIGHT / BLOCK_SIZE;
    public static int NUMBER_OF_FOXES = 20;
    public static int NUMBER_OF_RABBITS = 25;
    public static int NUMBER_OF_GRASS = 80;
    public static int STEP_TIME = 10;
    
    public static Life leben;
    public static JFrame graph;
    public static JFreeChart chart;
    public static ChartPanel chart_panel;
    public static XYPlot plot;

    public CreatureHandler handler;
    public BufferedImage buffered_image;
    public Graphics buffered_g;
    
    public static void main(String[] args) {
        graph = new JFrame();
        graph.setSize(400, 400);
        graph.setVisible(true);

        chart = ChartFactory.createXYLineChart("Creature Plot", "step number", "creature number", null);
        plot = chart.getXYPlot();
        chart_panel = new ChartPanel(chart);
        graph.add(chart_panel);

        leben = new Life();
        
        while(true){
            leben.handler.sortCreature();
            leben.handler.doStep();
            leben.handler.checkForFood();
            leben.handler.updateSeries();
            SimplifiedDelay.delay(STEP_TIME);
            leben.repaint();
            leben.updateDataset();
        }
    }

    public Life(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        buffered_image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        buffered_g = buffered_image.createGraphics();
        setVisible(true);

        handler = new CreatureHandler();

        for(int i = 0; i < NUMBER_OF_FOXES; i++){
            handler.addCreature(new Fox());
        }

        for(int i = 0; i < NUMBER_OF_RABBITS; i++){
            handler.addCreature(new Rabbit());
        }

        for(int i = 0; i < NUMBER_OF_GRASS; i++){
            handler.addCreature(new Grass());
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(buffered_g);
        handler.draw(buffered_g);
        g.drawImage(buffered_image, 0, 0, null);
    }

    public void updateDataset(){
        plot.setDataset(leben.handler.getDataset());
        graph.revalidate();
    }
}