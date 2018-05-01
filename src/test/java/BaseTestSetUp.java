import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestSetUp {

    WebDriver chrome;
    WebDriver firefox;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        Capabilities chromeCapabilities = DesiredCapabilities.chrome();
        Capabilities fireFoxCapabilities = DesiredCapabilities.firefox();

        // does this selenium hub ip change? would need to extract into env variable if it does
        chrome = new RemoteWebDriver(new URL("http://172.19.0.2:4444/wd/hub"), chromeCapabilities);
        firefox = new RemoteWebDriver(new URL("http://172.19.0.2:4444/wd/hub"), fireFoxCapabilities);
    }

    @AfterTest
    public void tearDown() {
        chrome.close();
        firefox.close();
    }

}
