package pages;

//Author : Joe Jacob
//Date of creation: 22/04/2024
//Last modified: 23/04/2024

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	//Setup page factory
	public BasePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
