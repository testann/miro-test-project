package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final String URL = "https://miro.com/login/";

    @FindBy(id = "email")
    private WebElement emailInputElement;
    @FindBy(id = "password")
    private WebElement passwordInputElement;
    @FindBy(css = "button[data-autotest-id='mr-form-login-btn-signin-1']")
    private WebElement signInButton;
    @FindBy(css = "div[data-autotest-id='mr-error-please-enter-your-password.-1']")
    private WebElement errorMessageWhenEmptyPassword;
    @FindBy(css = "div[data-autotest-id='mr-error-please-enter-your-email-address.-1']")
    private WebElement errorMessageWhenEmptyEmail;
    @FindBy(css = "div[data-autotest-id^='mr-error-the-email-or-password-you-entered-is-incorrect']")
    private WebElement errorMessageWhenIncorrectEmailOrPassword;
    @FindBy(css = ".g-recaptcha")
    private WebElement recaptcha;

    public void open() {

        this.driver.get(URL);

    }

    public LoginPage enterEmail(String email) {

        emailInputElement.sendKeys(email);
        return this;

    }

    public LoginPage enterPassword(String password) {

        passwordInputElement.sendKeys(password);
        return this;

    }

    public LoginPage enterEmailAndPassword(String login, String password) {

        enterEmail(login).enterPassword(password);
        return this;

    }

    public void clickSignInButton() {

        signInButton.click();

    }

    public void clickSignInButtonExpectingFailure() {

        clickSignInButton();

    }

    public boolean displayErrorMessageWhenEmptyPassword() {

        return waitUntilPageLoaded(errorMessageWhenEmptyPassword).isDisplayed();

    }

    public boolean displayErrorMessageWhenEmptyEmail() {

        return  waitUntilPageLoaded(errorMessageWhenEmptyEmail).isDisplayed();

    }

    public boolean displayErrorMessageWhenIncorrectEmailOrPassword() {

        try {

            return waitUntilPageLoaded(errorMessageWhenIncorrectEmailOrPassword).isDisplayed();

        } catch(TimeoutException exception) {

            return recaptcha.isDisplayed();

        }

    }

    public DashboardPage submitLogin() {

        clickSignInButton();
        return new DashboardPage();

    }

    public LoginPage clearInputs() {

        emailInputElement.clear();
        passwordInputElement.clear();
        return this;

    }

}
