import com.welcome.Hello;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String name = aksForAName();

        Hello hello = new Hello();
        hello.setupName(name);
        hello.welcome();

        greet();

        hello.byeBay();
    }

    public static String aksForAName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        return in.next();
    }

    public static void greet() {
        System.out.println("Hello, world!");
    }
}
