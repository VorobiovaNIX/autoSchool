import java.lang.reflect.Field;
import java.util.Random;

public class Program {


    public static void fillInWithRandomData(Object object) {
        Random random = new Random();

        Field[] fields = object.getClass().getDeclaredFields();

        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);

                switch (i) {
                    case 0:
                        String model = String.valueOf(random.nextInt(700));
                        fields[i].set(object, model);
                        break;
                    case 1:
                        String[] colors = {"white", "black", "yellow", "red", "silver"};
                        fields[i].set(object, colors[random.nextInt(colors.length)]);
                        break;
                    case 2:
                        String[] bodyTypes = {"sedan", "crossover", "hatchback", "roofless"};
                        fields[i].set(object, bodyTypes[random.nextInt(bodyTypes.length)]);
                        break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
