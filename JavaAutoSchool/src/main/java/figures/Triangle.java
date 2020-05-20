package figures;

public class Triangle extends Shape {

    private double oneSideOfTriangle; //one side of the triangle
    private double secondSideOfTriangle; //second side of the triangle
    private double angleBetweenSides; //the angle between the sides of the triangle

    public Triangle(String name, double oneSideOfTriangle, double secondSideOfTriangle, double angleBetweenSides) {
        super(name);
        this.oneSideOfTriangle = oneSideOfTriangle;
        this.secondSideOfTriangle = secondSideOfTriangle;
        this.angleBetweenSides = angleBetweenSides;
    }

    @Override
    double calculateArea() {
        return (oneSideOfTriangle * secondSideOfTriangle * Math.sin(angleBetweenSides)) / 2;
    }

    public void setAngleBetweenSides(double angleBetweenSides) {
        if (angleBetweenSides <180&& angleBetweenSides>0) this.angleBetweenSides = angleBetweenSides;
        else System.out.println("The angle between sides of the triangle cannot be more than 180 and less than 1");
    }


}
