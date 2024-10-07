package geometry;

import java.util.List;

public class Rectangle extends Shape {
    public Rectangle(List<Double> dimensions) {
        super(dimensions);
    }

    @Override
    public double calculateArea() {
        return dimensions.get(0) * dimensions.get(1);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (dimensions.get(0) + dimensions.get(1));
    }

    @Override
    public String getShapeType() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "dimensions=" + dimensions +
                '}';
    }
}
