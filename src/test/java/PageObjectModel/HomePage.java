package PageObjectModel;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbar;
	@FindBy(xpath = "//a[contains(@class, 's-line-clamp-2')]")
	List<WebElement> listofproducts;

	public void searchforphone(String ph) {
		waitVisibilityOfElement(searchbar);
		searchbar.clear();
		searchbar.sendKeys(ph, Keys.ENTER);
	}

	public boolean selectproduct(String productname) {
		int productlist = listofproducts.size();
		if (productlist > 0) {

			for (WebElement products : listofproducts) {
				waitVisibilityOfElement(products);
				//scrollElement(products);
				//listofproducts.get(2).click();
				String product = products.getText().trim();
				if (product.contains(productname)) {
					scrollElement(products);
					 waitElementToBeclickable(products);
					 
					products.click();

					return true;
				}
			}
		}
		return false;

	}

}
