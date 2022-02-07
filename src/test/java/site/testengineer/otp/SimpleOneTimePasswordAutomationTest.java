package site.testengineer.otp;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

public class SimpleOneTimePasswordAutomationTest {

    private static RequestSpecification spec;

    @BeforeEach
    public void initSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://localhost:8080")
                .setBasePath("/api/v1/otp/")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    @Test
    public void testSimpleOneTimePasswordCheckStatusCode() {
        given().spec(spec)
                .when()
                .get("/create")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testSimpleOneTimePasswordCheckBody() {
        given().spec(spec)
                .when()
                .get("/create")
                .then().statusCode(200)
                .body("id", notNullValue())
                .body("oneTimePasswordCode", notNullValue())
                .body("expires", notNullValue());
    }

    @Test
    public void testSimpleOneTimePasswordCheckType() {
        given().spec(spec)
                .when()
                .get("/create")
                .then().statusCode(200)
                .assertThat().contentType(ContentType.JSON);
    }

    @Test
    public void testSimpleOneTimePasswordCheckTiming() {
        given().spec(spec)
                .when()
                .get("/create")
                .then().statusCode(200)
                .assertThat().time(lessThan(1000L), TimeUnit.MILLISECONDS);
    }
}
