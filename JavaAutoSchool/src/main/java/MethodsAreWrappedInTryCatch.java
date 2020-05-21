import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MethodsAreWrappedInTryCatch {

    public static void reverseNumbersArray() throws IOException {
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

        /* wrapped in try catch block     */
        for (double number : reversedList) {
            try {
                Thread.sleep(3000); // waiting for 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(number);
        }
    }

    public static void returnLengthOfEachStringInArray() throws IOException {
        String[] stringArray = new String[10];
        int[] lengths = new int[10];

        System.out.println("Please enter 10 string: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /* wrapped in try catch block     */
        try {
            int zero = 5 / 0;
        } catch (ArithmeticException e) {
            System.err.println(e);
            System.out.println("You shall not fall!");
        }

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


}
