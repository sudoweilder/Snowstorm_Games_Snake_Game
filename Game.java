import java.awt.*;
import java.util.Scanner;

public class Game {
    static Scanner console = new Scanner(System.in);

    public  static int panelWidth = 500; // current setup--could be changed by the user in the future. 
    public static void BoardSize(Scanner console) {
        System.out.print("Set board size: \nSmall: 1 \nMedium: 2 \nLarge: 3 \n(Type 1, 2, or 3): ");
        int choice = console.nextInt();
        if (choice == 1) panelWidth = 300;
        else if (choice == 2) panelWidth = 500;
        else if (choice == 3) panelWidth = 700; // max size; panel doesn't fit screen well when over 700
        else System.out.println("Invaild");
    }

    public static void main(String[] args) {


        
        BoardSize(console);
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
