/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;
//each array snake is equal to previous - 8.5
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author 802811
 */
public class World extends JPanel {
     private Timer timer;
     private Snake snake1;
     private PlayingField playf;
     private Food food;
     private ArrayList<Snake> snakes;
   
        
    
     

    public World() {
        super();
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/10);
        playf = new PlayingField(30,30);
        snake1 = new Snake(40,40);
        food = new Food (300, 300);
        snakes = new ArrayList<Snake>();
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.RED);
        playf.draw(g);
        if (snake1.isAlive())snake1.draw(g);
        for (Snake snake : snakes ) 
        snake.draw(g);
        if (food.isAlive())food.draw(g);
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {         
            snake1.update();
            for (Snake snake : snakes ) 
            snake.update();
            checkCollisions();
            repaint();
        }
    }
    public void checkCollisions() {
        
        if (snake1.getBounds().intersects(playf.getBounds())){
            
        }
        else {
           snake1.die(); 
           
        }
        
        for (Snake snake : snakes ) {
          int newVx = snake1.getVx();
          int newVy = snake1.getVy();
          int count = snakes.size(); 
        snakes.get(count -1).setVy(newVy);
        snakes.get(count - 1).setVx(newVx);
            
        if (snake1.getBounds().intersects(snakes.get(count-1).getBounds())){
            snake1.die();
        }
        
        }
          
        if (snake1.getBounds().intersects(food.getBounds())){
            food.die();
            food = new Food(300, 200);
            if (snakes.size() < 1) {
            if (snake1.getVy() > 0 ) {
            snakes.add(new Snake(snake1.getX(), snake1.getY() - 9));
            }
            if (snake1.getVy() < 0 ) {
                snakes.add(new Snake(snake1.getX(), snake1.getY() + 9));
            }
            if (snake1.getVx() > 0 ) {
                snakes.add(new Snake(snake1.getX() - 9, snake1.getY()));
            }
            if (snake1.getVx() < 0  ) {
                snakes.add(new Snake(snake1.getX() + 9, snake1.getY()));
            }
            }
            int count = snakes.size(); 
            if (snakes.size() >= 1) {
            if (snake1.getVy() < 0) {
                snakes.add(new Snake(snakes.get(count - 1).getX(), snakes.get(count - 1).getY() - 9));
            }
              if (snake1.getVy() < 0 ) {
                snakes.add(new Snake(snakes.get(count - 1).getX(), snakes.get(count - 1).getY() + 9));
            }
            if (snake1.getVx() > 0 ) {
                snakes.add(new Snake(snakes.get(count - 1).getX() - 9, snakes.get(count - 1).getY()));
            }
            if (snake1.getVx() < 0  ) {
                snakes.add(new Snake(snakes.get(count - 1).getX() + 9, snakes.get(count - 1).getY()));
            }
        }
        }
    }

               
        
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake1.move("right");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            snake1.move("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            snake1.move("up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            snake1.move("down");
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

