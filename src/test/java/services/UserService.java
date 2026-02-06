package services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;

import static io.restassured.RestAssured.given;

public class UserService {

    public static Response createUser(RequestSpecification spec, User user) {

        return given()
                .spec(spec)
                .body(user)
                .when()
                .post("/user");
    }

    public static Response getUser(RequestSpecification spec, String username) {

        return given()
                .spec(spec)
                .when()
                .get("/user/" + username);
    }
}