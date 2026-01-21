package DataProvider;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parallelexecution {
	
	@Test(dataProvider = "Parallel")
	public void TestLogin(String username,String pwd  ) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
		String actualtitle = driver.getTitle();
		String expectedtitle = "Log in to Facebook";
		assertEquals(actualtitle, expectedtitle);
		Thread.sleep(2100);
		driver.quit();
	}
	
	@DataProvider(parallel = true)
	public Object[][] Parallel()
	{
		Object[][] data = new Object[6][2];
		
		data[0][0]="mudraboinabhavani07@gmail.com";
		data[0][1]="Bhavi@1525";
		
		data[1][0]="mudraboina@gmail.com";
		data[1][1]="Bhavi@1525";
		
		data[2][0]="thulasi";
		data[2][1]="Bhavi@1525";
		
		data[3][0]="thulasi";
		data[3][1]="Bhavi@1525";
		
		data[4][0]="thulasi";
		data[4][1]="Bhavi@1525";
		
		data[5][0]="thulasi";
		data[5][1]="Bhavi@1525";
		return data;
	}

}
