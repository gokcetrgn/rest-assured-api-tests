import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;


@Epic("Petstore API tests")
@Feature("Pet Operations")
public class PetStoreTest extends BaseTest{
    @Test(description = "Get pet by ID")
    @Description("Verify that a pet can be retrieved successfully using its ID")
    public void getPostByID(){
        given()
                .spec(requestSpec)
                .when().get("/pet/123")
                .then().statusCode(200)
                .body("id",equalTo(123));

    }

    @Test(description = "Get pet with invalid ID type")
    @Description("Verify API behavior when an invalid data type is sent as pet ID (string instead of integer). Expected result: API should return HTTP 400 Bad Request.")
    public void getPetInvalidID() {

        Response response =
                given()
                        .spec(requestSpec)
                        .when()
                        .get("/pet/abc");

        int statusCode = response.getStatusCode();

        assertEquals(statusCode, 404);
    }

    @Test(description = "Access wrong endpoint")
    @Description("Verify that API returns HTTP 404 Not Found when an incorrect endpoint path is used.")
    public void wrongEndpoint() {

        Response response =
                given()
                        .spec(requestSpec)
                        .when()
                        .get("/pettt/123");

        int statusCode = response.getStatusCode();

        assertEquals(statusCode, 404);
    }


}
