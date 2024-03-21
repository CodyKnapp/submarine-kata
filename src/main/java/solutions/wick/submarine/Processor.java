package solutions.wick.submarine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Processor {
    public static Submarine processFile(File inputFile) throws FileNotFoundException {
        var submarine = new Submarine();

        var reader = new Scanner(inputFile);

        while (reader.hasNextLine()) {
            var line = reader.nextLine();
            submarine.navigate(line);
        }

        return submarine;
    }
}
