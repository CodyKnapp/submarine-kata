package solutions.wick.submarine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubmarineTest {
    @Test
    public void InternalStateIsChangedByAValidInstruction() {
        var sub = new Submarine();
        sub.navigate(Direction.FORWARD, 5);

        assertEquals(5, sub.getDistance());
        assertEquals(0, sub.getDepth());
    }

    @Test
    public void InternalStateIsMaintainedForMultipleInstructions() {
        var sub = new Submarine();
        sub.navigate(Direction.FORWARD, 5);
        sub.navigate(Direction.DOWN, 5);
        sub.navigate(Direction.FORWARD, 8);

        assertEquals(13, sub.getDistance());
        assertEquals(40, sub.getDepth());
    }

    @Test
    public void StateChangesCorrectlyForConflictingInstructions() {
        var sub = new Submarine();
        sub.navigate(Direction.FORWARD, 5);
        sub.navigate(Direction.DOWN, 5);
        sub.navigate(Direction.FORWARD, 8);
        sub.navigate(Direction.UP, 3);
        sub.navigate(Direction.DOWN, 8);
        sub.navigate(Direction.FORWARD, 2);

        assertEquals(15, sub.getDistance());
        assertEquals(60, sub.getDepth());
    }

    @Test
    public void StateChangesCorrectlyForZeroedAim() {
        var sub = new Submarine();
        sub.navigate(Direction.FORWARD, 5);
        sub.navigate(Direction.DOWN, 2);
        sub.navigate(Direction.FORWARD, 1);
        sub.navigate(Direction.UP, 2);
        sub.navigate(Direction.FORWARD, 3);

        assertEquals(9, sub.getDistance());
        assertEquals(2, sub.getDepth());
    }

    @Test
    public void NavigateParsesWellFormedStrings() {
        var sub = new Submarine();
        sub.navigate("forward 15");
        sub.navigate("down 10");
        sub.navigate("up 3");

        assertEquals(15, sub.getDistance());
        assertEquals(0, sub.getDepth());
    }

    @Test
    public void NavigateWorksForSampleText() {
        var sub = new Submarine();
        sub.navigate("forward 5");
        sub.navigate("down 5");
        sub.navigate("forward 8");
        sub.navigate("up 3");
        sub.navigate("down 8");
        sub.navigate("forward 2");

        assertEquals(15, sub.getDistance());
        assertEquals(60, sub.getDepth());
    }

    @Test
    public void NavigateThrowsForNotEnoughInstructions() {
        assertThrows(IllegalArgumentException.class, () -> new Submarine().navigate("forward"));
    }

    @Test
    public void NavigateThrowsForTooManyInstructions() {
        assertThrows(IllegalArgumentException.class, () -> new Submarine().navigate("forward 5 leagues"));
    }

    @Test
    public void NavigateThrowsWhenSecondTokenCannotBeParsedToInt() {
        assertThrows(NumberFormatException.class, () -> new Submarine().navigate("forward twelve"));
    }

    @Test
    public void NavigateThrowsForBadDirection() {
        assertThrows(IllegalArgumentException.class, () -> new Submarine().navigate("left 3"));
    }
}