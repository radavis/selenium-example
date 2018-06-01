import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptionsManager {

    public ChromeOptions getChromeOptions() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--no-sandbox", "--window-size=1920,1080");

        return chromeOptions;
    }

    public FirefoxOptions getFirefoxOption() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return firefoxOptions;
    }

}
