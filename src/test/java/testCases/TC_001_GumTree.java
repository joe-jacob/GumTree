package testCases;

//Author: Joe Jacob, Aaditya V
//Date of creation: 24/04/2024
//Last modified: 07/05/2024

import org.testng.annotations.Test;

//import pages.GumTreeLinks;
import pages.GumTreeLoginPage;
import pages.GumtreeHomePage;

public class TC_001_GumTree extends BaseClass {

	//Author: Aaditya V
	@Test(priority = 1)
	public void login() {
		GumTreeLoginPage lp = new GumTreeLoginPage(driver);
		lp.login();
		GumtreeHomePage hp = new GumtreeHomePage(driver);
		hp.HomePageVerification();
	}
	
	//Author: Joe Jacob
	@Test(priority = 2)
	public void getCarDetails() throws InterruptedException {
		GumtreeHomePage hp = new GumtreeHomePage(driver);
		hp.HomePageVerification();
		Thread.sleep(3000);
		hp.carVehicles();
		Thread.sleep(3000);
		hp.selectFilterActionClass();
		hp.printCarResults();
	}

	//Author: Joe Jacob
	@Test(priority = 3)
	public void adSearch() throws InterruptedException {
		GumtreeHomePage hp = new GumtreeHomePage(driver);
		hp.search();
		hp.printLaptopResults();
	}
	
	//Author: Joe Jacob
	@Test(priority = 4)
	public void adDetails() throws InterruptedException {
		GumtreeHomePage hp = new GumtreeHomePage(driver);
		hp.search();
		hp.LaptopDetails();
	}

	//Author: Joe Jacob
	@Test(priority = 5)
	public void profileVerification() throws InterruptedException {
		GumtreeHomePage hp = new GumtreeHomePage(driver);
		hp.search();
		hp.viewProfile();
	}
	
	//Author: Aaditya V
	@Test(priority = 6)
	public void favouriteAds() throws InterruptedException {
		GumtreeHomePage hp = new GumtreeHomePage(driver);
		hp.Favorite();
	}
	
	//Author: Aaditya V
	@Test(priority = 7)
	public void MyDetails() {
		GumtreeHomePage hp = new GumtreeHomePage(driver);
		hp.MyDetails();
	}
	
	//Author: Aaditya V
	@Test(priority = 8)
	public void AboutGumtree() {
		GumtreeHomePage hp = new GumtreeHomePage(driver);
		hp.AboutGumtree();
	}

	//Author: Aaditya V
	@Test(priority = 9)
	public void logout() {
		GumTreeLoginPage lp = new GumTreeLoginPage(driver);
		lp.logout();
	}

	//Author: Aaditya V
	@Test(priority = 10)
	public void InValidLogin() {
		GumTreeLoginPage lp = new GumTreeLoginPage(driver);
		lp.invalidlogin();
	}

}
