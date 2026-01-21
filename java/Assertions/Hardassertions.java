package Assertions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hardassertions {

	@Test
	public void TestGoogle() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String Actualtitle = driver.getTitle();
		String Expectedtitle = "Google1";
	assertEquals(Actualtitle, Expectedtitle, "title is missmathed");
		Thread.sleep(2000);
		driver.quit();
		
		
	}
}

//hardassertions is an assertion which throughs exception immediately upon afailureof assertions.
//after thourhs an remaining code will not execute .hardassertions coming from assertclass