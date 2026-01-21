package Assertions;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assertion {
	
	@Test
	public void TestGoogle() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String Actualtitle = driver.getTitle();
		String Expectedtitle = "Google";
	assertEquals(Actualtitle, Expectedtitle, "title is missmathed");
		Thread.sleep(2000);
		driver.quit();
		
		
	}
	
	@Test
	
	public void TestFacebook() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys("mudraboinabhavani07@gmail.com", Keys.ENTER);
		String actualtitle = driver.getTitle();
		String Expectedtitle = "Facebook";
		assertEquals(actualtitle, Expectedtitle, "Titlemissmatched");
		Thread.sleep(1000);
		driver.quit();
	}
	

}
