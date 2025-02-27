import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private int[] heading = {0, 0};  // Direction of movement
    private DrawingPanel panel;  // Reference to DrawingPanel
    private int dx = 1;  // Movement in x direction
    private int dy = 0;  // Movement in y direction
    private ArrayList<Point> body = new ArrayList<>();  // Snake body

    public Snake(DrawingPanel panel) {
        this.panel = panel;
        body.add(new Point(0, 0));  // Add the starting point of the snake
    }

    // Method to move the snake
    public void move() {
        Point head = body.get(0);
        int x = head.x + dx;
        int y = head.y + dy;
        Point newHead = new Point(x, y);
        body.add(0, newHead);  // Add new head to the front of the body
        body.remove(body.size() - 1);  // Remove the last segment of the body
        drawSnake();  // Draw the snake after moving
    }

    // Method to grow the snake
    public void grow() {
        Point head = body.get(0);
        int x = head.x + dx;
        int y = head.y + dy;
        body.add(0, new Point(x, y));  // Add new segment at the front
    }

    // Method to draw the snake
    public void drawSnake() {
        Graphics g = panel.getGraphics();
        panel.clear();  // Clear the panel before drawing
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
        if (head.x < 0 || head.x >= 500 / 20 || head.y < 0 || head.y >= 500 / 20) {
            return true;
        }
        return false;
    }

    // Set the direction of the snake's movement
    public void setHeading(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
