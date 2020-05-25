import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {


    }

    /*  Создайте список List<String> не короче 50 элементов разной длинны (наполнение не важно).
Добавьте вручную несколько пустых элементов ""
С помощью stream() выведите на консоль:
- длинну каждого из элементов списка.
- не пустые элементы списка не содержащие символ d
- элементы списка в алфавитном порядке. */

    static void printByStream() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            //Lorem Ipsum is simply dummy
            list.add("text" + i);
            list.add("of the printing and typesetting industry" + i);
            list.add("Lorem Ipsum has been the industry" + i);
            list.add("It has survived not only five centuries" + i);
            list.add("but also the leap into electronic typesetting" + i);
        }

        list.add("");
        list.add("");

        list.stream();
        list.forEach(System.out::println);
    }
}
