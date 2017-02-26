package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomePage {
	
	@FindBy (id="twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy (xpath=".//*[@id='nav-search']/form/div[2]/div/input")
	public WebElement searchButton;
	
	@FindBy (id="sort")
	public WebElement sortSelect;
	
	
	private WebDriver driver;
	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchProduct(String product){
		searchBox.sendKeys(product);
	}
	
	public void clickOnSearch(){
		searchButton.click();
	}
	
	public void sortResultsPriceLowToHigh(){
		Select sortDropdown = new Select(sortSelect);
		sortSelect.click();
		sortDropdown.selectByValue("price-asc-rank");
	}

	
	
}
