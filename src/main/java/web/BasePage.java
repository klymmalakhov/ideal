package web;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class BasePage {

    private final Logger log = LoggerFactory.getLogger(BasePage.class);

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        log.info("Start base page");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Validate that element {element} is {condition} on page")
    protected void elementShouldBe(WebElement element, String condition) {
        log.info("Validate that {} is {} on page", element, condition);
        switch (condition) {
            case "displayed":
                assertTrue(element.isDisplayed());
                break;
            case "not displayed":
                assertFalse(element.isDisplayed());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + condition);
        }
    }

}
