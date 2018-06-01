import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class PageObject {

    protected WebDriver driver;
    protected Logger logger;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

}
