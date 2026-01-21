package invocationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class invocationtimeout {
	
	
	@Test(invocationCount = 3,invocationTimeOut = 10000)
	public void testmethod1() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		System.out.println("User name: " + driver.findElement(By.id("user_value")).getText());

		driver.findElement(By.xpath("//li[@data-label='email']")).click();
		System.out.println("Email address: " + driver.findElement(By.id("user_value")).getText());
		driver.quit();

	}

}
