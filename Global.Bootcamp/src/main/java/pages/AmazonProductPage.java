package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class AmazonProductPage extends BasePage {
	
	@FindBy (id="//*[@id='productTitle']")
	private WebElement productTitle;
	
	public AmazonProductPage(WebDriver driver) {
		super(driver);
	}
}
