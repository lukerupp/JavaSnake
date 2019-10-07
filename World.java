/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author 802811
 */
public class World extends JPanel {
     private Timer timer;
     private Snake snake;
     private PlayingField playf;

    public World() {
        super();
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/10);
        playf = new PlayingField(30,30);
        snake = new Snake(80,80);
        
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.RED);
        playf.draw(g);
        if (snake.isAlive())snake.draw(g);
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {         
            snake.update();
            checkCollisions();
            repaint();
        }
    }
    public void checkCollisions() {
        if (snake.getBounds().intersects(playf.getBounds())){
            
        }
        else {
           snake.die(); 
           
        }
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.move("right");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.move("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            snake.move("up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.move("down");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            
        }
}
}
