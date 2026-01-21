package DataProvider;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeOut {
	
	@Test(timeOut = 2000)
	public void Timeout()
	{
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.quit();
	}

}
