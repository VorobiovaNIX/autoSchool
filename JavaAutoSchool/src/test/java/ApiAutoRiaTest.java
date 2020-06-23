import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;


public class ApiAutoRiaTest {

    @Test
    public void testMitsubishi() throws JSONException {
        Response resp = given().header("User-Agent", "Jmeter")
                .get("https://auto.ria.com/auto_mitsubishi_lancer_21990745.html");
        assertEquals(200, resp.getStatusCode());
        assertThat(resp.header("Content-Type"), containsString("text/html"));
        assertThat(resp.header("Content-Encoding"), containsString("gzip"));
    }

    @Test
    public void testToyota() throws JSONException {
        Response resp = given().header("User-Agent", "Jmeter")
                .get("https://auto.ria.com/auto_toyota_camry_22101863.html");
        assertEquals(200, resp.getStatusCode());
        assertThat(resp.header("Content-Type"), containsString("text/html"));
        assertThat(resp.header("Content-Encoding"), containsString("gzip"));
    }

    @Test
    public void testBmw() throws JSONException {
        Response resp = given().header("User-Agent", "Jmeter")
                .get("https://auto.ria.com/auto_bmw_520_21996828.html");
        assertEquals(200, resp.getStatusCode());
        assertThat(resp.header("Content-Type"), containsString("text/html"));
        assertThat(resp.header("Content-Encoding"), containsString("gzip"));
    }

    @Test
    public void testNissanLeaf() throws JSONException {
        Response resp = given().header("User-Agent", "Jmeter")
                .get("https://auto.ria.com/auto_nissan_leaf_22104675.html");
        assertEquals(200, resp.getStatusCode());
        assertThat(resp.header("Content-Type"), containsString("text/html"));
        assertThat(resp.header("Content-Encoding"), containsString("gzip"));
    }

    @Test
    public void testNissanLeaf2() throws JSONException {
        Response resp = given().header("User-Agent", "Jmeter")
                .get("https://auto.ria.com/auto_nissan_leaf_22104647.html");
        assertEquals(200, resp.getStatusCode());
        assertThat(resp.header("Content-Type"), containsString("text/html"));
        assertThat(resp.header("Content-Encoding"), containsString("gzip"));
    }


    @Test
    public void testMercedesBenz() throws JSONException {
        Response resp = given().header("User-Agent", "Jmeter")
                .get("https://auto.ria.com/auto_mercedes_benz_e_220_21994701.html");
        assertEquals(200, resp.getStatusCode());
        assertThat(resp.header("Content-Type"), containsString("text/html"));
        assertThat(resp.header("Content-Encoding"), containsString("gzip"));
    }

    @Test
    public void testLexusNx() throws JSONException {
        Response resp = given().header("User-Agent", "Jmeter")
                .get("https://auto.ria.com/auto_lexus_nx_200_22083607.html");
        assertEquals(200, resp.getStatusCode());
        assertThat(resp.header("Content-Type"), containsString("text/html"));
        assertThat(resp.header("Content-Encoding"), containsString("gzip"));
    }

}
