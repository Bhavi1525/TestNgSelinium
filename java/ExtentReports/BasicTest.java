package ExtentReports;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTest {
	
	public static WebDriver driver;
	public static String screenshotfolder;
	public static ExtentReports extentreport;
	public static ExtentTest extenttest;
	
	@Parameters("browsername")
	@BeforeTest
	public void launchapp(ITestContext contest ,@Optional("chrome") String browsername ) {
		
		switch (browsername.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
		driver	=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
		driver	=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
		driver	=new EdgeDriver();
			break;

		default:
			System.out.println("browername is invalid");
			break;
		}
		driver.manage().window().maximize();
		Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
		String  device =(capabilities.getBrowserName());
		 System.out.println(capabilities.getBrowserVersion());
		 String author=contest.getCurrentXmlTest().getParameter("author");
		extenttest=extentreport.createTest(contest.getName());
		extenttest.assignAuthor(author);
		extenttest.assignDevice(device);
		
	}
	
	@AfterMethod
	public void inject(Method m,ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String Screenshotpath = null;
			Screenshotpath = screenshot(result.getTestContext().getName()+""+ result.getMethod().getMethodName()+".jpg");
			 extenttest.addScreenCaptureFromPath(Screenshotpath);
			 extenttest.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extenttest.pass(m.getName() + "is passed");
		}
	
		extenttest.assignCategory(	m.getAnnotation(Test.class).groups());
	}
	@AfterTest
	public void teardown()
	{
	  driver.quit();
	}
	
	
	@BeforeSuite
	public void intializeextentreports()
	{
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("alltests.html");
		ExtentSparkReporter sparkreporterfailed = new ExtentSparkReporter("failed.html");
		sparkreporterfailed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		sparkreporterfailed.config().setReportName("Failure report");
		extentreport=new ExtentReports();
		extentreport.attachReporter(sparkreporter,sparkreporterfailed);
		
		extentreport.setSystemInfo("OSname", System.getProperty("os.name"));
		extentreport.setSystemInfo("java version", System.getProperty("java.version"));
	}
	
	@AfterSuite
	public void Generateextentreports() throws IOException
	{
		
		extentreport.flush();
		Desktop.getDesktop().browse(new File("alltests.html").toURI());
		Desktop.getDesktop().browse(new File("failed.html").toURI());
	}
	
	
	
	@Test
	public String screenshot(String filename) 
	{
		if(screenshotfolder == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		    screenshotfolder = myDateObj.format(myFormatObj);
		}
		TakesScreenshot takesscreenshot = (TakesScreenshot)driver;
		File sourceFile = takesscreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshot/"+screenshotfolder+"/"+filename);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return filename;
	}

}
