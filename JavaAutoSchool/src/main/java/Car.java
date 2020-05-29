import java.lang.reflect.Field;
import java.util.stream.Stream;

public class Car {

    public static void printValueAndNameOfFieldsOfChildClass(Car car) {

        Field[] fields = car.getClass().getDeclaredFields();
        String nameOfClass = car.getClass().getName();
        System.out.println(String.format("%s specs:", nameOfClass));

        Stream.of(fields).forEach(field -> {
            field.setAccessible(true);
            try {
                String name = field.getName();
                String value = (String) field.get(car);
                System.out.println(String.format("  -%s : %s", name, value));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
