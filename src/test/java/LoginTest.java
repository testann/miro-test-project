import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final String USER_EMAIL = "saklakova.anya@gmail.com";
    private static final String USER_PASSWORD = "12345678";

    private LoginPage loginPage = new LoginPage();

    @DataProvider
    public Object[][] testDataForWrongEmailFormat() {
        return new Object[][] {
                new Object[] {"qwesaklakova.anya"},
                new Object[] {"sakalkova.anya@"},
                new Object[] {"@gmail.com"},
                new Object[] {"saklakova.anya@gmail"},
                new Object[] {"saklakova.anya@gmail."},
                new Object[] {"saklakova.anya@gmail."},
                new Object[] {"saklakova.anya@gmail."},
        };
    }

    @BeforeMethod
    private void open() {

        loginPage.open();

    }

    @Test(priority = 2, description="Login with empty email")
    private void loginWithEmptyEmail() {

        loginPage.clearInputs()
                .enterPassword(USER_PASSWORD)
                .clickSignInButtonExpectingFailure();
        Assert.assertTrue(loginPage.displayErrorMessageWhenEmptyEmail());

    }

    @Test(priority = 1, description="Login with empty password")
    private void loginWithEmptyPassword() {

        loginPage.clearInputs()
                .enterEmail(USER_EMAIL)
                .clickSignInButtonExpectingFailure();
        Assert.assertTrue(loginPage.displayErrorMessageWhenEmptyPassword());

    }

    @Test(priority = 3, description="Login with empty login and password")
    private void loginWithEmptyEmailAndPassword() {

        loginPage.clearInputs()
                .clickSignInButtonExpectingFailure();
        Assert.assertTrue(loginPage.displayErrorMessageWhenEmptyEmail());
        Assert.assertTrue(loginPage.displayErrorMessageWhenEmptyPassword());

    }

    @Test(priority = 4, description="Login with wrong email or password", dataProvider = "testDataForWrongEmailFormat")
    public void loginWithWrongEmailOrPassword(String userEmail) {

        loginPage.enterEmailAndPassword(userEmail, USER_PASSWORD)
                .clickSignInButtonExpectingFailure();
        Assert.assertTrue(loginPage.displayErrorMessageWhenIncorrectEmailOrPassword());

    }

    @Test(priority = 0, description="Login with correct email and password")
    public void loginWithCorrectEmailAndPassword() {

        Assert.assertTrue(loginPage.enterEmailAndPassword(USER_EMAIL, USER_PASSWORD)
                .submitLogin().openDashboardPage());

    }

}