package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class Chapter8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExtentReports extentreport = new ExtentReports();
		File file = new File("reports.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		
		sparkreporter.viewConfigurer().viewOrder().as(new ViewName[] {
				ViewName.TEST,
				ViewName.EXCEPTION,
				ViewName.CATEGORY,
				ViewName.DEVICE,
				ViewName.DASHBOARD
				
		}).apply();
		
		
		extentreport.attachReporter(sparkreporter);
		
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
		
		RuntimeException t = new RuntimeException();
		 extentreport
			.createTest("this is exception2")
			.fail(t); 

		
		

		extentreport.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
	}

}
