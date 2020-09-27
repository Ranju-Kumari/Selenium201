package execution;

import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import reusablecomponents.Helperclass;

public class TestScriptTwo {
	public TestScriptTwo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static  WebDriver driver;
	/**
	 * driver setup
	 */
	@BeforeTest
	public static void asetUp() {
		driver = Helperclass.openBrowser();
		Helperclass.navigateToApplication(driver);
		Log.info("Navigated to the application");
	}
	
	@Test(priority = 0)
	public static void logIn()
	{
		HomePage.enterLoginUserName(driver, "ranju");
		HomePage.enterLoginPassword(driver, "ranju");
		try {
			HomePage.clickLoginSubmit(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	@Test(priority = 1)
	public static void bookReturnTicket()
	{
	
	driver.findElement(By.xpath("//input[@name='findFlights']")).click();
	
	
	driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
	
	
	
	driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys("Ranju");
	
	driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys("kumari");
	
	driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
	

	}
}
