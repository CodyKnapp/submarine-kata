package solutions.wick.submarine;

public enum Direction {
    UP, DOWN, FORWARD;

    public static Direction fromString(String input) {
        return switch (input) {
            case "up" -> UP;
            case "down" -> DOWN;
            case "forward" -> FORWARD;
            default -> null;
        };
    }
}
