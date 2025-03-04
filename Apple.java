import java.awt.*;
import java.awt.Graphics.*;
import java.util.Random;


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
		newX = random.nextInt(panelSize + 1);
		newY = random.nextInt(panelSize + 1);
		
		for (Point part : body){
		    pointChecked = (part.x = newX || part.y = newY ) && pointChecked;
		}

	    } while (pointChecked);
	


	    for (Point part: body){
		pointBad = ((newX = part.x) || (newY = part.y)) && pointBad;
	    }

	    pointsChecked.add(new Point(newX, NewY));
	} while (pointBad);
	
	// Places Square down
	graphics.setColor(Color.RED);
	gracphics.fillRect(newX * 20, new Y * 20, 20, 20);
	graphics.setColor(Color.GREEN);

    }



    public Apple(Graphics g, Snake snake, ){
	this.graphics = g;
	this.snake = snake;
    }






}
