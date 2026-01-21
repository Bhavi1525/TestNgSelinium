package Practise;



import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest  {
	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	@BeforeTest
	public void Launchapp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void exit()
	{
		driver.quit();
	}
	
	@Test
	public void screenshot(String filename)
	{
		if(screenshotsSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		    screenshotsSubFolderName = myDateObj.format(myFormatObj);
		}
		TakesScreenshot takesscreenshot = (TakesScreenshot)driver;
		File src = takesscreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+screenshotsSubFolderName+"/"+filename);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
	}


