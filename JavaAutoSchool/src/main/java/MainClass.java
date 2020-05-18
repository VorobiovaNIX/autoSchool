import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) throws IOException {

        int[] array = initializeArray(); // 1 task
        max(array);

        reverseStringArray(); // 2 task

        returnLengthOfEachStringInArray(); //3 task

        reverseNumbersArray(); //4 task

        copyLargeArrayInTwoLittleArrays(); //5 task

    }

    /*-1-
Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
     */
    private static int[] initializeArray() throws IOException {
        System.out.println("Please enter 20 numbers that will be converted into an array: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[20];

        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(reader.readLine());
        }

        System.out.println("You entered " + Arrays.toString(list));
        return list;
    }

    private static void max(int[] numbers) {
        int maxNum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNum) maxNum = numbers[i];
        }
        System.out.println("Max value is: " + maxNum);
    }
    /* -2-
Массив из строчек в обратном порядке
1. Создать массив на 10 строчек.
2. Ввести с клавиатуры 8 строчек и сохранить их в массив.
3. Вывести содержимое всего массива (10 элементов) на экран в обратном порядке. Каждый элемент - с новой строки.
     */

    private static void reverseStringArray() throws IOException {
        String[] list = new String[10];
        System.out.println("Please enter 8 lines: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < list.length; i++) {
            list[i] = reader.readLine();
        }
        System.out.println("You entered the following string values: " + Arrays.toString(list));

        String[] reversedList = new String[list.length];
        for (int i = 0, j = reversedList.length - 1; i < list.length; i++, j--) {
            reversedList[j] = list[i];
        }

        System.out.println("The reversed list is: ");
        for (String string : reversedList) {
            System.out.println(string);
        }
    }

    /*
    -3-
2 массива
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.
5. Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
    */
    private static void returnLengthOfEachStringInArray() throws IOException {
        String[] stringArray = new String[10];
        int[] lengths = new int[10];

        System.out.println("Please enter 10 string: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = reader.readLine();
        }
        System.out.println("You entered the following string values: " + Arrays.toString(stringArray));

        for (int i = 0; i < stringArray.length; i++) {
            lengths[i] = stringArray[i].length();
        }
        System.out.println("The length of each string in Array is: ");

        for (int lengthOfCell : lengths) {
            System.out.println(lengthOfCell);
        }
    }

    /*
    -4-
    Массив из чисел в обратном порядке
    1. Создать массив на 10 чисел.
    2. Ввести с клавиатуры 10 чисел и записать их в массив.
    3. Расположить элементы массива в обратном порядке.
    4. Вывести результат на экран, каждое значение выводить с новой строки.
     */
    private static void reverseNumbersArray() throws IOException {

        double[] numbers = new double[10];
        System.out.println("Please enter 10 numbers: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Double.parseDouble(reader.readLine());
        }
        System.out.println("You entered the following numbers: " + Arrays.toString(numbers));

        double[] reversedList = new double[numbers.length];
        for (int i = 0, j = reversedList.length - 1; i < numbers.length; i++, j--) {
            reversedList[j] = numbers[i];
        }
        System.out.println("The reversed list of numbers is: ");

        for (double number : reversedList) {
            System.out.println(number);
        }
    }

    /*
-5-
Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
     */

    private static void copyLargeArrayInTwoLittleArrays() throws IOException {
        int[] largeArray = new int[20];
        System.out.println("Please enter 20 numbers: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = Integer.parseInt(reader.readLine());
        }

        System.out.println("You entered the following numbers: " + Arrays.toString(largeArray));

        int[] firstSmallArray = new int[10];
        int[] secondSmallArray = new int[10];

        for (int i = 0; i < largeArray.length / 2; i++) {
            firstSmallArray[i] = largeArray[i];
        }

        for (int i = largeArray.length / 2, j = 0; i < largeArray.length; i++, j++) {
            secondSmallArray[j] = largeArray[i];
        }

        System.out.println("The second small array (second part of entered array) is: ");
        for (int number : secondSmallArray) {
            System.out.println(number);
        }
    }
}

