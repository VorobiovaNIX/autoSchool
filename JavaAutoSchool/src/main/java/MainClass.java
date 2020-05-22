import figures.Shape;

import java.util.Arrays;

import static figures.Shape.generateArrayOfShapes;

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



}

