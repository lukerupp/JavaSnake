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
public class Snake {
    private int height,width, x, y, vx, vy;
    private Rectangle bounds;
    private Color color;
    private int score;
    private final int SPEED = 15;
    private boolean alive;
    
    public Snake (int cWidth, int cHeight) {
        this.score = 0;
        this.alive = true;
        this.x = cWidth/2;
        this.y = cHeight/2;
        this.width = 15;
        this.height = 15;
        this.color = Color.YELLOW;
        this.bounds = new Rectangle (this.x, this.y, this.width, this.height);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
    
     public void move(String direction) {
        if (direction.equals("right")) {
            vx = SPEED;
             vy = 0;
        }
        else if (direction.equals("left")) {
            vy = 0;
            vx = -SPEED;
        }
        else if (direction.equals("up")) {
            vx = 0;
            vy = -SPEED;
        }
        else if (direction.equals("down")) {
            vy = SPEED;
            vx = 0;
        } 
     }
        
    public void draw(Graphics g) {
        g.setColor(this.color);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(bounds);
    }
    public void update(){
        this.x += vx;
        this.y += vy;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
                
    }
    public void stop(){
        this.vx = 0;
        this.vy = 0;
    }
   
}
