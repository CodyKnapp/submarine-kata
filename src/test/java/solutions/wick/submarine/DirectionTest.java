package solutions.wick.submarine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    public void FromStringCreatesADirectionFromAGoodString() {
        var test = Direction.fromString("up");

        assertEquals(Direction.UP, test);
    }

    @Test
    public void FromStringThrowsIllegalArgumentExceptionForABadString() {
        assertThrows(IllegalArgumentException.class, () -> Direction.fromString("no"));
    }
}