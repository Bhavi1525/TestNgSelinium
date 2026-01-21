package DataProvider;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider1 {
	
	@Test(dataProvider = "logintest")
	public void TestFacebook(String username,String pwd) throws InterruptedException
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
	
	@DataProvider
	public Object[][] logintest()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="mudraboinabhavani07@gmail.com";
		data[0][1]="Bhavi@1525";
		
		data[1][0]="701311";
		data[1][1]="Bhavai@2515";
		
		return data;
	}

}
