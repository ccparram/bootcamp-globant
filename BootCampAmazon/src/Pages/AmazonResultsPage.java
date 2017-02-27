package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonResultsPage {
	
	@FindBy (id="sort")
	public WebElement sortSelect;
	
	@FindBy (xpath="//*[starts-with(@id, 'result_')]/div/div/div/div[2]/div[2]/div[1]/a/h2")
	public WebElement[] results;
	
	public WebDriver driver;
	
	public AmazonResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sortResultsPriceLowToHigh(){
		Select sortDropdown = new Select(sortSelect);
		sortDropdown.selectByValue("price-asc-rank");
	}
}
