package geometry;

import java.util.List;

public abstract class Shape {
    protected List<Double> dimensions;

    public Shape(List<Double> dimensions) {
        this.dimensions = dimensions;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public abstract String getShapeType();
}
