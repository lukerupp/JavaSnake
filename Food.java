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
public class Food {
    private int x, y, height, width;
    private Rectangle bounds;
    private Color color;
    private boolean alive; 
    
   public Food (int cWidth, int cHeight) {
       this.height = 15;
       this.width = 15;
       this.x = (int) ((Math.random() * 510) + 30);
       this.y = (int) ((Math.random() * 301) + 30);
       this.color = Color.RED;
       this.bounds = new Rectangle (this.x, this.y, this.height, this.width);
       this.alive = true;
       
   }
     public void draw(Graphics g) {
        g.setColor(this.color);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(bounds);
    }

    public Rectangle getBounds() {
        return bounds;
    }
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public void die(){
        alive = false;
    }
}
