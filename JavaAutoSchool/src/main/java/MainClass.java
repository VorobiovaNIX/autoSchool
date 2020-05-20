import figures.Circle;
import figures.Shape;
import figures.Square;
import figures.Triangle;

import java.util.Arrays;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {

        Shape[] shapes = generateArrayOfShapes();
        System.out.println(Arrays.toString(shapes));
    }

    public static Shape[] generateArrayOfShapes() {
        Shape[] shapes = new Shape[10];
        Random random = new Random();

        for (int i = 0; i < shapes.length; i++) {
            int shapeIndex = random.nextInt(4);

            switch (shapeIndex) {
                case 1:
                    double radius = random.nextDouble() * 10;
                    shapes[i] = new Circle(radius);
                    break;
                case 2:
                    int edge = random.nextInt(5);
                    shapes[i] = new Square(edge);
                    break;
                case 3:
                    int edgeA = random.nextInt(5);
                    int edgeB = random.nextInt(5);
                    int angleBetweenSides = random.nextInt(89);

                    shapes[i] = new Triangle(edgeA, edgeB, angleBetweenSides);
                    break;
            }
        }
        return shapes;
    }

}
