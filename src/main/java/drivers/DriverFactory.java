package drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import properties.PropertyHolder;

import java.util.concurrent.TimeUnit;

import static drivers.Drivers.*;


class DriverFactory {
    private DriverFactory() {
    }

    static WebDriver create(String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case CHROME_DRIVER:
                driver = getChromeDriver();
                break;
            case FIREFOX_DRIVER:
                driver = getFirefoxDriver();
                break;
            case IE_DRIVER:
                driver = getIEDriver();
                break;
            default:
                throw new DriverException("No found driver for browser '" + browserName + "'.");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        return driver;
    }

    private static String getPathToDriver(String browser) {
        return System.getProperty("user.dir") + PropertyHolder.getPropValue(browser + "_driver_path");
    }

    private static WebDriver getIEDriver() {
        System.setProperty("webdriver.ie.driver", getPathToDriver(IE_DRIVER));
        return new org.openqa.selenium.ie.InternetExplorerDriver();
    }

    private static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", getPathToDriver(FIREFOX_DRIVER));
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", getPathToDriver(CHROME_DRIVER));
        return new ChromeDriver();
    }
}
