import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class GoogleTest extends BaseTestSetUp {

    @Test
    public void searchButtonIsDisplayed() {
        firefox.get("https://google.com");

        WebElement searchButton = firefox.findElement(By.name("btnK"));
        assertTrue(searchButton.isDisplayed());

        firefox.quit();
    }

    @Test
    public void searchLabelIsDisplayed() {
        chrome.get("https://google.com");

        WebElement langLabel = chrome.findElement(By.id("SIvCob"));
        assertFalse(langLabel.isDisplayed());

        chrome.quit();
    }
}
