import java.util.*;

public class HashSetTasks {

    /*    1. HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки. Посмотреть, как изменился порядок добавленных элементов
     */
    public static void printHashSetOfPlants() {
        String[] arrayOfPlants = {"aрбуз", "банан", "вишня", "груша", "дыня",
                "ежевика", "жень-шень", "земляника", "ирис", "картофель"};
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(arrayOfPlants));

        for (String plant : hashSet) {
            System.out.println(plant);
        }
    }
/* 2. HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк: арбуз – ягода, банан – трава, вишня – ягода,
груша – фрукт, дыня – овощ, ежевика – куст, жень-шень – корень, земляника – ягода, ирис – цветок, картофель – клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки. */

    public static void printHashMapOfPlants() {

        Map<String, String> hashMap = new HashMap<>(Map.of("арбуз", "ягода", "банан", "трава",
                "вишня", "ягода", "груша", "фрукт", "дыня", "овощ", "ежевика",
                "куст", "жень-шень", "корень", "земляника", "ягода", "ирис",
                "цветок", "картофель", "клубень"));

        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(String.format("%s - %s", key, value));
        }
    }

    /*    3. Коллекция HashMap из котов
Есть класс Cat, с полем имя (name, String). Создать коллекцию HashMap<String, Cat>.
Добавить в коллекцию 10 котов, в качестве ключа использовать имя кота. Вывести результат на экран, каждый элемент с новой строки. */

    public static void printHashMapOfCats() {

        Map<String, Cat> catHashMap = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            String name = "Cat " + i;
            catHashMap.put(name, new Cat(name));
        }

        for (Map.Entry<String, Cat> pair : catHashMap.entrySet()) {
            String key = pair.getKey();
            Cat value = pair.getValue();
            System.out.println(String.format("%s : %s", key, value));
        }
    }

    /* 4. Вывести на экран список ключей
Есть коллекция HashMap<String, String>, туда занесли 10 различных строк.
Вывести на экран список ключей, каждый элемент с новой строки.   */

    public static void printKeysOfHashMap() {

        Map<String, String> hashMap = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            String key = "Key " + i;
            String value = "Value " + i;
            hashMap.put(key, value);
        }

        for (String key : hashMap.keySet()) {
            System.out.println(key);
        }
    }

    /* 5. Вывести на экран список значений
Есть коллекция HashMap<String, String>, туда занесли 10 различных строк.
Вывести на экран список значений, каждый элемент с новой строки.    */
    public static void printValuesOfHashMap() {
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            String key = "Key " + i;
            String value = "Value " + i;
            hashMap.put(key, value);
        }

        for (String value : hashMap.values()) {
            System.out.println(value);
        }
    }

    /*6. Коллекция HashMap из Object
Есть коллекция HashMap<String, Object>, туда занесли 10 различных пар объектов.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.  */

    public static void printHashMapWithObject() {

        Map<String, Object> hashMap = new LinkedHashMap<>();

        for (int i = 1; i <= 10; i++) {
            String key = "Key for object " + i;
            Integer value = i * 10;
            hashMap.put(key, value);
        }

        for (Map.Entry<String, Object> pair : hashMap.entrySet()) {
            String key = pair.getKey();
            Object value = pair.getValue();
            System.out.println(String.format("%s : %s", key, value));
        }
    }

}

class Cat {
    public Cat(String name) {
    }
}
