import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {

    @Test
    void setCrashed() {
        // Arrange
        Block block = new Block(1, 1, Color.BLACK, 10, 10);

        // Act
        block.setCrashed();

        // Assert
        assertEquals(true, block.getCrashed());
    }

    @Test
    void getCrashed() {
        // Arrange
        Block block = new Block(1, 1, Color.BLACK, 10, 10);

        // Assert
        assertEquals(false, block.getCrashed());
    }
}