package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	
	@Test
	public void TestGoogle() throws Throwable
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("laptops" , Keys.ENTER);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(1000);
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
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		driver.quit();
	}
}
