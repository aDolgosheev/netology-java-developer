import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    Triangle sut = new Triangle(3, 4, 5, "red");

    @Test
    public void testArea() {
        double expected = 6;
        double result = sut.area();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPerimeter() {
        double expected = 12;
        double result = sut.perimeter();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testInscribedCircleRadius() {
        double expected = 1;
        double result = sut.inscribedCircleRadius();
        Assertions.assertEquals(expected, result);
    }
}