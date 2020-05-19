package figures;

public class Triangle extends Shape {

    private String name;
    private Point coordinates;
    private double oneSideOfTriangle; // одна сторона
    private double secondSideOfTriangle; //вторая сторона
    private double angleBetweenSides; //угол между сторонами

    Triangle(int x, int y, double oneSideOfTriangle, double secondSideOfTriangle, double angleBetweenSides) {
        this.coordinates = new Point(x, y);
        this.oneSideOfTriangle = oneSideOfTriangle;
        this.secondSideOfTriangle = secondSideOfTriangle;
        this.angleBetweenSides = angleBetweenSides;
    }

    @Override
    double calculateArea() {
        return (oneSideOfTriangle*secondSideOfTriangle*Math.sin(angleBetweenSides))/2;
    }

    @Override
    Point getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
