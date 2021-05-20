package Rollenspielsetup;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Names {

    public static String getRandomName() {

        String fileName = "rollenspiel_namen.csv";
        File file = new File(fileName);
        List<String> result = new ArrayList<>();

        try {
            // -Datei mit Scanner auslesen
            Scanner inputStream = new Scanner(file);

            // hashNext() loops line-by-line
            while (inputStream.hasNext()) {
                //read single line, put in string
                String[] data = inputStream.next().split(" ");

                //Array in Arraylist parsen
                Collections.addAll(result, data);

            }

            // Scanner schließen
            inputStream.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        // Zufälligen Namen auswählen
        Random randomNumber = new Random();
        int selector = randomNumber.nextInt(result.size());

        return result.get(selector);


    }

        //Filewriter um Liste zu aktualisieren
}
