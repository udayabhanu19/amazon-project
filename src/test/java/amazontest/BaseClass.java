package amazontest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	static WebDriver driver;
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	public  static String captureScreen(String tname) {
		System.out.println("took the ss successfully");
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takesscreenshot = (TakesScreenshot)driver;
		File sourcefile= takesscreenshot.getScreenshotAs(OutputType.FILE);
		String targetfilepath = System.getProperty("user.dir")+"/screenshot/"+tname+"-"+ timestamp+".png";
		File targetfile=new File(targetfilepath);
		sourcefile.renameTo(targetfile);
		return targetfilepath;
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
