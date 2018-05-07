import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class GoogleTest {

    WebDriver chrome;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920,1080", "--no-sandbox");

        chrome = new ChromeDriver(options);

        chrome.get("https://google.com");
    }

    @Test
    public void searchLabelIsDisplayed() {
        WebElement langLabel = chrome.findElement(By.id("SIvCob"));
        assertFalse(langLabel.isDisplayed());

        chrome.quit();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        chrome.quit();
    }
}
