package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReorterNG {

	static ExtentReports extent;
	
	
	
	public static ExtentReports getReportObject()
	{
		// ExtentReports , ExtentSparkReporter (Two classes in extent reports
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
	    extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Nitika");
		return extent;
		
	}
}
