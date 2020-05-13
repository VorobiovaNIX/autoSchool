public class MainClass {

    public static void main(String[] args) {
        division(21, 8);
        sumNumber(47);
        roundingNumber(34.82345);
        editValues(0, 2, 5);
    }

    private static void division(int q, int w) {
        System.out.printf("Result: %d with the remainder %d \n", q / w, q % w);
    }

    private static void sumNumber(int num) {
        if (num > 9 && num < 100) {
            String str = Integer.toString(num);
            System.out.println("You are entered number " + str);
            Integer firstNumber = Integer.valueOf(str.substring(0, 1));
            Integer secondNumber = Integer.valueOf(str.substring(1));
            int result = firstNumber + secondNumber;
            System.out.println("Sum of digits of number " + num + " is " + result);
        } else System.out.println("The number should be num natural double-digit");
    }

    private static void roundingNumber(double n) {
        int roundedNumber = n % 1 < 0.5 ? (int) n : (int) n + 1;

        System.out.println("You entered number " + n);
        System.out.println("The rounded number is " + roundedNumber + "\n");
    }

    private static void editValues(double a, double b, double c) {
        double swapA = a;
        double swapB = b;

        a = a + b;
        b = c - swapA;
        c = swapA + swapB + c;

        System.out.println("The number a: " + a);
        System.out.println("The number b: " + b);
        System.out.println("The number c: " + c);
    }
}
