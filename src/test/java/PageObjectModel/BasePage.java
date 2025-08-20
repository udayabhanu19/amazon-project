package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	public void waitElementToBeclickable(WebElement ele) {
		
		wait.until(ExpectedConditions.elementToBeClickable( ele));
		
	}
public void waitVisibilityOfElement(WebElement ele) {
		
		wait.until(ExpectedConditions.visibilityOf( ele));
		
	}
	
	public void scrollElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}


}
