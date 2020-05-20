package figures;

public class Triangle extends Shape {

    private String name;
    private double oneSideOfTriangle; // одна сторона
    private double secondSideOfTriangle; //вторая сторона
    private double angleBetweenSides; //угол между сторонами

    public Triangle(double oneSideOfTriangle, double secondSideOfTriangle, double angleBetweenSides) {
        this.oneSideOfTriangle = oneSideOfTriangle;
        this.secondSideOfTriangle = secondSideOfTriangle;
        this.angleBetweenSides = angleBetweenSides;
    }

    @Override
    double calculateArea() {
        return (oneSideOfTriangle*secondSideOfTriangle*Math.sin(angleBetweenSides))/2;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
