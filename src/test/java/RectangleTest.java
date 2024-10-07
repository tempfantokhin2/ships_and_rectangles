import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.Arrays;
import geometry.Rectangle;
import geometry.RectanglesCalculator;
import geometry.ExcelReadRectangles;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testReadRectanglesFromExcel() throws IOException {
        ExcelReadRectangles reader = new ExcelReadRectangles();
        List<Rectangle> rectangles = reader.readRectanglesFromExcel("rectangles1.xlsx");

        assertEquals(4, rectangles.size());

        Rectangle rectangle1 = rectangles.get(0);
        assertEquals(150, rectangle1.calculateArea(), 0.01);
        assertEquals(50, rectangle1.calculatePerimeter(), 0.01);

        Rectangle rectangle2 = rectangles.get(1);
        assertEquals(150, rectangle2.calculateArea(), 0.01);
        assertEquals(50, rectangle2.calculatePerimeter(), 0.01);
    }

    @Test
    void testCalculateArea() {
        Rectangle rectangle = new Rectangle(List.of(5.0, 10.0));
        assertEquals(50.0, rectangle.calculateArea(), 0.01);
    }

    @Test
    void testCalculatePerimeter() {
        Rectangle rectangle = new Rectangle(List.of(3.0, 7.0));
        assertEquals(20.0, rectangle.calculatePerimeter(), 0.01);
    }

    @Test
    void testGetShapeType() {
        Rectangle rectangle = new Rectangle(List.of(4.0, 6.0));
        assertEquals("Rectangle", rectangle.getShapeType());
    }

    @Test
    void testToString() {
        Rectangle rectangle = new Rectangle(List.of(2.0, 8.0));
        String expected = "Rectangle{dimensions=[2.0, 8.0]}";
        assertEquals(expected, rectangle.toString());
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testCalculateAverageArea() {
        List<Rectangle> rectangles = Arrays.asList(
                new Rectangle(List.of(5.0, 10.0)),
                new Rectangle(List.of(3.0, 7.0))
        );
        double result = RectanglesCalculator.calculateAverageArea(rectangles);
        assertEquals(35.5, result, 0.01);
    }

    @Test
    void testFindMaxPerimeter() {
        List<Rectangle> rectangles = Arrays.asList(
                new Rectangle(List.of(5.0, 10.0)),
                new Rectangle(List.of(3.0, 7.0))
        );
        double result = RectanglesCalculator.calculateMaxPerimeter(rectangles);
        assertEquals(30.0, result, 0.01);
    }

    @Test
    void testSortRectanglesByArea() {
        List<Rectangle> rectangles = Arrays.asList(
                new Rectangle(List.of(5.0, 10.0)),
                new Rectangle(List.of(3.0, 7.0))
        );
        List<Rectangle> sortedRectangles = RectanglesCalculator.sortRectanglesByArea(rectangles);

        assertEquals(21.0, sortedRectangles.get(0).calculateArea(), 0.01);
        assertEquals(50.0, sortedRectangles.get(1).calculateArea(), 0.01);
    }

}
