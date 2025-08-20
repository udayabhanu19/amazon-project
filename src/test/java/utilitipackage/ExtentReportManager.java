package utilitipackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import amazontest.BaseClass;




public class ExtentReportManager implements ITestListener{
	public ExtentReports extent;
	public ExtentSparkReporter sparkreport;
	public ExtentTest extenttest;
String repname;
	public void onStart(ITestContext Context) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date = new Date();
		String currentdatetimestamp=df.format(date);
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname = "Test_report-"+timestamp+ ".html";
		extent = new ExtentReports();
		sparkreport = new ExtentSparkReporter("./report/"+repname);
		extent.attachReporter(sparkreport);
		sparkreport.config().setDocumentTitle("Amazon Automation report");
		sparkreport.config().setReportName("End_To_End Testing");
		sparkreport.config().setTheme(Theme.DARK);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub module", "Customers");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environmenet" ,"QA");
		String window = Context.getCurrentXmlTest().getParameter("window");
		extent.setSystemInfo("Operating System", window);
		String browser = Context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		List<String> includeGroups = Context.getCurrentXmlTest().getIncludedGroups();
		if(includeGroups.isEmpty()) {
			extent.setSystemInfo("groups",includeGroups.toString());
	}
	}
	

	public void onTestSuccess(ITestResult result) {
		extenttest = extent.createTest(result.getClass().getName());
		extenttest.assignCategory(result.getMethod().getGroups());
		extenttest.log(Status.PASS,result.getName()+"got sucessfull executed");
	
	}
	public void onTestFailure(ITestResult result) {
		extenttest = extent.createTest(result.getClass().getName());
		extenttest.assignCategory(result.getMethod().getGroups());
		extenttest.log(Status.FAIL, result.getName()+"got failed");
		extenttest.log(Status.FAIL, result.getThrowable().getMessage());
		try {
			String imgpath = new BaseClass().captureScreen(result.getName());
			extenttest.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e1) {
			e1.printStackTrace();
			
		}
		
	}
	public void onFinish(ITestContext context) {
		extent.flush();
		
		
	}
	

}
