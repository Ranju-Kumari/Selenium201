package execution;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import reusablecomponents.Helperclass;
import utility.PropertyClass;
import utility.ScreenShot;

public class TestScriptOne extends Helperclass{
	
public TestScriptOne() {
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
		HomePage.loginVerification(driver);
		Log.info("Logged in successfully");
		
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@BeforeSuite
	public void propertyLoad() {
		
	}
	
	/**
	 * purpose: To open browser
	 * 
	 */
	@BeforeClass
	public static WebDriver openBrowser() {

		String path = PropertyClass.getFromPropertyFile("DRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}
	

	/**
	 * purpose: to navigate to the url
	 * @param driver
	 */
	public static void navigateToApplication(WebDriver driver) {
		String value = null;
		value = PropertyClass.getFromPropertyFile("URL");
		driver.get(value);
	}
	

	
	
	@AfterSuite
	public void suitePass() {
		System.out.println("Test Suite passed");
	}
}
