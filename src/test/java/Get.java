import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Get {

    @Test
    public void getMethodTest() {
        String path = "https://postman-echo.com/get";
        given().
                when().
                get(path).
                then()
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'x-forwarded-port'", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.'accept-encoding'", equalTo("gzip,deflate"))
                .body("url", equalTo(path)).
                assertThat().statusCode(200);
    }
}
