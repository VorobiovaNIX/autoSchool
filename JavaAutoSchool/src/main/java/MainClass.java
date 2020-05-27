import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

    /* Создайте список List<String> не короче 50 элементов разной длинны (наполнение не важно).
    Добавьте вручную несколько пустых элементов ""
    С помощью stream() выведите на консоль:
    - длинну каждого из элементов списка.
    - не пустые элементы списка не содержащие символ d
    - элементы списка в алфавитном порядке. */

public class MainClass {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        IntStream.range(1, 11).forEach((i) -> {
            list.add("text" + i);
            list.add("of the printing and typesetting industry" + i);
            list.add("Lorem Ipsum has been the industry" + i);
            list.add("It has survived not only five centuries" + i);
            list.add("but also the leap into electronic typesetting" + i);
        });

        list.add("");
        list.add("");
        list.forEach(System.out::println);

        list.stream().map(String::length).forEach(System.out::println);

        list.stream().filter(x -> x.length() > 0).filter(x -> !x.contains("d")).forEach(System.out::println);

        list.stream().sorted().forEach(System.out::println);
    }
}
