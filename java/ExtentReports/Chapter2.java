package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 ExtentReports extentreports = new ExtentReports();
		File file = new File("reports.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		extentreports.attachReporter(sparkreporter);
		
		extentreports
		.createTest("test1")
		.log(Status.INFO, "info")
		.log(Status.INFO, "info")
		.log(Status.PASS, "pass")
		.log(Status.PASS, "pass")
		.log(Status.SKIP, "skipped")
		.log(Status.SKIP, "skipped")
		.log(Status.WARNING, "warning")
		.log(Status.WARNING, "warning")
		.log(Status.INFO, "info")
		.log(Status.INFO, "info");
	
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

	}

}
