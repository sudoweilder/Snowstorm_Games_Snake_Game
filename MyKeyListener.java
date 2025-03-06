import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.ArrayList;
//import java.swing.*;

public class MyKeyListener implements KeyListener{
  Snake snake = Game.SNAKE;

  
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    
    if (key == KeyEvent.VK_LEFT) {
        snake.setHeading(-1,0);
    }
    
    if (key == KeyEvent.VK_RIGHT) {
        snake.setHeading(1, 0);
    }
    
    if (key == KeyEvent.VK_UP) {
        snake.setHeading(0, -1);
    }
    
    if (key == KeyEvent.VK_DOWN) {
        snake.setHeading(0,1);
    }
  }

  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}
}
