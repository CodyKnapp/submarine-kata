package solutions.wick.submarine;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please specify the filename when running the program.");
            return;
        }

        var filename = args[0];
        var inputFile = new File(filename);
        try {
            var submarine = Processor.processFile(inputFile);

            System.out.println("The horizontal distance is " + submarine.getDistance());
            System.out.println("The depth is " + submarine.getDepth());
            System.out.println("The product of the distance and the depth is " + submarine.getDistance() * submarine.getDepth());
        } catch (Exception e) {
            System.out.println("An error occurred during processing.");
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}