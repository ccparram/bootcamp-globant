package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import commons.BasePage;

public class AmazonResultsPage extends BasePage {
	
	@FindBy (id="sort")
	private WebElement sortSelect;
	
	@FindBy (xpath="//*[starts-with(@id, 'result_')]/div/div/div/div[2]/div[2]/div[1]/a/h2")
	private List<WebElement> results;
	
	@FindBy (xpath = "//*[starts-with(@id, 'result_')]/div/div/div/div[2]/div[3]/div[1]/div[2]/a/span/span/span")
	private List<WebElement> resultPrices;
	
	@FindBy (id="pagnNextString")
	private WebElement nextPage;

	
	public AmazonResultsPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void sortResultsPriceLowToHigh(){
		Select sortDropdown = new Select(sortSelect);
		sortDropdown.selectByValue("price-asc-rank");
		myWait.elementToBeClickable(sortSelect);
	}
	
	
	public void chooseProduct(String productName) {
		WebElement choosedProduct = getInResultsProductTitle(productName);
		while(choosedProduct == null){
			if(nextPage.isEnabled()){
				myWait.elementToBeClickableAndClick(nextPage);
				choosedProduct = getInResultsProductTitle(productName);
			}
			else{
				break;
			}
		}
		choosedProduct.click();
	}
	
	
	private WebElement getInResultsProductTitle(String keyword){
		for (WebElement webElement : results) {
			if(webElement.getText().contains(keyword))
				return webElement;
		}
		return null;
	}
	
	
	public boolean isResultSortedPriceLowToHigh(){
		
		if (resultPrices.size() >= 2){
			for (int i = 0; i < resultPrices.size() - 2; i++) {
				try {
				if (Integer.parseInt(resultPrices.get(i).getText()) > Integer.parseInt(resultPrices.get(i+1).getText()))
					return false;
				}
				catch (NumberFormatException e){}
			}
		}
		return true;
	}
}
