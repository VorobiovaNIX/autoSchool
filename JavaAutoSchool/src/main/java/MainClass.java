import figures.Circle;
import figures.Shape;
import figures.Square;
import figures.Triangle;

import java.util.Arrays;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {

        /* Creating an array of objects Shape */
        Shape[] shapes = generateArrayOfShapes();

        System.out.println(Arrays.toString(shapes)); //print created array of Shapes

        /* Sorting Array  */
        Arrays.sort(shapes);

        /* printing a sorted array of shapes by area  */
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public static Shape[] generateArrayOfShapes() {
        Shape[] shapes = new Shape[10];
        Random random = new Random();

        for (int i = 0; i < shapes.length; i++) {
            int shapeIndex = random.nextInt(3); // index equals to any integer number form 0 to 2

            /* creating random object - Shapes via constructor */
            switch (shapeIndex) {
                case 0:
                    double radius = random.nextDouble() * 10;
                    String circleName = String.format("Circle %d", i);

                    shapes[i] = new Circle(circleName, radius);
                    break;
                case 1:
                    int edge = random.nextInt(5);
                    String squareName = String.format("Square %d", i);

                    shapes[i] = new Square(squareName, edge);
                    break;
                case 2:
                    int edgeA = random.nextInt(5);
                    int edgeB = random.nextInt(5);
                    int angleBetweenSides = random.nextInt(100);
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
