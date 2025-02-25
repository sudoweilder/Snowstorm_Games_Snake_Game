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

    public void move(){ // animation part needed
			//
	Point head = body.get(0);
	for (int i = body.size() - 1; i > 0; i--){
	    body.set(i, body.get(i - 1));
	}
	body.set(0, new Point(head.x + heading[0], head.y + heading[1]));

    }
    
    public boolean isDead(){
	return false;
    }
}
