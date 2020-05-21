import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MethodsWhereThrowsExceptions {
    /*-3-
2 массива
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.
5. Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
    */
    public static void returnLengthOfEachStringInArray() throws IOException {
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

    /*  -4-
    Массив из чисел в обратном порядке
    1. Создать массив на 10 чисел.
    2. Ввести с клавиатуры 10 чисел и записать их в массив.
    3. Расположить элементы массива в обратном порядке.
    4. Вывести результат на экран, каждое значение выводить с новой строки. */


    /*throws exception in signature of method   */
    public static void reverseNumbersArray() throws IOException, InterruptedException {

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
            Thread.sleep(3000); // waiting for 3 seconds
            System.out.println(number);
        }
    }

}
