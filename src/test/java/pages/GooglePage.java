package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage {
	public GooglePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//textarea[@class='gLFyf']")
	WebElement searchBox;

	@FindBy(xpath = "//a[@href = 'https://www.gumtree.com/']")
	WebElement gumTreePage;

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	WebElement Privacy_accept;

	public void search() {
		searchBox.clear();
		searchBox.sendKeys("Gum Tree");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();

	}

	public void gumTree() {
		gumTreePage.click();
		Privacy_accept.click();
	}

}
