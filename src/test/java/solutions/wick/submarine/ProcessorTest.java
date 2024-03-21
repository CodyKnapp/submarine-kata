package solutions.wick.submarine;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProcessorTest {
    @Test
    public void CreatesASubForAKnownGoodInputFile() {
        var file = new File("src/test/resources/test_instructions.txt");

        try {
            var result = Processor.processFile(file);
            assertEquals(1064, result.getDistance());
            assertEquals(290, result.getDepth());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void ThrowsForKnownBadInputFile() {
        var file = new File("src/test/resources/bad_test_instructions.txt");
        assertThrows(IllegalArgumentException.class, () -> Processor.processFile(file));
    }

    @Test
    public void ThrowsForFileNotFound() {
        var file = new File("src/test/resources/unknown_file_name.txt");
        assertThrows(FileNotFoundException.class, () -> Processor.processFile(file));
    }
}