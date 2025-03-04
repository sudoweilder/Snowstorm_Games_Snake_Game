import java.awt.*;
import java.util.ArrayList;
import java.swing.*;

public class MyKeyListener extends KeyListener{
  private int dx=0;
  
  private int dy=0;
  
  public int toDx(){
    return dx;
  }
  
  public int toDy(){
    return dy;
  }
  
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    
    if (key == KeyEvent.VK_LEFT) {
        dx = -1;
    }
    
    if (key == KeyEvent.VK_RIGHT) {
        dx = 1;
    }
    
    if (key == KeyEvent.VK_UP) {
        dy = -1;
    }
    
    if (key == KeyEvent.VK_DOWN) {
        dy = 1;
    }
  }
}
