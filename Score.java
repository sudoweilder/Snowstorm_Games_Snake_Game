import java.io.*;

public class Score {

    public static void Scoreboard(String id, int point) {
        try {
            FileWriter writer = new FileWriter("Scoreboard.txt");
            writer.write(id + " " + point);
            writer.close();


        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
