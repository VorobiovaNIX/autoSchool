package figures;

public class Circle extends Shape {
    private String name;
    private Point coordinates;
    private double radius;

    Circle(String name, int x, int y, double radius) {
        this.name = name;
        this.coordinates = new Point(x, y);
        this.radius = radius;
    }

    Circle(int x, int y, int radius) {
        this.coordinates = new Point(x, y);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * Math.sqrt(radius);
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
