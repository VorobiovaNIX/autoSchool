public class MainClass {

    public static void main(String[] args) {
        division(21, 8);
        sumNumber(47);
        System.out.println();
        roundingNumber(34.82345);
        editValues(0, 2, 5);
    }

    /* 1 В переменных q и w хранятся два натуральных числа.
    Создайте программу, выводящую на экран результат деления q на w с остатком. */
    private static void division(int q, int w) {
        System.out.printf("Result: %d with the remainder %d \n", q / w, q % w);
    }

    /* В переменной n хранится натуральное двузначное число.
    Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n */
    private static void sumNumber(int num) {
        if (num > 9 && num < 100) {
            int firstNumber = (num / 10);
            int secondNumber = num % 10;
            int result = firstNumber + secondNumber;

            System.out.printf("Sum of digits of number %d is %d", num, result);
        } else System.out.println("The number should be num natural double-digit");
    }

    /* 3 В переменной n хранится вещественное число с ненулевой дробной частью.
    Создайте программу, округляющую число n до ближайшего целого и выводящую результат на экран. */
    private static void roundingNumber(double n) {
        int roundedNumber = n % 1 < 0.5 ? (int) n : (int) n + 1;

        System.out.println("You entered number " + n);
        System.out.println("The rounded number is " + roundedNumber + "\n");
    }

    /*4 Даны три переменные a, b и c. Изменить значения этих переменных так, чтобы в a хранилось значение a+b,
    в b хранилась разность старых значений c−a, а в c хранилось сумма старых значений a+b+c */
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
