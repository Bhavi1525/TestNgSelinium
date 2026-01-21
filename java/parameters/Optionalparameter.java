package parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Optionalparameter {
	
	WebDriver driver;
	@Parameters("browsername")
	@BeforeTest
	public void open(@Optional("chrome") String browsername )
	{
		switch (browsername.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
		driver	=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
		driver	=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
		driver	=new EdgeDriver();
			break;

		default:
			System.out.println("browername is invalid");
			break;
		}
		driver.manage().window().maximize();
	}
	
	@Parameters("Sleeptime")
	@AfterTest
	public void close(Long Sleeptime ) throws InterruptedException {
		
		System.out.println(Sleeptime);
		Thread.sleep(Sleeptime);
		driver.quit();
	}
	
	@Parameters("url")
	@Test
	public void launchapp(String url)
	{
		driver.get(url);
	}
	
	@Test
	public void status()
	{
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Facebook – log in or sign up")) {
			System.out.println("facebook loginpage is displayed");
		} else {
			System.out.println("facebook loginpage should not displayed");
		}
	}
	
	@Parameters({"username","password"})
	@Test
	public void enterlogindetails(String username, String password )
	{
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
	}
	
	@Test
	public void home() {
		String hometitle = driver.getTitle();
		System.out.println(hometitle);
		if (hometitle.equals("(1) Facebook")) {
			System.out.println("homepage is displayed");
		} else {
			System.out.println("homepage is not displayed");
		}
		driver.quit();

	}

	@Test
	public void forget() {
		driver.findElement(By.xpath("//a[text()=\"Forgotten password?\"]")).click();
		driver.quit();
	}}




