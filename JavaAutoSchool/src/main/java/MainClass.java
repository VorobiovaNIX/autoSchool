import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        printHelloName();
    }

    private static void printHelloName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String s = in.next();
        System.out.print("Hello, " + s + "!");
    }
}
