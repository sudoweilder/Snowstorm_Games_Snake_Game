import java.awt.Graphics.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake{
    private int[] heading = {0,0};
    private Graphics console;
    private ArrayList<Point> body = new ArrayList<>();

    public Snake(Graphics console){ //initializes the snake object
	this.console = console; 
	body.add(new Point(0,0));
	//console.fillRect(20*
    }
    
    
    //500x500 center point
    
    public void grow(){
    }

    public void move(){
    }
    
    public boolean isDead(){
	return false;
    }
}
