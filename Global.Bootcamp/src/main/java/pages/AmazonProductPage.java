package pages;

import static commons.helpers.WorkWithWebElement.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class AmazonProductPage extends BasePage {
	
	@FindBy (xpath="//*[@id='productTitle']")
	private WebElement productTitle;
	
	public AmazonProductPage(WebDriver driver) {
		super(driver);
	}


	public boolean isProductNameInTitle(String productName){
		return containsThisString(productTitle, productName);
	}
	
	public WebElement getProductTitle() {
		return productTitle;
	}
	
}
