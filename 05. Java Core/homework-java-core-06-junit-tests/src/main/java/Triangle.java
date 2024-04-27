public class Triangle extends Figure {
    private double side1;
    private double side2;
    private double side3;

//    private double halfPerimeter = perimeter() / 2;

    public Triangle(double side1, double side2, double side3, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        double halfPerimeter = perimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1)*(halfPerimeter - side2)*(halfPerimeter - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    public double inscribedCircleRadius() {
        double halfPerimeter = perimeter() / 2;
        return Math.sqrt(((halfPerimeter - side1)*(halfPerimeter - side2)*(halfPerimeter - side3)) / halfPerimeter);
    }
}
