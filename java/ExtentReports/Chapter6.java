package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Chapter6 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExtentReports extentreport = new ExtentReports();
		File file = new File("reports.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		
		
		/*sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("reportname");
		sparkreporter.config().setDocumentTitle("documenttile");
		sparkreporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		sparkreporter.config().setCss(".badge-primary{background-color:#65df76}");
		sparkreporter.config().setJs("document.getElementsByClassName('logo')[0].style.display=\"none\";");*/
		
		//sparkreporter.loadJSONConfig(new File("C:\\Users\\BhavaniMudraboina\\eclipse-workspace\\TestNGselenium\\config\\extent-reports.json"));
		extentreport.attachReporter(sparkreporter);
		
		sparkreporter.loadXMLConfig(new File("C:\\Users\\BhavaniMudraboina\\eclipse-workspace\\TestNGselenium\\config\\extent-reports.xml"));
		
		extentreport
		.createTest("Test1","this is bhavani report")
		.assignAuthor("bhavani")
		.assignCategory("regression")
		.assignDevice("chrome 99")
		.pass("this is passed test");
		
		
		
		extentreport
		.createTest("test2" , "this is thulasi report")
		.assignAuthor("thulasi")
		.assignCategory("sanity")
		.assignDevice("edge")
		.fail("this is failed test");
		
		
		extentreport
		.createTest("test3" , "this is unknown report")
		.assignCategory("smoke")
		.assignDevice("firefox 99")
		.fail("this is failed test");
		
		
		extentreport
		.createTest("test4" , "this is multi report")
		.assignAuthor("bhavani")
		.assignAuthor("thulasi")
		.assignCategory("sanity")
		.assignCategory("smoke")
		.assignDevice("firefox 99")
		.assignDevice("chrome 99")
		.pass("this is passed test");
		
		
		extentreport
		.createTest("test4" ,"this mixing report")
		.assignAuthor("bhavani","thulasi","vaishu")
		.assignCategory("Sanity","regression","smoke")
		.assignDevice("chrome 99","edge","firefox 99")
		.pass("this is passed test");
		
		extentreport
		.createTest("test5" ,"this string report")
		.assignAuthor(new String[] {"bhavani","thulasi"})
		.assignCategory(new String[] {"Sanity","smoke"})
		.assignDevice(new String[] {"chrome 99","edge"})
		.fail("this ia failed test");
		
		

		extentreport.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
	}

}
