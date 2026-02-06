import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.User;
import org.testng.annotations.Test;
import services.UserService;

import static org.hamcrest.Matchers.equalTo;

@Epic("Petstore API tests")
@Feature("User Operations")
public class UserTest extends BaseTest{
    private static final String userName = "barbieKenFan_" + System.currentTimeMillis();

    @Test(description = "Create a new user")
    @Description("Create user in the store")
    public void createUser() {
        User user = new User();
        user.id = 0;
        user.username = userName;
        user.firstName = "Barbiie";
        user.lastName = "Fan";
        user.email = "barbieKenFan@gmail.com";
        user.password = "12345";
        user.phone = "1234567890";
        user.userStatus = 1;
        UserService.createUser(requestSpec, user)
                .then()
                .statusCode(200);
    }
    @Test(description = "Get user by username", dependsOnMethods = "createUser")
    @Description("Verify user details")
    public void getUser() {

        UserService.getUser(requestSpec, userName)
                .then()
                .statusCode(200)
                .body("username", equalTo(userName));
    }

}
