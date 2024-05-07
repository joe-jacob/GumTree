package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GumtreeHomePage extends BasePage {
	public WebDriverWait wait;
	JavascriptExecutor js;

	public GumtreeHomePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		js = (JavascriptExecutor) driver;

	}

	@FindBy(xpath = "//div[@class='logo-text gumtree-text-svg hide-fully-to-s']")
	WebElement Gumtree_Homepage;

	@FindBy(xpath = "//a[@class= 'button button--dark button--bottom-label  css-zxneje e137x0or0']")
	WebElement loginButton;

	@FindBy(xpath = "//input[@id='q']")
	WebElement searchBar;

	@FindBy(xpath = "//span[text() = 'Cars & Vehicles']")
	WebElement carsVehicles;

	@FindBy(xpath = "//a[@href='/cars-vans-motorbikes/cars']")
	WebElement cars;

	@FindBy(xpath = "//select[@id='select-make']")
	WebElement selectMake;

	@FindBy(xpath = "//option[@value='audi']")
	WebElement selectMakeOption;

	@FindBy(id = "select-model")
	WebElement selectModel;

	@FindBy(id = "select-price-min")
	WebElement selectMinPrice;

	@FindBy(id = "select-price-max")
	WebElement selectMaxPrice;

	@FindBy(name = "header-search-location")
	WebElement locationButton;

	@FindBy(xpath = "//button[contains(text(),'Search Cars')]")
	WebElement searchCarsButton;

	@FindBy(xpath = "//div[@class='css-1de61eh e25keea13']")
	List<WebElement> carDetails;

	@FindBy(xpath = "//a[@href='https://www.gumtree.com/info/life/about-us/']")
	WebElement About_Gumtree;

	@FindBy(xpath = "//div[@class='section-inner']//child::div//div//p")
	WebElement Para1;

	@FindBy(xpath = "//a[@href=\"https://help.gumtree.com/s/basics\"]")
	WebElement FAQ;

	@FindBy(xpath = "//a[@class='header-button header-link']")
	WebElement MenuBTN;

	@FindBy(xpath = "//a[@href=\"https://my.gumtree.com/manage-account/\"]")
	WebElement MyDetails;

	@FindBy(xpath = "//h1[@class='manage-account-name space-mbxs']")
	WebElement FirstNameLastName;

	@FindBy(xpath = "//div[@class='truncate-line']")
	WebElement Login_Email;

	@FindBy(xpath = "//div[@class='css-1de61eh e25keea13']")
	WebElement Laptop;

	@FindBy(xpath = "//div[@class='css-1de61eh e25keea13']")
	List<WebElement> LaptopList;

	@FindBy(xpath = "//h1[@class='css-4rz76v e1pt9h6u5']")
	WebElement LaptopTitle;

	@FindBy(xpath = "//div[@class='css-i2cx2f ew0ql602']")
	WebElement LaptopDescription;

	@FindBy(xpath = "//a[contains( text(), 'View Profile')]")
	WebElement ViewProfileButton;

	@FindBy(xpath = "//p[contains(text(), 'Email address verified')]")
	WebElement EmailVerified;

	@FindBy(xpath = "//a[contains( text(), 'Audi A4')]")
	WebElement CarsVerification;

	@FindBy(xpath = "//button[@class='button button--primary search-button']")
	WebElement SearchBTN;

	@FindBy(xpath = "//div[@class='css-1de61eh e25keea13']")
	WebElement Link;

	@FindBy(xpath = "//button[contains(text(),'Favourite')]")
	WebElement FavBTN;

	@FindBy(xpath = "//button[@class='button button--dark button--bottom-label user-logged-in ec3kjpg0 css-l8y3vs']")
	WebElement FavMenuBTN;

	@FindBy(xpath = "//a[contains(text(), 'Favourites')]")
	WebElement MenuFavsBTN;

	@FindBy(xpath = "//h2[@class='listing-title']")
	WebElement FavsList;

	@FindBy(xpath = "//h2[@class='css-9hen01 ew0ql603']")
	WebElement LaptopVerification;

	public void AboutGumtree() {

		js.executeScript(" window.scrollBy(0,800)", "");

		// Validation for About Gumtree is enabled
		Assert.assertEquals(true, About_Gumtree.isEnabled());
		About_Gumtree.click();
		js.executeScript(" window.scrollBy(0,100)", "");

		wait.until(ExpectedConditions.visibilityOf(Para1));
		// Validation for Paragraph is displayed
		Assert.assertEquals(true, Para1.isDisplayed());

		// Capturing the paragraph and printing it in the console
		String Paragraph = Para1.getText();
		System.out.println(Paragraph);

		driver.navigate().back();
		// Scrolling Up
		js.executeScript(" window.scrollTo(0,0)", "");

	}

	public void MyDetails() {

		js.executeScript(" window.scrollBy(800,0)", "");

		// Validation for Menu Button
		Assert.assertEquals(true, MenuBTN.isEnabled());
		MenuBTN.click();

		// Validation for MyDetails button
		Assert.assertEquals(true, MyDetails.isEnabled());
		MyDetails.click();

		wait.until(ExpectedConditions.visibilityOf(FirstNameLastName));

		// Validating and printing the First and Last name in the console
		Assert.assertEquals(true, FirstNameLastName.isEnabled());
		String Name = FirstNameLastName.getText();
		System.out.println(Name);

		// Validating and printing the successfully logged in message in the console
		Assert.assertEquals(true, Login_Email.isDisplayed());
		String email = Login_Email.getText();
		System.out.println(email);

	}

	public void HomePageVerification() {
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		String expTitle = "Gumtree | Free classified ads from the #1 classifieds site in the UK";
		Assert.assertEquals(expTitle, actTitle, "Incorrect Page");
	}

	public void search() throws InterruptedException {

		String value = searchBar.getAttribute("value");
		if (value != null) {
			int valLen = value.length();
			for (int i = 0; i < valLen; i++) {
				searchBar.sendKeys(Keys.BACK_SPACE);
			}
		}
		searchBar.sendKeys("Laptop");
		// Assert.assertEquals(true, searchBar.isDisplayed());
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void LaptopDetails() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(" window.scrollBy(0,400)", "");
		Laptop.click();
		// Assert.assertEquals(true, Laptop.isEnabled());
		String expResult = LaptopVerification.getText();
		String actResult = "Description";
		Assert.assertEquals(expResult, actResult, "Incorrect Page");
		System.out.println(LaptopTitle.getText());
		System.out.println(LaptopDescription.getText());
	}

	public void carVehicles() {
		Actions act = new Actions(driver);
		act.moveToElement(carsVehicles).build().perform();
		act.click(cars).perform();
	}

//	public void selectFilter() throws InterruptedException {
//		selectMake.click();
//		Thread.sleep(1000);
//		selectMakeOption.click();
//		Thread.sleep(3000);
//		Select make = new Select(selectMake);
//		make.selectByIndex(7);
//		Thread.sleep(3000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("document.getElementById('select-make').selectedIndex = 7;");
//		
//		selectModel.click();
//		Select model = new Select(selectModel);
//		model.selectByVisibleText("A4");
//		selectMinPrice.click();
//		Select minPrice = new Select(selectMinPrice);
//		minPrice.selectByValue("5000");
//		selectMaxPrice.click();
//		Select maxPrice = new Select(selectMaxPrice);
//		maxPrice.selectByValue("7000");	
//		searchCarsButton.click();
//	}

	public void selectFilterActionClass() throws InterruptedException {
		Actions act = new Actions(driver);
		act.click(selectMake).build().perform();
//		act.click(selectMakeOption).build().perform();
		for (int i = 0; i < 7; i++) {
			act.sendKeys(Keys.ARROW_DOWN).perform();
		}
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		act.click(selectModel).build().perform();
		for (int i = 0; i < 8; i++) {
			act.sendKeys(Keys.ARROW_DOWN).perform();
		}
		act.sendKeys(Keys.ENTER).perform();

		act.click(selectMinPrice).build().perform();
		for (int i = 0; i < 10; i++) {
			act.sendKeys(Keys.ARROW_DOWN).perform();
		}
		act.sendKeys(Keys.ENTER).perform();

		act.click(selectMaxPrice).build().perform();
		for (int i = 0; i < 15; i++) {
			act.sendKeys(Keys.ARROW_DOWN).perform();
		}
		act.sendKeys(Keys.ENTER).perform();
		searchCarsButton.click();
	}

	public void viewProfile() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(" window.scrollBy(0,800)", "");
		Laptop.click();
		ViewProfileButton.click();
		String expResult = EmailVerified.getText();
		String actResult = "Email address verified";
		Assert.assertEquals(actResult, expResult, "Incorrect Page");
		if (EmailVerified.isDisplayed()) {
			System.out.println("Email address verified");
		}
		;

	}

	public void Favorite() {
		// Gumtree_Homepage.click();
		wait.until(ExpectedConditions.visibilityOf(searchBar));

		// Validation for Search button is enabled
		Assert.assertTrue(searchBar.isEnabled());

		// Entering required product in search bar
		searchBar.sendKeys("Laptop");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();

		js.executeScript(" window.scrollBy(0,700)", "");

		wait.until(ExpectedConditions.visibilityOf(Link));

		// Validation whether product link is enabled
		Assert.assertTrue(Link.isEnabled());
		Link.click();

		wait.until(ExpectedConditions.visibilityOf(FavBTN));

		// Validation for Favourite button
		Assert.assertTrue(FavBTN.isEnabled());
		FavBTN.click();

		act.click(FavMenuBTN).build().perform();

		wait.until(ExpectedConditions.visibilityOf(MenuFavsBTN));

		// Validation for Menu button
		Assert.assertTrue(MenuFavsBTN.isEnabled());
		MenuFavsBTN.click();

		// Validating and printing the favourite list
		Assert.assertEquals(true, FavsList.isDisplayed());
		String FavouriteList = FavsList.getText();
		System.out.println(FavouriteList);

	}

//	public void TopCities() {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript(" window.scrollBy(0,5500)","");		
//		for(WebElement top : Top_Cities) {
//			System.out.println(top.getText());
//			Assert.assertEquals(true, top.isDisplayed());
//		}
//		
//	}

	public void printCarResults() {
		Assert.assertEquals("Audi A4", CarsVerification.getText(), "Incorrect Page");
		for (int i = 0; i < 10; i++) {
			System.out.println(carDetails.get(i).getText());
			System.out.println("");
		}

	}

	public void printLaptopResults() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(" window.scrollBy(0,400)", "");
		for (int i = 0; i < 10; i++) {
			System.out.println(LaptopList.get(i).getText());
			System.out.println("");
		}
		String actTitle = driver.getTitle();
		String expTitle = "Laptop for Sale | Laptops | Gumtree";
		Assert.assertEquals(expTitle, actTitle, "Incorrect Page");
	}
}
