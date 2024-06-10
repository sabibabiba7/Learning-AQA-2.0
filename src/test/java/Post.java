import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Post {
    @Test
    public void postMethodTest() {
        String path = "https://postman-echo.com/post";
        given().
                header("Content-Type",  "application/json").
                formParam("foo1", "bar1").
                formParam("foo2", "bar2").
                when().
                post(path).
                then().
                body("data", equalTo("foo1=bar1&foo2=bar2")).
                body("headers.'x-forwarded-proto'", equalTo("https")).
                body("headers.'x-forwarded-port'", equalTo("443")).
                body("headers.host", equalTo("postman-echo.com")).
                body("headers.content-length", equalTo("19")).
                body("headers.accept", equalTo("*/*")).
                body("headers.'accept-encoding'", equalTo("gzip,deflate")).
                body("url", equalTo(path)).
                assertThat().statusCode(200);
    }
}
