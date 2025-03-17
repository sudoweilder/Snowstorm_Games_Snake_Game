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
    snake.addMoves(e.getKeyCode());
  }

  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}
}
