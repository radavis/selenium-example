import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchButtonTests extends BaseTest {

    SearchButtonPage searchButtonPage;

    @BeforeMethod
    private void setUp() throws IOException {
        searchButtonPage = new SearchButtonPage(driver);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(file, new File("./tmp/screenshot.png"));
    }

    @Test
    public void whenOnHomePage_SearchButtonsAreVisibleWithTheCorrectText() {
        Assert.assertTrue(searchButtonPage.searchButtonsAreDisplayed());
        Assert.assertEquals(searchButtonPage.getSearchButtonText(), "Google Search");
        Assert.assertEquals(searchButtonPage.getFeelingLuckyButtonText(), "I'm Feeling Lucky");
    }

}
