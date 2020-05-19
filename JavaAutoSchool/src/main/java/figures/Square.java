package figures;

public class Square extends Shape {
    private String name;
    private Point coordinates;
    private double edge;

    Square(String name, int x, int y, double edge) {
        this.name = name;
        this.coordinates = new Point(x, y);
        this.edge = edge;
    }

    Square(int x, int y, int edge) {
        this.coordinates = new Point(x, y);
        this.edge = edge;
    }

    @Override
    double calculateArea() {
        return Math.sqrt(edge);
    }

    @Override
    Point getCoordinates() {
        return coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
