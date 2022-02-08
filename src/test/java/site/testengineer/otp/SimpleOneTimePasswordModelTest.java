package site.testengineer.otp;

import base.AbstractController;
import io.restassured.builder.RequestSpecBuilder;
import model.OneTimePasswordModel;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.byLessThan;

public class SimpleOneTimePasswordModelTest extends AbstractController {

    private RequestSpecBuilder specBuilder = new RequestSpecBuilder()
            .addHeader("Content-type", "application/json; charset=UTF-8")
            .setBasePath("api/v1/otp");

    @Test
    public void testSimpleOneTimePasswordCheckThatBoyIsNotNull() {
        OneTimePasswordModel oneTimePasswordModel =
                given(specBuilder.build())
                        .when()
                        .get("/create").then()
                        .statusCode(200).extract()
                        .as(OneTimePasswordModel.class);

        assertThat(oneTimePasswordModel.getId()).isNotNull();
        assertThat(oneTimePasswordModel.getOneTimePasswordCode()).isNotNull();
        assertThat(oneTimePasswordModel.getExpires()).isNotNull();
    }

    @Test
    public void testSimpleOneTimePasswordCheckTime() {
        OneTimePasswordModel oneTimePasswordModel =
                given(specBuilder.build())
                        .when()
                        .get("/create").then()
                        .statusCode(200)
                        .time(Matchers.lessThan(1000L))
                        .extract()
                        .as(OneTimePasswordModel.class);

        assertThat(oneTimePasswordModel.getId()).isNotNull();
        assertThat(oneTimePasswordModel.getOneTimePasswordCode()).isNotNull();
        assertThat(oneTimePasswordModel.getExpires()).isNotNull();
    }
}
