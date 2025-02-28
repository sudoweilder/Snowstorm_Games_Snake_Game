import java.awt.*;

public class Game {
    public static final int panelWidth = 520; // current setup--could be changed by the user in the future. 

    public static void main(String[] args) {
        System.out.println();

        // Each block is 20x20 pixels; this creates a 25x25 large grid (lines not added)
        DrawingPanel panel = new DrawingPanel(panelWidth, panelWidth);
        panel.setBackground(Color.BLACK);

        Snake snake = new Snake(panel);

        // Start the game loop
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);  // Update every 100 milliseconds (This is the tick rate!)
                    snake.move();
                    if (snake.isDead()) {
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
