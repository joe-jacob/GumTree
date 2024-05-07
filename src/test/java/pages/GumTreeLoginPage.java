package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GumTreeLoginPage extends BasePage {
	public WebDriverWait wait;

	public GumTreeLoginPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	@FindBy(xpath = "//a[@class='button button--dark button--bottom-label  e137x0or0 css-1bikcph']")
	WebElement Login_Register;

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	WebElement Privacy_accept;

	@FindBy(xpath = "//div[@class='logo-text gumtree-text-svg hide-fully-to-s']")
	WebElement Gumtree_Homepage;

	@FindBy(xpath = "//a[@class='is-open']")
	WebElement LoginClick;

	@FindBy(xpath = "//input[@id='email']")
	WebElement LoginEmail;

	@FindBy(xpath = "//input[@id='fld-password']")
	WebElement LoginPassword;

	@FindBy(xpath = "//button[@class='btn-primary btn-full-width is-gtp-2992']")
	WebElement LoginBTN;

	@FindBy(xpath = "//ul[@class='error-messages']")
	WebElement ErrorMsg;

	@FindBy(xpath = "//h2[@class='manage-ads-greeting']")
	WebElement LoginVerification;

	@FindBy(xpath = "//a[@class='header-button header-link']")
	WebElement MenuBTN;

	@FindBy(xpath = "//button[@type='submit'][1]")
	WebElement LogoutBTN;

	@FindBy(xpath = "//h1[@class='grid-col-12 space-mbxl h-underline-m']")
	WebElement Loggedoutmessage;

	@FindBy(xpath = "//a[@class='header-button header-nav-link']")
	WebElement Login_Regis;

	public void login() {
		try {

			wait.until(ExpectedConditions.visibilityOf(Login_Register));

			// Validation for Login/Register button
			Assert.assertTrue(Login_Register.isEnabled());
			Login_Register.click();

			wait.until(ExpectedConditions.visibilityOf(LoginClick));

			// Validation for Login tab button
			Assert.assertTrue(LoginClick.isEnabled());
			LoginClick.click();

			// Entering Email ID
			LoginEmail.sendKeys("freeze180601@gmail.com");

			// Validation for Email ID
			String ActualText = LoginEmail.getAttribute("value");
			Assert.assertEquals(ActualText, "freeze180601@gmail.com", "Text entered is not correct");

			// Entering password
			LoginPassword.sendKeys("Password@123");

			// Validation for password
			String ActText = LoginPassword.getAttribute("value");
			Assert.assertEquals(ActText, "Password@123", "Text entered is not correct");

			wait.until(ExpectedConditions.visibilityOf(LoginBTN));
			// Validation for Login Button
			Assert.assertTrue(LoginBTN.isDisplayed());
			LoginBTN.click();

			// Validation for logged in successfully
			String ActuallText = LoginVerification.getText();
			String ExpectedText = "Hi Aaditya!";
			Assert.assertEquals(ActuallText, ExpectedText, "Invalid Login");

			wait.until(ExpectedConditions.visibilityOf(Gumtree_Homepage));
			Gumtree_Homepage.click();

			// Validation whether homepage is displayed
			Assert.assertTrue(Gumtree_Homepage.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void invalidlogin() {
		try {
			// Validation for Login/Register button
			Assert.assertTrue(Login_Regis.isEnabled());
			Login_Regis.click();

			wait.until(ExpectedConditions.visibilityOf(LoginClick));
			// Validation for Login tab button
			Assert.assertTrue(LoginClick.isEnabled());
			LoginClick.click();

			// Validation for Email ID
			Assert.assertTrue(LoginEmail.isEnabled());

			// Entering Email ID
			LoginEmail.sendKeys("freeze180601@gmail.com");

			// Validation for Email ID
			Assert.assertTrue(LoginPassword.isEnabled());

			// Entering invalid password
			LoginPassword.sendKeys("h");

			// Validation for Login Button
			Assert.assertTrue(LoginBTN.isEnabled());
			LoginBTN.click();

			// Capturing error message and printing in the console
			String errormessage = ErrorMsg.getText();
			System.out.println(errormessage);

			// Validation for error message
			Assert.assertEquals(true, ErrorMsg.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		try {
			// Validation for Menu button
			Assert.assertTrue(MenuBTN.isEnabled());
			MenuBTN.click();

			// Validation for Logout button
			Assert.assertTrue(LogoutBTN.isEnabled());
			LogoutBTN.click();

			wait.until(ExpectedConditions.visibilityOf(Loggedoutmessage));

			// Validation for successfully logged out message and printing it in console
			Assert.assertEquals(true, Loggedoutmessage.isDisplayed());
			String message = Loggedoutmessage.getText();
			System.out.println(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
