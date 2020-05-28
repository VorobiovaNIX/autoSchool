import java.lang.reflect.Field;

public class Car {

    public static void printValueAndNameOfFieldsOfChildClass(Car car) {

        try {
            Field[] fields = car.getClass().getDeclaredFields();

            for (Field value : fields) {
                value.setAccessible(true);
                String nameOfField = value.getName();
                String field = (String) value.get(car);
                String nameOfClass = car.getClass().getName();

                System.out.println(String.format("The %s is: %s : %s", nameOfClass, nameOfField, field));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
