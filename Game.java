import java.awt.*;

public class Game{
    public static final int panelWidth = 520; // current setup--could be changed by the user in the future. 
    
    public static void main(String[] args){
	System.out.println();

	//each block is 20x20 pixels as a result, this creates a 25X25 large grid(lines not added)
	DrawingPanel panel = new DrawingPanel(panelWidth, panelWidth);
	panel.setBackground(Color.BLACK);

	Snake snake = new Snake(panel.getGraphics());
    }
}
