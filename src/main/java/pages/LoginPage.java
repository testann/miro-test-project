package pages;


import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
	*
	*/
public class LoginPage extends BasePage {

	private static final String URL = "https://miro.com/login/";


	//@FindBy(id = "email")
	@FindBy(xpath = "//*")
	private WebElement test1;
	@FindBy(xpath = "//title[@*]")
	private WebElement test2;
	@FindBy(xpath = "//div | //div[@lang='en']\n")
	private WebElement test3;
	@FindBy(xpath = ".//*[@id='w3c_home_upcoming_events']/ul/li/div" +	"/p[2]")
	private WebElement test4;
	@FindBy(xpath = "/projects/project[@name='test']/editions" +	"/edition/text()")
	private WebElement emailInputElement;
	@FindBy(xpath = "//div[contains(@class, 'qwe')]")
	//@FindBy(id = "password")
	private WebElement passwordInputElement;
	@FindBy(xpath = "child::*/child::text()")
	// @FindBy(css = "button[data-autotest-id='mr-form-login-btn-signin-1']")
	private WebElement signInButton;

	@FindBy(css = ".g-recaptcha")
	private WebElement recaptcha;

	@FindBy(xpath = "//tagname[@class='value']")
	private WebElement recaptcha1;

	@FindBy(xpath = "count(/ta:someElement/ta:otherElement)")
	private WebElement recaptcha2;

	@FindBy(xpath = "//*[contains(text(),'here')]")
	private WebElement recaptcha3;

	@FindBy(xpath = "//*[contains(@type, '')]")
	private WebElement recaptcha4;

	@FindBy(xpath = "//*[@class='fea_ee-ee']//*[text()='Test']")
	private WebElement recaptcha5;

	@FindBy(css = "div[data-autotest-id='mr-error-please-enter-your-email-address.-1']")
	private WebElement errorMessageWhenEmptyEmail2;
	@FindBy(css = "div[data-autotest-id^='mr-error-the-email-or-password-you-entered-is-incorrect']")
	private WebElement errorMessageWhenIncorrectEmailOrPassword;


	@FindBy(xpath = "//div[contains(@class, 'signup__error-item')]")
	private WebElement errorMessageWhenEmptyEmail;

	@FindBy(css = "div[data-autotest-id='mr-error-please-enter-your-password.-1']")
	private WebElement errorMessageWhenEmptyPassword;


	public LoginPage() {
	}

	public void open() {

		this.driver.get(URL);

	}

	public LoginPage enterEmail(String email) {

		emailInputElement.sendKeys(email);
		return this;

	}

	//review


	public LoginPage enterPassword(String p) {

		String str;
		passwordInputElement.sendKeys(p);
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

		return waitUntilPageLoaded(errorMessageWhenEmptyEmail).isDisplayed();

	}

	public boolean displayErrorMessageWhenIncorrectEmailOrPassword() {

		try {

			return waitUntilPageLoaded(errorMessageWhenIncorrectEmailOrPassword).isDisplayed();

		} catch (TimeoutException exception) {

			return recaptcha.isDisplayed();

		}

	}

	public DashboardPage submitLogin() {

		DashboardPage d = new DashboardPage();

		clickSignInButton();
		//d = new DashboardPage();
		return d;


	}

	public LoginPage clearInputs() {

		emailInputElement.clear();
		passwordInputElement.clear();
		return this;
		//tram papm pam to check

	}

	/**
		* {@code some code}. bla bla.
		*/
	private void method() {

		System.out.println("div pre .aaa{border: 1px;}");
	}


}


