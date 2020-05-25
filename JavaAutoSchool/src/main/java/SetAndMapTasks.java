import java.time.LocalDate;
import java.util.*;

public class SetAndMapTasks {

    /*  12. Создать множество строк (Set<String>), занести в него 20 слов на букву «Л» */
    static void createSetOn20Words() {
        Set<String> stringSet = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            stringSet.add("Лампа " + i);
        }

        for (String word : stringSet) System.out.println(word);
    }

    /* 13. Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
    Удалить из множества все числа больше 10. */
    static void createSetOn20Numbers() {

        Set<Integer> integerSet = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            integerSet.add(i * 2);
        }
        System.out.println("The set is: ");
        for (int number : integerSet) System.out.printf(" %d ", number);

        integerSet.removeIf(number -> number > 10);

        System.out.println();
        for (int number : integerSet) System.out.printf(" %d ", number);
    }

    /*14. Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
 Проверить сколько людей с одинаковым именем. */
    static Map<String, Integer> createMapForNameAndSurname(Map<String, String> mapForNameAndSurname) {

        for (Map.Entry<String, String> pair : mapForNameAndSurname.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " : " + value);
        }

        Map<String, Integer> namesCount = new LinkedHashMap<>();
        for (String name : mapForNameAndSurname.values()) {
            if (namesCount.containsKey(name)) namesCount.put(name, namesCount.get(name) + 1);
            else namesCount.put(name, 1);
        }
        return namesCount;
    }

    /* 15. Создать словарь (Map<String, LocalDate>) и занести в него десять записей по принципу:
«фамилия» - «дата рождения». Удалить из словаря всех людей, родившихся летом. */
    static void createMapForSurnameAndDOB() {
        Map<String, LocalDate> mapForSurnameAndDOB = new HashMap<>();
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            int minDay = (int) LocalDate.of(1993, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(1993, 12, 31).toEpochDay();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

            mapForSurnameAndDOB.put("Иванов" + i, randomBirthDate);
        }

        System.out.println("The dictionary 'Surname' : 'Date Of Birthday' is: ");
        for (Map.Entry<String, LocalDate> pair : mapForSurnameAndDOB.entrySet()) {
            String key = pair.getKey();
            LocalDate value = pair.getValue();
            System.out.println(String.format("%s : %s", key, value));
        }

        Map<String, LocalDate> peopleThatBornNotSummer = new LinkedHashMap<>();
        LocalDate firstJun = LocalDate.parse("1993-06-01");
        LocalDate firstSep = LocalDate.parse("1993-09-01");

        for (Map.Entry<String, LocalDate> pair : mapForSurnameAndDOB.entrySet()) {
            String key = pair.getKey();
            LocalDate value = pair.getValue();
            if (value.isAfter(firstJun) && value.isBefore(firstSep)) peopleThatBornNotSummer.remove(key);
            else peopleThatBornNotSummer.put(key, value);
        }

        System.out.println("People that not born in summer");
        for (Map.Entry<String, LocalDate> pair : peopleThatBornNotSummer.entrySet()) {
            String key = pair.getKey();
            LocalDate value = pair.getValue();
            System.out.println(String.format("%s : %s", key, value));
        }
    }

    /* 16. Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
     Удалить людей, имеющих одинаковые имена. */
    static void deleteRecordWhereTheSameValues() {
        Map<String, String> mapNameAndSurname = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            mapNameAndSurname.put("Иванов" + i, "Иван" + i);
            mapNameAndSurname.put("Cидоров" + i, "Иван");
        }

        Map<String, String> mapWhereDeleteTheSameValues = new LinkedHashMap<>();

        for (Map.Entry<String, String> pair : mapNameAndSurname.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (mapWhereDeleteTheSameValues.containsValue(value)) mapWhereDeleteTheSameValues.remove(key);
            else mapWhereDeleteTheSameValues.put(key, value);
        }

        for (Map.Entry<String, String> pair : mapWhereDeleteTheSameValues.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(String.format("%s : %s", key, value));
        }
    }

    /* 17.
    1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
    2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
    3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями. Обратить внимание на количество записей в получившейся коллекции.
    4. Вывести содержимое Map на экран.   */
    static void printDictionaryOn10People() {

        Map<String, String> mapNameAndSurname = new HashMap<>();
        for (int i = 1; i <= 2; i++) {
            mapNameAndSurname.put("Иванов", "Иван" + i);
            mapNameAndSurname.put("Cидоров" + i, "Иван");
            mapNameAndSurname.put("Петров" + i, "Василий");
            mapNameAndSurname.put("Иванов", "Петр");
            mapNameAndSurname.put("Егорова" + i, "Клава");
        }

        for (Map.Entry<String, String> pair : mapNameAndSurname.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(String.format("%s : %s", key, value));
        }
    }
}
