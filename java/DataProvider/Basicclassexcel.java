package DataProvider;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basicclassexcel {
	
	@Test(dataProvider = "getdata",dataProviderClass = ExceldataSupplier.class)
	public void testlogin(String username,String pwd ) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
		String actualtitle = driver.getTitle();
		String expectedtitle = "Facebook";
		assertEquals(actualtitle, expectedtitle);
		Thread.sleep(2100);
		driver.quit();
	}

}
