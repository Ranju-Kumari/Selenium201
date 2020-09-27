package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public ScreenShot() {
		super();
		// TODO Auto-generated constructor stub
	}
	static int i=0;
	/**
	 * function is called when ever we need to attach screen shot in the extent report
	 * @param driver
	 * @param TestName
	 */
	public static void getScreenshot(WebDriver driver,String TestName) 
	{
		
		System.out.println("inside method");
		String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String DestFile = System.getProperty("user.dir")+"/Screenshots/"+TestName+dateName+((i++))+".png";
		File Destination  =new File(DestFile);
		try {
			FileUtils.copyFile(srcFile,Destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


}
