package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	WebDriver driver;

	@Test
	public void launchapp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
	}

	@Test
	public void status() {
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Facebook – log in or sign up")) {
			System.out.println("facebook loginpage is displayed");
		} else {
			System.out.println("facebook loginpage should not displayed");
		}
	}

	@Test
	public void enterlogindetails() {
		driver.findElement(By.name("email")).sendKeys("7013116891");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Bhavi@1525");
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
	}
}
