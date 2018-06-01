import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    BrowserOptionsManager browserOptionsManager = new BrowserOptionsManager();
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    synchronized void setDriver(String browser) {
        if (browser.equals("firefox")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(browserOptionsManager.getFirefoxOption()));
        } else {
            threadLocalDriver = ThreadLocal.withInitial(() -> new ChromeDriver(browserOptionsManager.getChromeOptions()));
        }
    }

    synchronized ThreadLocal<WebDriver> getDriver() {
        return threadLocalDriver;
    }

}
