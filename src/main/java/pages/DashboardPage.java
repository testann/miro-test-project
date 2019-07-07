package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(css = "div[data-autotest-id='dashboard__content']")
    private WebElement dashboard;

    public boolean openDashboardPage() {

        return waitUntilPageLoaded(dashboard).isDisplayed();

    }

}
