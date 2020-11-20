import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void changeDirectionX() {
        // Arrange
        Ball ball = new Ball(1, 1, 1, 2, 10, 10, Color.BLACK);

        // Act
        ball.changeDirectionX();

        // Assert
        assertEquals(-1, ball.getDirectionX());
    }

    @Test
    void changeDirectionY() {
        // Arrange
        Ball ball = new Ball(1, 1, 1, 2, 10, 10, Color.BLACK);

        // Act
        ball.changeDirectionY();

        // Assert
        assertEquals(-2, ball.getDirectionY());
    }

    @Test
    void move() {
        // Arrange
        Ball ball = new Ball(1, 2, 2, 2, 10, 10, Color.BLACK);

        // Act
        ball.move();

        // Assert
        assertEquals(3, ball.getX());
        assertEquals(4, ball.getY());
    }
}