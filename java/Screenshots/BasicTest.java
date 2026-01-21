package Screenshots;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTest {
	
	public static WebDriver driver;
	public static String screenshotfolder;
	@BeforeTest
	public void launchapp() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void inject(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			screenshot(result.getTestContext().getName()+""+ result.getMethod().getMethodName()+".jpg");
		}
	}
	@AfterTest
	public void teardown()
	{
	  driver.quit();
	}
	
	@Test
	public void screenshot(String filename) 
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
	}

}
