import java.awt.*;
import java.awt.Graphics.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;


public class Apple{
    private Graphics graphics;
    private Snake snake;
    private int panelSize;
    private int x;
    private int y;
 

    public void place(){
	
	Random random = new Random();
	
	int newX = snake.getBody().get(2).x;
	int newY = snake.getBody().get(2).y;
	ArrayList<Point> body = snake.getBody();
	ArrayList<Point> pointsChecked = new ArrayList<>();
	boolean pointBad = true;

	// This loop finds a the the snake is no on top of 
	do{
	    boolean pointChecked = true;

	    // verifies that point hasn't been checked.
	    Point newPoint;
	    do {
		newX = random.nextInt(panelSize/20);
		newY = random.nextInt(panelSize/20);
		newPoint = new Point (newX, newY);
		/*for (Point point : pointsChecked){
		    pointChecked = (point.x == newX && point.y == newY ) && pointChecked;
		}*/
	    } while (pointChecked && pointsChecked.contains(newPoint) && pointsChecked.size() != 0);
	

	    
	    pointBad = body.contains(newPoint);
	    pointsChecked.add(new Point(newX, newY));
	} while (pointBad);

	x = newX;
	y = newY;

	draw();
    }
    
    public void draw(){
	// Places Square down
	graphics.setColor(Color.RED);
	graphics.fillRect(x * 20, y * 20, 20, 20);
	graphics.setColor(Color.GREEN);
    }


    public Point getCoord(){
	return new Point(x, y);
    }


    public Apple(Graphics g, Snake snake, int panelSize){
	this.graphics = g;
	this.snake = snake;
	this.panelSize = panelSize;
	place();
	
    }






}
