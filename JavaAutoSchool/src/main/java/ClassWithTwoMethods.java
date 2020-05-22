import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClassWithTwoMethods {
    /*
    FATAL	100
    ERROR	200
    WARN	300
    INFO	400
    DEBUG	500
    TRACE	600 */
    private static final Logger logger = LogManager.getLogger(ClassWithTwoMethods.class);
    static final Level DEBUG = Level.forName("DEBUG", 500);

    private static int[] bubbleSort(int[] numbers) {
        logger.debug("Debug message : ");
        logger.log(DEBUG, "a verbose message"); // use the custom VERBOSE level
        logger.error("the built-in ERROR level");
        logger.fatal("the built-in FATAL level");

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

    public static void sortNumbers() throws IOException {
        logger.debug("Hello this is an debug message");
        logger.info("Hello this is an info message");
        logger.error("Hello this is an error message");

        int[] numbers = new int[3];
        System.out.println("Please enter 3 numbers: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        int[] sortedNumbers = bubbleSort(numbers);
        System.out.println("The sorted numbers: " + Arrays.toString(sortedNumbers));
    }

}
