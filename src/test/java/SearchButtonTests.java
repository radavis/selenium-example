import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchButtonTests extends BaseTest {

    SearchButtonPage searchButtonPage;

    @BeforeMethod
    private void setUp() {
        searchButtonPage = new SearchButtonPage(driver);
    }

    @Test
    public void whenOnHomePage_SearchButtonsAreVisibleWithTheCorrectText() {
        // Assert.assertTrue(searchButtonPage.searchButtonsAreDisplayed());
        Assert.assertEquals(searchButtonPage.getSearchButtonText(), "Google Search");
        Assert.assertEquals(searchButtonPage.getFeelingLuckyButtonText(), "I'm Feeling Lucky");
    }

}
