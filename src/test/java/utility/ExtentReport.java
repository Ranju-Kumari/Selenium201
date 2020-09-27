package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * 
 * @author M1049070
 *
 */
public class ExtentReport extends TestListenerAdapter
{
	public ExtentReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());//time stamp
	public static String repName="Test-Report-"+timeStamp+".html";
    public static String path=System.getProperty("user.dir")+ "/ExtentReports/"+repName;
    static int i=0;
	/**
	 * method will be called when ever the testng starts executing	
	 */
	public void onStart(ITestContext testContext)
	{
		
		htmlReporter=new ExtentHtmlReporter(path);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","DEMOAUT");
		
		htmlReporter.config().setDocumentTitle("DEMOAUT"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	/**
	 * method will be called when ever test is pass
	 */
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); 
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); 
	}
	/**
	 * method will be executed when ever the test is fail
	 */
	public void onTestFailure(ITestResult tr)
	{
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		logger=extent.createTest(tr.getName()); 
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); 
		logger.log(Status.FAIL,"Test failed because"+" "+tr.getThrowable());
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+dateName+((i++))+".png";
	    System.out.println(screenshotPath);
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		
	}
	/**
	 * method will be called when ever the test is skipped
	 */
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	/**
	 * function to be called on the end of the testng execution to flush the extent report and send the path to the email function
	 */
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
		SendMail.mailTrigering();
	}
}