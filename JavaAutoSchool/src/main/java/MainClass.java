import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class MainClass {

    public static void main(String[] args) throws IOException, InterruptedException {
        findMinValue(); // 1 task
        findMaxValue(); // 2 task
        sortNumbers(); //3 task
        compareNames(); //4 task
        checkAgeLessEighteen(); //5 task
        checkAgeLessTwenty(); //6 task
        guessNumber(); // 7 task
        countToTen(); //8 task
        countToZero(); //9 task
        showStringNTimes(); //10 task
        showSquare(); //11 task
        multiplicationTable(); //12 task
        countToOneHundred(); //13 task
        showRectangle(); //14 task
        showRightTriangle(); //15 task
        displayEights(); //16 task
        declarationOfLove(); //17 task
        countToBoom(); //18 task
    }

    /*1 Ввести с клавиатуры два числа, и вывести на экран минимальное из них. */
    private static void findMinValue() throws IOException {
        System.out.println("Please enter 2 numbers: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstNumber = Integer.parseInt(reader.readLine());
        int secondNumber = Integer.parseInt(reader.readLine());

        if (firstNumber < secondNumber) System.out.println("The min value is: " + firstNumber);
        else System.out.println("The min value is: " + secondNumber);
    }

    /* 2 Ввести с клавиатуры четыре числа, и вывести максимальное из них.*/
    private static void findMaxValue() throws IOException {
        int[] numbers = new int[4];
        System.out.println("Please enter 4 numbers: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        int maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) maxValue = numbers[i];
        }
        System.out.println("Max value is: " + maxValue);
    }

    /* 3 Ввести с клавиатуры три числа, и вывести их в порядке убывания. */
    private static int[] bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int swap = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = swap;
                }
            }
        }
        return numbers;
    }

    private static void sortNumbers() throws IOException {
        int[] numbers = new int[3];
        System.out.println("Please enter 3 numbers: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        int[] sortedNumbers = bubbleSort(numbers);
        System.out.println("The sorted numbers: " + Arrays.toString(sortedNumbers));
    }

    /* 4 Ввести с клавиатуры два имени, и если имена одинаковые, вывести сообщение «Имена идентичны».
    Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».  */
    private static void compareNames() throws IOException {

        System.out.println("Please enter two names: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();

        if (firstName.equals(secondName)) System.out.println("Имена идентичны");
        else if (firstName.length() == secondName.length()) System.out.println("Длины имен равны");
    }

    /* 5 Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще» */
    private static void checkAgeLessEighteen() throws IOException {
        System.out.println("Please enter your name and age: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        if (age < 18) System.out.println(name + ", подрасти еще");
    }

    /* 6 Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись «И 18-ти достаточно»  */
    private static void checkAgeLessTwenty() throws IOException {
        System.out.println("Please enter your name and age: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        if (age > 20) System.out.println(name + ", и 18-ти достаточно");
    }

    /* 7 За семь попыток угадать число. При каждой попытке вам будет выводиться сообщение - "Мало" или "Много".
    Если угадаете, уложившись в семь попыток, то выводится сообщение "Угадал :)" и программа завершает работу.
    Если по истечении 7 попыток число не угадывается, то выводится сообщение "Не угадал :(" и завершается работа. */
    private static void guessNumber() throws IOException {
        Random random = new Random();
        final int numberToGuess = random.nextInt(100);

        boolean solved = false;
        int attemptNum = 1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Угадай число: ");

        while (attemptNum <= 7) {
            int enteredNumber = Integer.parseInt(reader.readLine());
            if (enteredNumber == numberToGuess) {
                solved = true;
                break;
            }
            attemptNum++;

            if (enteredNumber < numberToGuess) System.out.println("Мало");
            else System.out.println("Много");
        }

        if (solved) System.out.println(" Угадал :) количетсво попыток " + attemptNum);
        else System.out.println("Не угадал :( количетсво попыток " + attemptNum);
    }

    /* 8 Вывести на экран числа от 1 до 10, используя цикл while. */
    private static void countToTen() {
        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            ++i;
        }
    }

    /* 9 Вывести на экран числа от 10 до 1, используя цикл while.  */
    private static void countToZero() {
        int i = 10;
        while (i > 0) {
            System.out.print(i + " ");
            i--;
        }
    }

    /* 10 Ввести с клавиатуры строку и число N. Вывести на экран строку N раз, используя цикл while.  */
    private static void showStringNTimes() throws IOException {
        System.out.println("Please enter any string and number: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String enteredString = reader.readLine();

        int enteredNumber = Integer.parseInt(reader.readLine());
        int i = 1;

        while (i <= enteredNumber) {
            System.out.println(enteredString);
            i++;
        }
    }

    /* 11 Вывести на экран квадрат из 10х10 букв S используя цикл while. Буквы в каждой строке не разделять. */
    private static void showSquare() {
        int i = 0;
        while (i < 100) {
            System.out.print("S");
            i++;
            if (i % 10 == 0) System.out.println();
        }
    }

    /*  12 Вывести на экран таблицу умножения 10х10 используя цикл while.Числа разделить пробелом.  */
    private static void multiplicationTable() {
        int i = 1;
        while (i <= 10) {
            int j = 1;
            while (j <= 10) {
                System.out.print(i * j + " ");
                j++;
            }
            i++;
            System.out.println();
        }
    }

    /* 13 Используя цикл for вывести на экран чётные числа от 1 до 100 включительно.Через пробел либо с новой строки.*/
    private static void countToOneHundred() {
        for (int i = 2; i <= 100; i += 2) {
            System.out.print(i + " ");
        }
    }

    /* 14 Ввести с клавиатуры два числа m и n.
    Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.  */
    private static void showRectangle() throws IOException {

        System.out.println("Please enter two numbers: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print("8 ");
            }
            System.out.println();
        }
    }

    /* 15 Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10. */
    private static void showRightTriangle() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /* 16 Используя цикл for вывести на экран:
    - горизонтальную линию из 10 восьмёрок
    - вертикальную линию из 10 восьмёрок. */
    private static void displayEights() {
        for (int i = 1; i <= 10; i++) {
            System.out.print("8" + " ");
        }
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.println("8");
        }
    }

    /* 17 Ввести с клавиатуры имя и, используя цикл for 10 раз, вывести: [*имя* любит меня.]  */
    private static void declarationOfLove() throws IOException {
        System.out.println("Please enter the name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s любит меня.", name);
            System.out.println();
        }
    }

    /* 18 Написать программу, которая ведёт обратный отсчёт с 30 до 0, и в конце выводит на экран текст «Бум!».
    Программа должна уменьшать число 10 раз в секунду.  */
    private static void countToBoom() throws InterruptedException {
        for (int i = 30; i >= 0; i--) {
            System.out.println(i);
            Thread.sleep(100);
        }
        System.out.println("Бум!");
    }
}
