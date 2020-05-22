package figures;

import java.util.Random;

public abstract class Shape implements Comparable {

    private String name;

    abstract double calculateArea();

    /* used constructor for abstract class with "name" field
    instead of using getter and setter for this field */
    public Shape(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object obj) {
        Shape tmp = (Shape) obj;
        if (this.calculateArea() < tmp.calculateArea()) {
            return -1;
        } else if (this.calculateArea() > tmp.calculateArea()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, S = %f", name, calculateArea());
    }


    public static Shape[] generateArrayOfShapes() {
        Shape[] shapes = new Shape[10];
        Random random = new Random();

        for (int i = 0; i < shapes.length; i++) {
            int shapeIndex = random.nextInt(3) + 1; // index equals to any integer number form 0 to 2

            /* creating random object - Shapes via constructor */
            switch (shapeIndex) {
                case 1:
                    double radius = random.nextDouble() * 10 + 1;
                    String circleName = String.format("Circle %d", i);

                    shapes[i] = new Circle(circleName, radius);
                    break;
                case 2:
                    int edge = random.nextInt(5) + 1;
                    String squareName = String.format("Square %d", i);

                    shapes[i] = new Square(squareName, edge);
                    break;
                case 3:
                    int edgeA = random.nextInt(5) + 1;
                    int edgeB = random.nextInt(10) + 1;
                    int angleBetweenSides = random.nextInt(80) + 1;
                    String triangleName = String.format("Triangle %d", i);

                    shapes[i] = new Triangle(triangleName, edgeA, edgeB, angleBetweenSides);
                    break;
                default:
                    throw new Error("Unsupported shape index");
            }
        }
        return shapes;
    }
}
