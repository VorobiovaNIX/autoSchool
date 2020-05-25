import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTasks {

    /* 7. 5 различных строчек в списке
    1. Создай список строк.
    2. Добавь в него 5 различных строчек.
    3. Выведи его размер на экран.
    4. Используя цикл, выведи его содержимое на экран, каждое значение с новой строки   */
    static void getSizeArrayList() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("первая строка", "вторая строка",
                "третья строка", "четвертая строка", "пятая строка"));

        System.out.println("The size of array list is: " + arrayList.size());

        for (String list : arrayList) System.out.println(list);
    }

    /* 8. Самая длинная строка
    1. Создай список строк.
    2. Считай с клавиатуры 5 строк и добавь в список.
    3. Используя цикл, найди самую длинную строку в списке.
    4. Выведи найденную строку на экран.
    5. Если таких строк несколько, выведи каждую с новой строки. */
    static void findTheLongestListInArray() throws IOException {

        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter 5 lists different length: ");
        for (int i = 0; i < 5; i++) arrayList.add(reader.readLine());

        int lengthOfLongestList = arrayList.get(0).length();
        for (String s : arrayList) {
            if (s.length() > lengthOfLongestList) lengthOfLongestList = s.length();
        }

        System.out.println("The longest list: ");
        for (String s : arrayList) if (s.length() == lengthOfLongestList) System.out.println(s);
    }

    /* 9. Самая короткая строка
    1. Создай список строк.
    2. Считай с клавиатуры 5 строк и добавь в список.
    3. Используя цикл, найди самую короткую строку в списке.
    4. Выведи найденную строку на экран.
    5. Если таких строк несколько, выведи каждую с новой строки  */
    static void findTheShortestListInArray() throws IOException {

        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter 5 lists different length: ");
        for (int i = 0; i < 5; i++) arrayList.add(reader.readLine());

        int lengthOfShortestList = arrayList.get(0).length();
        for (String list : arrayList) {
            if (list.length() < lengthOfShortestList) lengthOfShortestList = list.length();
        }

        System.out.println("The shortest list: ");
        for (String list : arrayList) if (list.length() == lengthOfShortestList) System.out.println(list);
    }

    /* 10. 10 строчек в начало списка
    1. Создай список строк в методе main.
    2. Добавь в него 10 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
    3. Используя цикл, выведи содержимое на экран, каждое значение с новой строки. */
    static void addListToTheTopOfArray() throws IOException {

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("Lorem Ipsum", "is simply dummy text", "of the printing"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter 10 rows: ");
        for (int i = 0; i < 10; i++) {
            arrayList.add(arrayList.size(), reader.readLine());
        }

        System.out.println("The array list is: ");
        for (String list : arrayList) {
            System.out.println(list);
        }
    }

    /* 11. Удали последнюю строку и вставь её в начало
    1. Создай список строк.
    2. Добавь в него 5 строчек с клавиатуры.
    3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
    4. Используя цикл, выведи содержимое на экран, каждое значение с новой строки   */
    static void removeLastRowAndInsertAtFirst() throws IOException {

        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 5 lists: ");
        for (int i = 0; i < 5; i++) {
            arrayList.add(reader.readLine());
        }

        for (int i = 0; i < 13; i++) {
            int indexOfLastRow = arrayList.size() - 1;
            String lastRow = arrayList.get(indexOfLastRow);
            arrayList.remove(indexOfLastRow);
            arrayList.add(0, lastRow);
        }
        for (String list : arrayList) System.out.println(list);
    }
}
