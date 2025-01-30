package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.BaseClass;

public class ExtendReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter; // UI of the report
    public ExtentReports extent; // Populate common info on the report
    public ExtentTest test; // Create test cases in the report and update status of test methods
    String repName;
    // This method is called before any test starts
    public void onStart(ITestContext context) {
    	
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	repName = "Test-Report-" + timeStamp + ".html";
        // Specify the path of the report
    
        String reportPath = "C:\\Users\\HP\\eclipse-workspace\\WebsiteTest\\reports\\myReport.html";
        sparkReporter = new ExtentSparkReporter(reportPath + repName);

        // Set configurations for the report
        sparkReporter.config().setDocumentTitle("Automation Report");  // Set document title
        sparkReporter.config().setReportName("Functional Testing");    // Set report name
        sparkReporter.config().setTheme(Theme.STANDARD);                    // Set the theme to dark

        // Initialize ExtentReports and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system information (optional)
        extent.setSystemInfo("Application", "Testing");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Browser Name", "Chrome");
        extent.setSystemInfo("Environment", "QA");
        
        String os = context.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);
        
        String browser = context.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);
        
        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty()) {
        	extent.setSystemInfo("Groups", includedGroups.toString());
        }
        
    }

    // This method is called when a test method succeeds
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName()); // Create a new entry in the report
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS,result.getName()+"got successfully executed" ); // Log success
    }

    
    // This method is called when a test method fails
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName()); // Create a new entry in the report
        test.assignCategory(result.getMethod().getGroups());
        
        test.log(Status.FAIL,result.getName()+ "got failed"); // Log failure
        test.log(Status.INFO,result.getThrowable().getMessage()); // Log the exception cause
        
        try {
        	
        	String impath = new BaseClass().captureScreen(result.getName());
        	test.addScreenCaptureFromPath(impath);
        	
        }
        catch(IOException e1)
        {
        	e1.printStackTrace();
        }
    }

    // This method is called when a test method is skipped
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName()); // Create a new entry in the report
        test.assignCategory(result.getMethod().getGroups());
        
        test.log(Status.SKIP,result.getName()+"got skipped"); // Log skipped test
        test.log(Status.INFO,result.getThrowable().getMessage());
    }

    // This method is called after all tests are finished
    public void onFinish(ITestContext context) {
        extent.flush();  // Write the report to the file
        
        String pathOfExtentReport = System.getProperty("C:\\Users\\HP\\eclipse-workspace\\WebsiteTest\\reports")+"\\reports\\"+repName;
        File extentReport = new File(pathOfExtentReport);
        
        
        try {
        	Desktop.getDesktop().browse(extentReport.toURI());
        	
        }catch(IOException e) {
        	e.printStackTrace();
        	
        }
    }

}
