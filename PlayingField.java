/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author 802811
 */
public class PlayingField {
    private int height, width, x, y;
    private Rectangle bounds;
    private Color color;
    
    public PlayingField(int cWidth, int cHeight) {
        this.height =  325;
        this.width = 540;
        this.x = 25;
        this.y = 25;
        this.color = Color.BLUE;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
    
    public void draw(Graphics g) {
        g.setColor(this.color);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(bounds);
    }

}
