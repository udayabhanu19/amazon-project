package amazontest;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectModel.HomePage;

public class AddToCartPackage extends BaseClass {
	@Test
	public void Search_for_phone() {
		HomePage hp = new HomePage(driver);
		hp.searchforphone("iphone 15");
		boolean isselected = hp.selectproduct("Apple iPhone 15 Plus (128 GB) - Pink");
		//Assert.assertTrue(isselected, "product not found");
		//Assert.assertEquals(driver.getTitle(), "Apple iPhone 15 Plus (128 GB) - Pink : Amazon.in");
	}

}
