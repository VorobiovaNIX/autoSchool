package figures;

public abstract class Shape implements Comparable {

    private String name;

    abstract double calculateArea();

    /* used constructor for abstract class with "name" field
    linstead of using getter and setter for this field */
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
}
