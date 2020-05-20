package figures;

public class Square extends Shape {
    private String name;
    private double edge;

    Square(String name, int edge) {
        this.name = name;
        this.edge = edge;
    }

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    double calculateArea() {
        return Math.sqrt(edge);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
