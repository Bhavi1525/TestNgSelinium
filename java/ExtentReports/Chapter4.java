package ExtentReports;

import static org.testng.Assert.fail;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chapter4 {
	 static WebDriver driver;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		ExtentReports extentreport = new ExtentReports();
		File file = new File("reports.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		extentreport.attachReporter(sparkreporter);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		String base64 = Caputurescreenshot();
		String path = Capturescreenshot("facebook.jpg");
		
		
		extentreport
		.createTest("screenshot image attached1","this is attached screenshot at testlevel")
		.addScreenCaptureFromBase64String(base64);
		
		
		
		extentreport
		.createTest("screenshot image attached2","facebook page is displayed")
		.addScreenCaptureFromBase64String(base64,"facebook1 page is displayed")
		.addScreenCaptureFromBase64String(base64,"facebook2 page is displayed")
        .addScreenCaptureFromBase64String(base64,"facebook3 page is displayed");
	
		
		extentreport
		.createTest("screenshot image attached3","this is attached screenshot at testlevel")
		.addScreenCaptureFromPath(path);
		
		extentreport
		.createTest("screenshot image attached4","facebook page is displayed")
		.addScreenCaptureFromPath(path,"facebookpage1")
		.addScreenCaptureFromPath(path,"facebookpage2")
		.addScreenCaptureFromPath(path,"facebookpage3");
		
		
		extentreport
		.createTest("screenshot image attached5","facebook page is displayed")
		.info("this is info message")
		.fail("this is info message", MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "facebook page").build());
		
		
		extentreport
		.createTest("screenshot image attached6","facebook page is displayed")
		.info("this is info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"google page").build());
		
		Throwable t = new Throwable();
		
		extentreport
		.createTest("screenshot7 attached","log level")
		.info("this is info message7")
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "google page").build());
		
		
		extentreport
		.createTest("screenshot8 attached","log level")
		.info("this is info message8")
		.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path, "google page").build());
		
		extentreport.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
	}
	
	public static String Caputurescreenshot() 
	{
		
		TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
		String base64 = takesscreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved successfully");
		return base64;
	}
	
	
	public static String Capturescreenshot(String filename)
	{
		
		TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
		File sourceFile = takesscreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshot/"+filename);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}

}
