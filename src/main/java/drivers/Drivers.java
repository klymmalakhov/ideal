package drivers;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drivers {
    public static final String CHROME_DRIVER = "chrome";
    public static final String FIREFOX_DRIVER = "firefox";
    public static final String IE_DRIVER = "ie";

    public static final String DEFAULT_DRIVER_NAME = "default";
    private static Map<String, WebDriver> driversPool = new HashMap<>();


    private static void put(String name, WebDriver driver) {
        driversPool.put(name, driver);
    }

    public static WebDriver get(String name) {
        return driversPool.get(name);
    }

    public static void create(String name, String browser) {
        WebDriver driver = DriverFactory.create(browser);
        put(name, driver);
    }

    public static void clear() {
        List<WebDriver> driverList = new ArrayList<>(driversPool.values());
        for (WebDriver driver : driverList) {
            driver.close();
        }
        driversPool = new HashMap<>();
    }

}
