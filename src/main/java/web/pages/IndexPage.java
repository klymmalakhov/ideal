package web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.BasePage;


public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    private final Logger log = LoggerFactory.getLogger(IndexPage.class);

    @FindBy(xpath = "//a[@class='account']")
    private WebElement MENU_USER_NAME;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement MENU_USER_LOGOUT_BUTTON;

    @Step("Validate that user is signed in")
    public IndexPage validateThatUserSignedIn() {
        log.info("Validate the user menu");
        super.elementShouldBe(MENU_USER_NAME, "displayed");
        super.elementShouldBe(MENU_USER_LOGOUT_BUTTON, "displayed");
        return this;
    }

    @Step("Click on the logout button")
    public LoginPage logout(){
        this.MENU_USER_LOGOUT_BUTTON.click();
        return new LoginPage(driver);
    }
}
