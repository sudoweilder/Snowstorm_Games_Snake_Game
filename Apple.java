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
	
	int newX;
	int newY;
	ArrayList<Point> body = snake.getBody();
	ArrayList<Point> pointsChecked = new ArrayList<>();
	boolean pointBad = true;

	// This loop finds a the the snake is no on top of 
	do{
	    boolean pointChecked = true;
	    do {
		newX = random.nextInt(panelSize/20);
		newY = random.nextInt(panelSize/20);
		
		for (Point part : body){
		    pointChecked = (part.x == newX || part.y == newY ) && pointChecked;
		}
	    } while (pointChecked && pointsChecked.size() != 0);
	

	    for (Point part: body){
		pointBad = ((newX == part.x) || (newY == part.y)) && pointBad;
	    }

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
