package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExtentReports extentreport = new ExtentReports();
		File file = new File("reports.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		extentreport.attachReporter(sparkreporter);

		extentreport.createTest("Text based Test").log(Status.INFO, "info1").log(Status.INFO, "<b>info2</b>")
				.log(Status.INFO, "<i>info</i>").log(Status.INFO, "<i><b>info</i></b>");

		String xmladata = "<menu id=\"file\" value=\"File\">\r\n" + "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n" + "  </popup>\r\n" + "</menu>";

		String jsondata = "{\"menu\": {\r\n" + "  \"id\": \"file\",\r\n" + "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n" + "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n" + "    ]\r\n" + "  }\r\n" + "}}";

		extentreport.createTest("Xml test based data").info(MarkupHelper.createCodeBlock(xmladata, CodeLanguage.XML));

		extentreport.createTest("json test based").log(Status.INFO,
				MarkupHelper.createCodeBlock(jsondata, CodeLanguage.JSON));

		List<String> adddata = new ArrayList<>();
		adddata.add("bhavani");
		adddata.add("thulasi");
		adddata.add("vaishu");

		Map<String, Integer> mapdata = new HashMap<>();
		mapdata.put("bhavani", 1);
		mapdata.put("thulasi", 2);
		mapdata.put("vaishu", 3);

		Set<String> setdata = mapdata.keySet();
		
		extentreport
		.createTest("list test based")
		.log(Status.INFO, MarkupHelper.createOrderedList(adddata))
		.log(Status.INFO, MarkupHelper.createUnorderedList(adddata));
		
		extentreport
		.createTest("map test based")
		.log(Status.INFO, MarkupHelper.createOrderedList(mapdata))
		.log(Status.INFO, MarkupHelper.createUnorderedList(mapdata));
		
		extentreport
		.createTest("list test based")
		.log(Status.INFO, MarkupHelper.createOrderedList(setdata))
		.log(Status.INFO, MarkupHelper.createUnorderedList(setdata));
		
		extentreport
		.createTest("this is highlighted message")
		.log(Status.INFO, MarkupHelper.createLabel("this is highlighted message",ExtentColor.AMBER));
		
		
		try
		{
			int i=5/0;
			
		}
		catch(Exception e)
		{
			extentreport
			.createTest("this is exception1")
			.fail(e); 
		}
	
		
		 RuntimeException t = new RuntimeException();
		 extentreport
			.createTest("this is exception2")
			.fail(t); 

		extentreport.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

	}

}
