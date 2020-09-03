import io.qameta.allure.*;
import org.testng.annotations.Test;
import properties.PropertyHolder;
import web.pages.LoginPage;

import static utils.Groups.smoke;

@Epic("User management")
@Feature("Login")
public class LoginTest extends BaseTest {

    /**
     Task
     1. Framework can execute tests at least in Chrome/Firefox browsers
     2. Login with any credentials
     3. Implement Logout Test action by UI
     4. Implement Logout Test action by /account/logout/
     */


    @Story("As an User I'm able to login and using UI logout")
    @Description("Description")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "allure", type = "issue")
    @Test(description = "Check possibility to login and using UI logout", groups = {smoke})
    public void loginTest() {

        driver.get(PropertyHolder.getPropValue("URL_Login"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .validateThatUserSignedOut()
                .loginViaUI()
                .validateThatUserSignedIn()
                .logout()
                .validateThatUserSignedOut();

    }

}
