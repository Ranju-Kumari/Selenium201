package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import reusablecomponents.Helperclass;
import uistore.HomePageUI;
import utility.Log;
import utility.ScreenShot;

public class HomePage extends Helperclass {
	
	
	public HomePage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static void enterLoginUserName(WebDriver driver, String userName)
	{
		
		String actualUserName ="ranju";
		
		Assert.assertTrue((userName == actualUserName), "username verified");
		
		Helperclass.locateElement("xpath",HomePageUI.username).sendKeys(userName);
		Log.info("Enter Login Name.");
	}


	public static void enterLoginPassword(WebDriver driver, String password)
	{
		String actualPassword = "ranju";
		Assert.assertTrue((password == actualPassword), "password verified");
		
		Helperclass.locateElement("xpath",HomePageUI.password).sendKeys(password);
		Log.info("Enter Login Password.");
	}

	public static void clickLoginSubmit(WebDriver driver) throws InterruptedException
	{
		WebElement element=Helperclass.locateElement("xpath",HomePageUI.password);
		
		element.sendKeys(Keys.ENTER);
	}
	
	public static void loginVerification(WebDriver driver) 
	{
		String url = driver.getCurrentUrl();
		System.out.println("url="+url);
		
		try
		{
			Assert.assertTrue(url.contains("http://newtours.demoaut.com/mercuryreservation.php"));
		}
		catch(AssertionError e){
			
			ScreenShot.getScreenshot(driver,"LogIn");
			
			Log.info("invalid data entered");
			Assert.assertTrue(false,"invalid data entered");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
