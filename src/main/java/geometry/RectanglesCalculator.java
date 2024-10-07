package geometry;

import java.util.*;
import java.util.stream.Collectors;

public class RectanglesCalculator {

    public static double calculateAverageArea(List<Rectangle> rectangles) {
        if (rectangles.isEmpty()) {
            return 0;
        }
        double sum = rectangles.stream()
                .mapToDouble(Rectangle::calculateArea)
                .sum();
        return sum / rectangles.size();
    }

    public static double calculateMaxPerimeter(List<Rectangle> rectangles) {
        if (rectangles.isEmpty()) {
            return 0;
        }
        return rectangles.stream()
                .mapToDouble(Rectangle::calculatePerimeter)
                .max().orElse(0);
    }

    public static List<Rectangle> sortRectanglesByArea(List<Rectangle> rectangles) {
        if (rectangles.isEmpty()) {
            return new ArrayList<>();
        }
        return rectangles.stream()
                .sorted((r1, r2) -> Double.compare(r1.calculateArea(), r2.calculateArea()))
                .collect(Collectors.toList());
    }
}
