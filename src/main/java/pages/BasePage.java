package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;

public class BasePage {

    private static final String TYPE_DRIVER = "webdriver.chrome.driver";
    private static final String PATH_TO_DRIVER = "D:/chromeDriver/chromedriver.exe";
    private static final Integer WAITING_TIMEOUT_IN_SEC = 3;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {

        System.setProperty(TYPE_DRIVER, PATH_TO_DRIVER);
        this.driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
        PageFactory.initElements(this.driver, this);
        this.wait  = new WebDriverWait(driver, WAITING_TIMEOUT_IN_SEC);

    }

    public WebElement waitUntilPageLoaded(WebElement webElement) {

        return wait.until(ExpectedConditions.visibilityOf(webElement));

    }

    public void close() {

        WebDriverPool.DEFAULT.dismissAll();

    }

}
