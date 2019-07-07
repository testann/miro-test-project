import org.testng.annotations.*;
import pages.BasePage;

public class BaseTest {

    public BasePage basePage;

    @BeforeSuite
    public void startTests() {

        basePage = new BasePage();

    }

    @AfterSuite
    public void finishTests() {

        basePage.close();

    }

}
