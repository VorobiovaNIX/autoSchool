package figures;

public class Square extends Shape {

    private double edge;

    public Square(String name, int edge) {
        super(name);
        this.edge = edge;
    }

    public Square(String name, double edge) {
        super(name);
        this.edge = edge;
    }

    @Override
    double calculateArea() {
        return Math.sqrt(edge);
    }

}
