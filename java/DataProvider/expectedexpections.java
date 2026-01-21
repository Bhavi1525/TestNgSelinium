package DataProvider;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class expectedexpections {

	@Test(expectedExceptions = {NoSuchElementException.class})
	public void expection()
	{
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("abd")).click();
		driver.quit();
	}
}
