import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    public static int points = 0;
    public static String id = null;
    public static void main(String[] args) throws FileNotFoundException, InterruptedException { // This is where the Game Starts
        Scanner console = new Scanner(System.in);
        mainMenu(console);

    }
    public static void mainMenu(Scanner console) throws FileNotFoundException, InterruptedException { // Main menu with different options and leads to everything(so far)
        System.out.print("|-------MAIN MENU------|\n"
                            + "   1: Start Game\n"
                            + "   2: Scoreboard\n"
                            + "   3: Credits\n"
                            + "   4: Exit Game\n"
                            + "|----------------------|\n"
                            + "Type: ");
        
        int choice = console.nextInt();
        if (choice == 1) { // runs the main game loop
            askName(console); // gives the player id
            boardSize(console); // gives 3 different options of board sizes
            SnakeGame.gameLoop(); // runs the snake game
            Score.writeScoreboard(id, points); // after snake dies, writes both the id and the points to scoreboard.txt
            Score.displayScoreboard(console); // prints the scoreboard to console and then asks the player if they want to go back to the menu or exit the program

            }else if (choice == 2) Score.displayScoreboard(console);
            else if (choice == 3) credits(console);
            else if (choice == 4) System.exit(0);
            else {
                System.out.println("Invaild Entry"); 
                mainMenu(console);
            }
        }
        // Method for the player to choose the size of the panel (these are fixed)
    public static void boardSize(Scanner console) { 
        System.out.print("Set board size:\n"
                        + "1: Small\n"
                        + "2: Medium\n"
                        + "3: Large\n"
                        + "(Type 1, 2, or 3): ");
        int choice = console.nextInt();
        //Each block is 20x20 pixels, the comments are the block dimensions
        if (choice == 1) SnakeGame.panelWidth = 300; //Smallest 15x15
        else if (choice == 2) SnakeGame.panelWidth = 500; // Medium (Defult) 25x25
        else if (choice == 3) SnakeGame.panelWidth = 700; // Large 35x35
        else { // if any number is entered but 1, 2, or 3 then it calls the method again
            System.out.println("Invaild"); 
            boardSize(console);
        }
    }
    public static void credits(Scanner console) throws FileNotFoundException, InterruptedException { // Credits to ourselves (just cause)
        System.out.print("|---------------Credits-----------------|\n"
                        + " Made by: Connor, Jackson, Miles, Robert\n\n"
                        + " Press 1 to return to the main menu\n"
                        + "|---------------------------------------|\n"
                        + "Type: ");
        if (console.nextInt() == 1) mainMenu(console); // returns to menu
        else {
            System.out.println("Invaild Entry"); 
            credits(console);
        }
    }  
    public static void askName(Scanner console) {
        System.out.print("Enter name (Max of 10 characters): ");
        String input = console.next();
        if (input.length() > 10) { // if the name is greater than 10 characters it makes the user re-enter the name until it's less than 10 characters.
            System.out.println("Name is too long. Please enter a name with a max of 10 characters");
            askName(console);
        }
        else {
            id = input;
        }
    }
}
