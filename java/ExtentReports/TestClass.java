package ExtentReports;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestClass extends BasicTest{
	
	@Test(testName="TestGoogle",groups={"Smoke"})
	public void TestGoogle() throws InterruptedException
	{
		driver.get("https://www.google.com/");
		extenttest.info("navigate to url");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
		extenttest.info("entererd test in search box");
		String expectedTitle = "HYR Tutorials - Google Search";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle, "Title is mismatched");
		extenttest.pass("assertion is passed");
		
	     
	}
	
	@Test(testName="Assertions",groups={"regression,Sanity"})
	public void Assertions() throws InterruptedException
	{
		
		SoftAssert softaasert = new SoftAssert();
		driver.get("https://www.facebook.com");
		extenttest.info("navigate to url");
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
		
		softaasert.assertAll();
	}
	
	@Test(testName="TestFacebook",groups={"functional"})
	public void TestFacebook() throws InterruptedException{
			driver.get("https://opensource-demo.orangehrmlive.com/");
			extenttest.info("navigate to url");
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
			driver.findElement(By.id("btnLogin")).click();
			assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
	
		
	}

}
