import drivers.Drivers;
import listener.AllureReportListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


@Listeners({
        AllureReportListener.class,
})

public class BaseTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        String browserName = System.getProperty("browser");
        if (browserName != null) {
            Drivers.create(Drivers.DEFAULT_DRIVER_NAME, browserName);
        } else {
            Drivers.create(Drivers.DEFAULT_DRIVER_NAME, Drivers.CHROME_DRIVER);
        }
        driver = Drivers.get(Drivers.DEFAULT_DRIVER_NAME);
    }

    @AfterClass
    public static void tearDown() {
        Drivers.clear();
    }
}
