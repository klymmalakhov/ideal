package rest.controller;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import rest.models.User;


import java.io.IOException;
import java.security.PrivateKey;

import static io.restassured.RestAssured.given;
import static utils.properties.PropertyHolder.getPropValue;



public class UserRest {

    private final String USERS = "/api/users";
    private final String USERS_INFO = "/api/users/{userId}";

    private RequestSpecification reqSpec = new RequestSpecBuilder()
            .setBaseUri(getPropValue("URL_reqres"))
            .build();


    @Step("POST " + USERS + " - Create new user")
    public Response createUser(String job, String name) {

        User user = User.builder()
                .job(job)
                .name(name)
                .build();

        return given()
                .spec(reqSpec)
                .accept(ContentType.TEXT)
                .body(user)
                .when()
                .post(USERS)
                .then()
                .extract().response();
    }

    @Step("GET " + USERS_INFO + " - Get user info by id {userId}")
    public Response getUserInfo(String userId) {
        return given()
                .spec(reqSpec)
                .when()
                .pathParam("userId", userId)
                .get(USERS_INFO)
                .then()
                .extract().response();
    }

    @Step("PUT " + USERS_INFO + " - Update the user info by id {userId}")
    public Response putUserInfo(String userId, String job, String name) {

        User user = User.builder()
                .job(job)
                .name(name)
                .build();

        return given()
                .spec(reqSpec)
                .body(user)
                .when()
                .pathParam("userId", userId)
                .put(USERS_INFO)
                .then()
                .extract().response();
    }
}
