package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import commons.BasePage;
import commons.utils.MyWait;

public class AmazonResultsPage extends BasePage {
	
	@FindBy (id="sort")
	public WebElement sortSelect;
	
	@FindBy (xpath="//*[starts-with(@id, 'result_')]/div/div/div/div[2]/div[2]/div[1]/a/h2")
	public List<WebElement> results;
	
	@FindBy (id="pagnNextString")
	public WebElement nextPage;
	
	
	public AmazonResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public void sortResultsPriceLowToHigh(){
		Select sortDropdown = new Select(sortSelect);
		sortDropdown.selectByValue("price-asc-rank");
	}
	
	public void chooseProduct(String productName) {
		WebElement choosedProduct = getProductTitle(productName);
		while(choosedProduct == null){
			myWait.elementToBeClickableAndClick(nextPage);
			if(nextPage.isEnabled()){
				nextPage.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				choosedProduct = getProductTitle(productName);
			}
			else{
				break;
			}
		}
		choosedProduct.click();
	}
	
	private WebElement getProductTitle(String keyword){
		for (WebElement webElement : results) {
			myWait.elementToBeVisible(webElement);
			if(webElement.getText().contains(keyword))
				return webElement;
		}
		return null;
	}
	
}
