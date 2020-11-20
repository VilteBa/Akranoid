import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PaddleTest {

    @Test
    void moveRight() {
        // Arrange
        Paddle paddle = Paddle.getInstance();
        int xPosition = paddle.getX();

        // Act
        paddle.moveRight();

        // Assert
        assertEquals(xPosition+20, paddle.getX());
    }

    @Test
    void moveLeftWhenThereIsSpace() {
        // Arrange
        Paddle paddle = Paddle.getInstance();
        int xPosition = paddle.getX();

        // Act
        paddle.moveLeft();

        // Assert
        assertEquals(xPosition-20, paddle.getX());
    }
}