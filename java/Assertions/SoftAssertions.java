package Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertions {

	@Test
	public void Facebook() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SoftAssert softaasert = new SoftAssert();
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys("hyr", Keys.ENTER);
		Thread.sleep(1000);

		// title

		String actualtitle = driver.getTitle();
		String expectedtiltle = "Log in to Facebook";
		softaasert.assertEquals(actualtitle, expectedtiltle, "title missmathed");

		// url

		String actualurl = driver.getCurrentUrl();
		String expectedurl = "https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNzY3ODQwOTUyLCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D&next";
		softaasert.assertNotEquals(actualurl, expectedurl, "url is missmathed");

		// text

		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedtext = "";
		softaasert.assertEquals(actualText, expectedtext, "text is missmatched");

		// border
		String actualborder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedborder = "0.666667px solid rgb(240, 40, 73)";
		softaasert.assertEquals(actualborder, expectedborder, "border os missmatched");
		
		//errormsg

		String actualErrorMessage = driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]"))
				.getText();
		String expectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		driver.quit();
		softaasert.assertAll();
	}

}
