import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchButtonPage extends PageObject {

    public SearchButtonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "btnK")
    WebElement googleSearchButton;

    @FindBy(name ="btnI")
    WebElement feelingLuckyButton;

    protected Boolean searchButtonsAreDisplayed() {
        return googleSearchButton.isDisplayed() && feelingLuckyButton.isDisplayed();
    }

    protected String getSearchButtonText() {
        return googleSearchButton.getAttribute("value");
    }

    protected String getFeelingLuckyButtonText() {
        return feelingLuckyButton.getAttribute("value");
    }

}
