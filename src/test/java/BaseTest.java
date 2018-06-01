import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    WebDriver driver;
    private DriverFactory driverFactory = new DriverFactory();

    private WebDriver getDriver() {
        return driverFactory.getDriver().get();
    }

    @Parameters({"browser"})
    @BeforeMethod()
    void setUp(final String browser) {
        driverFactory.setDriver(browser);

        driver = getDriver();

        driver.get("https://www.google.com");
    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        driver.quit();
        driverFactory.getDriver().remove();
    }

}
