import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.ResponseSpecification;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;


public class ApiAutoRiaTest {

    ResponseSpecBuilder spec;
    ResponseSpecification responseSpec;

    @Before
    public void setup() {
        RestAssured.baseURI = "https://auto.ria.com";
        spec = new ResponseSpecBuilder();
        spec.expectStatusCode(200);
        spec.expectContentType("text/html");
        spec.expectHeader("Content-Encoding", "gzip");
        responseSpec = spec.build();
    }

    @Test
    public void testMitsubishi() throws JSONException {
        given().log().all().header("User-Agent", "Jmeter")
                .when()
                .get("/auto_mitsubishi_lancer_21990745.html")
                .then()
                .log().all()
                .spec(responseSpec);
    }

    @Test
    public void testToyota() throws JSONException {
        given().header("User-Agent", "Jmeter")
                .when()
                .get("/auto_toyota_camry_22101863.html")
                .then()
                .log().all()
                .spec(responseSpec);
    }

    @Test
    public void testBmw() throws JSONException {
        given().header("User-Agent", "Jmeter")
                .when()
                .get("/auto_bmw_520_21996828.html")
                .then()
                .log().all()
                .spec(responseSpec);
    }

    @Test
    public void testNissanLeaf() throws JSONException {
        given().header("User-Agent", "Jmeter")
                .when()
                .get("/auto_nissan_leaf_22104675.html")
                .then()
                .log().all()
                .spec(responseSpec);
    }

    @Test
    public void testNissanLeaf2() throws JSONException {
        given().header("User-Agent", "Jmeter")
                .when()
                .get("/auto_nissan_leaf_22104647.html")
                .then()
                .log().all()
                .spec(responseSpec);
    }

    @Test
    public void testMercedesBenz() throws JSONException {
        given().header("User-Agent", "Jmeter")
                .when()
                .get("/auto_mercedes_benz_e_220_21994701.html")
                .then()
                .log().all()
                .spec(responseSpec);
    }

    @Test
    public void testLexusNx() throws JSONException {
        given().header("User-Agent", "Jmeter")
                .when()
                .get("/auto_lexus_nx_200_22083607.html")
                .then()
                .log().all()
                .spec(responseSpec);
    }

    @After
    public void tearDown() {
        RestAssured.reset();
    }
}
