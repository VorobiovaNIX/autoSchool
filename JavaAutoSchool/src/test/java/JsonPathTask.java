import org.json.JSONException;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.path.json.JsonPath.with;

public class JsonPathTask {


    private final File jsonFile = new File("src/test/resources/JsonExample.json");

    @Test
    public void testJsonPath() throws JSONException {
        // 1. Вывести на экран список объектов стран из JSON.
        List<Map> someValue1 = with(jsonFile).get("data.results");
        System.out.println(someValue1);

        // 2. Вывести на экран список имён стран расположенных в "Caribbean" саб регионе("geographicSubRegionCode").
        List<String> someValue2 = with(jsonFile).get("data.results.findAll {it.geographicSubRegionCode.name =='Caribbean'}.name");
        System.out.println(someValue2);

        // 3. Вывести на экран "id" для страны "Bosnia and Herzegovina".
        String someValue3 = with(jsonFile).get("data.results.find {it.name=='Bosnia and Herzegovina'}.id");
        System.out.println(someValue3);

        // 4. Вывести на экран список саб регионов.
        List<Map> someValue4 = with(jsonFile).get("data.results.geographicSubRegionCode");
        System.out.println(someValue4);

        //5. Вывести на экран имя "name" страны с кодом("codeNumeric") 166.
        String someValue5 = with(jsonFile).get("data.results.find {it.codeNumeric==166}.name");
        System.out.println(someValue5);

        // 6. Вывести на экран общее количество стран ("totalCount").
        int someValue6 = with(jsonFile).get("data.totalCount");
        System.out.println(someValue6);

        //7. Вывести на экран все имена полей("fields").
        List<String> someValue7 = with(jsonFile).get("metaData.fields.name");
        System.out.println(someValue7);

        //8. Вывести на экран имена всех стран у которых codeNumeric >500
        List<String> someValue8 = with(jsonFile).get("data.results.findAll {it.codeNumeric>500}.name");
        System.out.println(someValue8);

        //9. Вывести на экран id всех стран у которых codeNumeric > 100 и < 200.
        List<String> someValue9 = with(jsonFile).get("data.results.findAll {it.codeNumeric>100 && it.codeNumeric<200}.id");
        System.out.println(someValue9);

    }

// 1 -> $.data.results
// 2 -> $.data.results[?(@.geographicSubRegionCode.name=="Caribbean")].name
// 3 -> $.data.results[?(@.name=="Bosnia and Herzegovina")].id
// 4 -> $.data.results[*].geographicSubRegionCode
// 5 -> $.data.results[?(@.codeNumeric==166)].name
// 6 -> $.data.totalCount
// 7 -> $.metaData.fields[:].name
// 8 -> $.data.results[?(@.codeNumeric>500)].name
// 9 -> $.data.results[?(@.codeNumeric>100 && @.codeNumeric<200)].id

}
