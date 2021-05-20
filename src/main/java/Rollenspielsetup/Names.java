package Rollenspielsetup;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Names {


    // name generator that reads imported csv file and prints out a random name from it

    public static String getRandomName() {

        String fileName = "rollenspiel_namen.csv";
        File file = new File(fileName);
        List<String> result = new ArrayList<>();

        try {
            Scanner inputStream = new Scanner(file);

            // hashNext() loops line-by-line
            while (inputStream.hasNext()) {
                //read single line, put in string
                String[] data = inputStream.next().split(" ");
                // parse array into Arraylist
                Collections.addAll(result, data);

            }
            inputStream.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        // pick random name
        Random randomNumber = new Random();
        int selector = randomNumber.nextInt(result.size());

        return result.get(selector);

    }
}
