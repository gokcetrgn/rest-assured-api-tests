import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("Petstore API tests")
@Feature("User Operations")
public class UserTest extends BaseTest{
    private static final String userName = "barbieKenFan_" + System.currentTimeMillis();

    @Test(description = "Create a new user")
    @Description("Create user in the store")
    public void createUser() {
        given()
                .spec(requestSpec)
                .body("{ \"id\": 0, \"username\": \"" + userName + "\", \"firstName\": \"Barbie\", \"lastName\": \"Fan\", \"email\": \"barbieekenn@example.com\", \"password\": \"12345\", \"phone\": \"1234567890\", \"userStatus\": 1 }")
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .body("username", equalTo(userName));
    }
    @Test(description = "Get user by username", dependsOnMethods = "createUser")
    @Description("Verify user details")
    public void getUser() {
        given()
                .spec(requestSpec)
                .when()
                .get("/user/" + userName)
                .then()
                .statusCode(200)
                .body("username", equalTo(userName));
    }

    @Test(description = "Delete user", dependsOnMethods = "getUser")
    @Description("Delete the user and verify deletion")
    public void deleteUser() {
        given()
                .spec(requestSpec)
                .when()
                .delete("/user/" + userName)
                .then()
                .statusCode(200);
    }
}
