import java.awt.*;

public class Game {
    public static final int panelWidth = 600; // current setup--could be changed by the user in the future. 
    public static final Snake SNAKE = new Snake();

    public static void main(String[] args) {
        System.out.println();

        // Each block is 20x20 pixels; this creates a 25x25 large grid (lines not added)
        DrawingPanel panel = new DrawingPanel(panelWidth, panelWidth);
	panel.addKeyListener(new MyKeyListener());
        panel.setBackground(Color.BLACK);

        SNAKE.getPanel(panel);

        // Start the game loop
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);  // Update every 100 milliseconds (This is the tick rate!)
                    SNAKE.move();
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
        }).start();
    }
}
