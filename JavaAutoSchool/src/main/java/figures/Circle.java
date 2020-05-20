package figures;

public class Circle extends Shape {
    private String name;
    private double radius;

    Circle(String name, int radius) {
        this.name = name;
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * Math.sqrt(radius);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
