import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) throws IOException {

        HashSetTasks.printHashSetOfPlants();

        HashSetTasks.printHashMapOfPlants();

        HashSetTasks.printHashMapOfCats();

        HashSetTasks.printKeysOfHashMap();

        HashSetTasks.printValuesOfHashMap();

        HashSetTasks.printHashMapWithObject();

        ArrayListTasks.getSizeArrayList();

        ArrayListTasks.findTheLongestListInArray();

        ArrayListTasks.findTheShortestListInArray();

        ArrayListTasks.addListToTheTopOfArray();

        ArrayListTasks.removeLastRowAndInsertAtFirst();

        SetAndMapTasks.createSetOn20Words();

        SetAndMapTasks.createSetOn20Numbers();

        Map<String, String> mapForNameAndSurname = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            mapForNameAndSurname.put("Иванов" + i, "Иван" + i);
            mapForNameAndSurname.put("Cидоров" + i, "Иван");
        }
        Map<String, Integer> mapForNameAndCountOfThisName = SetAndMapTasks.createMapForNameAndSurname(mapForNameAndSurname);
        for (Map.Entry<String, Integer> pair : mapForNameAndCountOfThisName.entrySet()) {
            String name = pair.getKey();
            int count = pair.getValue();
            System.out.println(String.format("%s : %d", name, count));
        }

        SetAndMapTasks.createMapForSurnameAndDOB();

        SetAndMapTasks.deleteRecordWhereTheSameValues();

        SetAndMapTasks.printDictionaryOn10People();
    }

}
