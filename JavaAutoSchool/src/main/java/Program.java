import java.lang.reflect.Field;
import java.util.Random;

public class Program {


    public static void fillInWithRandomData(Object object) {
        Random random = new Random();

        Field[] fields = object.getClass().getDeclaredFields();
        // FIXME: rewrite using stream API

        try {
            //Object object = new Object();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);

                switch (i) {
                    case 0:
                        String model = String.valueOf(random.nextInt(700));
                        fields[i].set(object, model);
                        break;
                    case 1:
                        String[] arr = {"white", "black", "yellow", "red", "silver"};
                        int randomNumber = random.nextInt(arr.length);
                        fields[i].set(object, arr[randomNumber]);
                        break;
                    case 2:
                        fields[i].set(object, "sedan");
                        break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
