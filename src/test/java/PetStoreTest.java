import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("Petstore API tests")
@Feature("Pet CRUD Operations")
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
}
