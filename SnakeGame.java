import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SnakeGame {
    
    public static int panelWidth = 500; // Default size of the panel (later changed when the player sets the board size)
    public static final Snake SNAKE = new Snake();
    public static Scanner console = new Scanner(System.in);


    public static void gameLoop() throws InterruptedException, FileNotFoundException {
        System.out.println();

        // Each block is 20x20 pixels; this creates a 25x25 large grid (lines not added)
        DrawingPanel panel = new DrawingPanel(panelWidth, panelWidth);
	    panel.addKeyListener(new MyKeyListener());
        panel.setBackground(Color.BLACK);

        SNAKE.getPanel(panel);
	Apple apple = new Apple(panel.getGraphics(), SNAKE, panelWidth);
        Thread.sleep(5000); // breif timer before the game starts (gives time to open the window)
        // Start the game loop
            while (true) {
                try {
                    Thread.sleep(100);  // Update every 100 milliseconds (This is the tick rate!)
                    SNAKE.move();
		    if (SNAKE.getBody().get(0).equals(apple.getCoord())){
			    SNAKE.grow();
			    apple.place();
		    }
                    if (SNAKE.isDead()) {
			Graphics g = panel.getGraphics();
                        g.setColor(Color.RED);
                        g.drawString("Game Over", panelWidth / 2 - 30, panelWidth / 2);
			break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
