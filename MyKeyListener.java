import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.ArrayList;
//import java.swing.*;

public class MyKeyListener implements KeyListener{
  Snake snake;

  public MyKeyListener(Snake snake){
      this.snake = snake;
  }

  
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
   
    snake.addMoves(key);
    /* 
    if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
        snake.setHeading(-1,0);
    }
    
    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
        snake.setHeading(1, 0);
    }
    
    if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
        snake.setHeading(0, -1);
    }
    
    if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
        snake.setHeading(0,1);
    }
    */
  }

  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}
}
