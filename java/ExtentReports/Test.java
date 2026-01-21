package ExtentReports;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	 Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
	 System.out.println(capabilities.getBrowserName());
	 System.out.println(capabilities.getBrowserVersion());
	 driver.quit();
	 
	// System.getProperties().list(System.out);
	String osname = System.getProperty("os.name");
	System.out.println(osname);
	String version = System.getProperty("java.version");
	System.out.println(version);
	 

	}

}
