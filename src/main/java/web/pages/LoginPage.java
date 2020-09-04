package web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.properties.PropertyHolder;
import web.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "email")
    private WebElement INPUT_USER_EMAIL;

    @FindBy(id = "passwd")
    private WebElement INPUT_USER_PASSWORD;


    @FindBy(id = "SubmitLogin")
    private WebElement BUTTON_SUBMIT;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement MENU_USER_LOGIN_BUTTON;

    @Step("Login into as saved user")
    public IndexPage loginViaUI() {
        log.info("Make a login");
        openSigInMenu()
                .enterEmail(PropertyHolder.getPropValue("USER_EMAIL"))
                .enterPassword(PropertyHolder.getPropValue("USER_PASSWORD"))
                .submitLoginCreds();
        return new IndexPage(driver);
    }

    @Step("Open the Sign in dialog bar")
    public LoginPage openSigInMenu() {
        log.info("Open the Sign in dialog bar");
        this.MENU_USER_LOGIN_BUTTON.click();
        return this;
    }

    @Step("Validate that user is signed out")
    public LoginPage validateThatUserSignedOut() {
        log.info("Validate that user is signed out");
        super.elementShouldBe(MENU_USER_LOGIN_BUTTON, "displayed");
        return this;
    }

    @Step("Enter email {email}")
    public LoginPage enterEmail(String email) {
        log.info("Enter email");
        this.INPUT_USER_EMAIL.clear();
        this.INPUT_USER_EMAIL.sendKeys(email);
        return this;
    }

    @Step("Enter password {password}")
    public LoginPage enterPassword(String password) {
        log.info("Enter password");
        this.INPUT_USER_PASSWORD.clear();
        this.INPUT_USER_PASSWORD.sendKeys(password);
        return this;
    }

    @Step("Submit login form with credentials")
    public void submitLoginCreds() {
        log.info("Submit login form with credentials");
        this.BUTTON_SUBMIT.click();
    }
}
