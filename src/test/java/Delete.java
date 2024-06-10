import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Delete {
    @Test
    public void deleteMethodTest() {
        String path = "https://postman-echo.com/delete";
        given().
                header("Content-Type", "application/json").
                body("This is expected to be sent back as part of response body.").
                when().
                delete(path).
                then().
                body("headers.'x-forwarded-proto'", equalTo("https")).
                body("headers.'x-forwarded-port'", equalTo("443")).
                body("headers.host", equalTo("postman-echo.com")).
                body("headers.content-length", equalTo("58")).
                body("headers.content-type", equalTo("application/json")).
                body("headers.accept", equalTo("*/*")).
                body("headers.'accept-encoding'", equalTo("gzip,deflate")).
                body("url", equalTo(path)).
                assertThat().statusCode(200);
    }
}
