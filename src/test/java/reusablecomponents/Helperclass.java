package reusablecomponents;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utility.PropertyClass;

public class Helperclass {
	
public static WebDriver driver;
	

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
	
	public Helperclass() {
		super();
		// TODO Auto-generated constructor stub
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
	

	/**
	 * 
	 * purpose: common method for all the locators
	 */
	public static WebElement locateElement(String locator, String locatorValue) {
		try {
			switch (locator) {
			case ("id"):
				return driver.findElement(By.id(locatorValue));
			case ("link"):
				return driver.findElement(By.linkText(locatorValue));
			case ("xpath"):
				return driver.findElement(By.xpath(locatorValue));
			case ("name"):
				return driver.findElement(By.name(locatorValue));
			case ("class"):
				return driver.findElement(By.className(locatorValue));
			case ("tag"):
				return driver.findElement(By.tagName(locatorValue));
			case ("cssSelector") :
				return driver.findElement(By.cssSelector(locatorValue));
			}
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "The element with locator" + " " + locator + " " + "not found.");
		}
		return null;
	}
	
	
	@AfterSuite
	public void suitePass() {
		System.out.println("Test Suite passed");
	}
}
