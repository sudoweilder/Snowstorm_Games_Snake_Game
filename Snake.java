import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private int[] heading = {0, 0};  // Direction of movement
    private DrawingPanel panel;  // Reference to DrawingPanel
    private int dx = 1;  // Movement in x direction
    private int dy = 0;  // Movement in y direction
    private ArrayList<Point> body = new ArrayList<>();  // Snake body

    public Snake() {
        body.add(new Point(SnakeGame.panelWidth / 40, SnakeGame.panelWidth / 40));  // Add the starting point of the snake
	grow(); grow();
    }

    public void getPanel(DrawingPanel panel){
	this.panel = panel;
    }

    // Method to move the snake
    public void move() {
        Point head = body.get(0);
	Point rear = body.get(body.size() - 1);
        int x = head.x + dx;
        int y = head.y + dy;
        Point newHead = new Point(x, y);
        body.add(0, newHead);  // Add new head to the front of the body
        body.remove(body.size() - 1);  // Remove the last segment of the body
        drawSnake(rear.x, rear.y);  // Draw the snake after moving
    }

    // Method to grow the snake
    public void grow() {
        Point head = body.get(0);
        int x = head.x + dx;
        int y = head.y + dy;
        body.add(0, new Point(x, y));  // Add new segment at the front
        Game.points++;
    }

    // Method to draw the snake
    public void drawSnake(int backX, int backY) {
        Graphics g = panel.getGraphics();
        g.setColor(Color.BLACK);
	g.fillRect(backX * 20, backY*20, 20, 20);
	g.setColor(Color.GREEN);
        g.setColor(Color.GREEN);

        for (Point point : body) { 
            g.fillRect(point.x * 20, point.y * 20, 20, 20);  // Draw rectangle for each body part
        }
    }

    // Method to check if the snake is dead
    public boolean isDead() {
        Point head = body.get(0);
        // Check if the head collides with the body
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        // Check if the head is out of bounds (assuming a 500x500 game area for now atleast)
        if (head.x < 0 || head.x >= SnakeGame.panelWidth / 20 || head.y < 0 || head.y >= SnakeGame.panelWidth / 20) {
            return true;
        }
        return false;
    }

    // Set the direction of the snake's movement
    public void setHeading(int dx, int dy) {
	if(this.dx!=-dx || this.dy!=-dy){
	        this.dx = dx;
	        this.dy = dy;
	}
    }

    public ArrayList<Point> getBody(){
	return body;
    }
}
