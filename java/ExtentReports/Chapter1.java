package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExtentReports extentreport = new ExtentReports();
		File file = new File("reports.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		extentreport.attachReporter(sparkreporter);
		
		ExtentTest test1 = extentreport.createTest("Test1");
		test1.pass("this is passed");
		
		ExtentTest test2 = extentreport.createTest("Test2");
		test2.log(Status.FAIL, "this is failed");
		
		extentreport.createTest("test3").skip("this is skipped");
		

		extentreport.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
	}

}
