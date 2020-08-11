package ch.teko;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Creature{
    public int x;
    public int y;
    public Color color;
    public boolean removed = false;
    public int layer;

    public Creature(Color color, int layer){
        this.color = color;
        this.layer = layer;
    }

    public void draw(Graphics g){
        if(!removed){
            int centered_x = (x - Life.BLOCK_SIZE / 2) * Life.BLOCK_SIZE;
            int centered_y = (y - Life.BLOCK_SIZE / 2) * Life.BLOCK_SIZE;
            g.setColor(color);
            g.fillRect(centered_x, centered_y, Life.BLOCK_SIZE, Life.BLOCK_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(centered_x, centered_y, Life.BLOCK_SIZE, Life.BLOCK_SIZE);
        }
    }

    public void remove() {
        removed = true;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract void doStep();
}