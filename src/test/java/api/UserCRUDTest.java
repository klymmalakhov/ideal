package api;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import rest.controller.UserRest;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static utils.Groups.regression;
import static utils.Groups.smoke;

@Epic("User management")
@Feature("User")
public class UserCRUDTest {

    /**
     * Tasks
     * 1. Create User
     * 2. Get Single User by ID (already existing f.e. 12)
     * 3. Update user by Patch/Put methods
     * 4. DELETE User by Id (already existing f.e. 12)
     */

    @Story("User CRUD")
    @Description("User CRUD")
    @Link(name = "allure", type = "issue")
    @Test(description = "Check possibility to create new User", groups = {smoke})
    public void createUserTest() {

        String userName = "Ivan";
        String userJob = "Manager";

        new UserRest().createUser(userJob, userName)
                .then()
                .statusCode(201)
                .body("name", anything());
    }

    @Story("User CRUD")
    @Description("User CRUD")
    @Link(name = "allure", type = "issue")
    @Test(description = "Check possibility to get an user info", groups = {smoke})
    public void checkUserInfoTest() {

        String userId = "12";

        new UserRest().getUserInfo(userId)
                .then()
                .statusCode(200)
                .body("data.email", equalTo("rachel.howell@reqres.in"))
                .body("data.first_name", equalTo("Rachel"))
                .body("data.last_name", equalTo("Howell"));
    }

    @Story("User CRUD")
    @Description("User CRUD")
    @Link(name = "allure", type = "issue")
    @Test(description = "Check possibility to update an user info", groups = {regression})
    public void checkUpdatingUserInfoTest() {

        String userId = "12";
        String userName = "Ivan";
        String userJob = "Manager";

        new UserRest().putUserInfo(userId, userJob, userName)
                .then()
                .statusCode(200)
                .body("updatedAt", anything());
    }

    @Story("User CRUD")
    @Description("User CRUD")
    @Link(name = "allure", type = "issue")
    @Test(description = "Check possibility to delete an user", groups = {regression})
    public void checkDeletingUserInfoTest() {

        String userId = "12";

        new UserRest().deleteUser(userId)
                .then()
                .statusCode(204);
    }

}
