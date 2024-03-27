package solutions.wick.submarine;

import java.util.Arrays;

public class Submarine {
    int depth;
    int distance;
    int aim;

    public void navigate(String instruction) {
        try {
            var tokens = instruction.split(" ");
            if (tokens.length != 2) {
                throw new IllegalArgumentException("Incorrect navigation parameters supplied in string " + instruction);
            }

            var direction = Direction.fromString(tokens[0]);

            var distance = Integer.parseInt(tokens[1]);
            navigate(direction, distance);
        } catch (Exception e) {
            System.out.println("An error has occurred while navigating for string " + instruction);
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw e;
        }
    }

    public void navigate(Direction direction, int distance) {
        switch(direction) {
            case UP -> aim -= distance;
            case DOWN -> aim += distance;
            case FORWARD -> {
                this.distance += distance;
                depth += distance * aim;
            }
        }
    }

    public int getDepth() {
        return depth;
    }

    public int getDistance() {
        return distance;
    }
}
