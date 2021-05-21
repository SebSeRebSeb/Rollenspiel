package Rollenspielsetup;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Names {

    public static String getRandomName() {
// Namegenerator that reads imported csv file and prints out a random Name from it
        String fileName = "rollenspiel_namen.csv";
        File file = new File(fileName);
        List<String> result = new ArrayList<>();

        try {

            Scanner inputStream = new Scanner(file);

            // hashNext() loops line-by-line
            while (inputStream.hasNext()) {
                //read single line, put in string
                String[] data = inputStream.next().split(" ");

                //parse Array into Arraylist
                Collections.addAll(result, data);

            }


            inputStream.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        //pick random Name
        Random randomNumber = new Random();
        int selector = randomNumber.nextInt(result.size());

        return result.get(selector);


    }
}
