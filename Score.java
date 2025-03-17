import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Score {
    
    public static void writeScoreboard(String id, int points) {
        try {
            Map<String, Integer> scores = readScoreboard(); // read the current scores from the file

            scores.put(id, points); // add new score

            scores = sortMapByValueDescending(scores); // sort scores by value in descending order

            scores = scores.entrySet() // limits to only the top 10 scores (for now at least)
                           .stream()
                           .limit(10) // the limiter
                           .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            // write sorted scores back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt"));
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            writer.close();

        } catch (IOException e) { // used ioexception to catch any IO errors 
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> readScoreboard() { 
        Map<String, Integer> scores = new HashMap<>(); // Create a new map to store the scores
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Scoreboard.txt")); 
            String line; // a string to store each line of the file
            while ((line = reader.readLine()) != null) { // read each line of the file
                String[] parts = line.split(" ");
                if (parts.length == 2) { // check if the line has 2 parts
                    String id = parts[0]; // get the id
                    int points = Integer.parseInt(parts[1]); // Get the points
                    scores.put(id, points); // add the id and points to the map
                }
            }
            reader.close();
        } catch (IOException e) { // used ioexception to catch any IO errors
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return scores;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValueDescending(Map<K, V> map) { // sorts the map by value in descending order
        return map.entrySet()
          .stream()
          .sorted(Map.Entry.<K, V>comparingByValue().reversed())
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static void displayScoreboard(Scanner console) throws FileNotFoundException, InterruptedException { // displays the scoreboard when called
        Scanner display = new Scanner(new File("Scoreboard.txt")); // this will take the sorted list
        int rank = 1; // initialize rank
        while (display.hasNextLine()) { // loops through each line in the file
            String line = display.nextLine();
            // adds rank (1st, 2nd, 3rd, etc.)
            if (rank == 1) System.out.println(rank + "st: " + line);
            else if (rank == 2) System.out.println(rank + "nd: " + line);
            else if (rank == 3) System.out.println(rank + "rd: " + line);
            else System.out.println(rank + "th: " + line);

            rank++; // increments rank
        }
        
        display.close();
        // Option for the player to return to the main menu or exit the program
        // The option to quit is also given here in case the player wants to end after they die rather than going back to the menu
        System.out.print("---------------------------------\n" 
                        + "Type 1 to return to main menu\n"
                        + "type 2 to exit the program\n"
                        + "Type: ");
        int choice = Game.getInt(console, 1, 2);
        if (choice == 1) Game.mainMenu(console);
        else if (choice == 2) System.exit(0);
        else System.out.println("Invalid");
    }
}
