package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;
import commons.utils.MyWait;

public class AmazonHomePage extends BasePage {
	
	@FindBy (id="twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy (xpath=".//*[@id='nav-search']/form/div[2]/div/input")
	public WebElement searchButton;
	
	@FindBy (xpath=".//*[@id='nav-link-shopall']/span[2]")
	public WebElement menuDepartments;
	
	@FindBy (xpath=".//*[@id='nav-flyout-shopAll']/div[2]/span[10]/span")
	public WebElement subMenuMovieMusicGames;
	
	@FindBy (xpath=".//*[@id='nav-flyout-shopAll']/div[3]/div[10]/div/a[9]/span")
	public WebElement subMenuGames;
	
	@FindBy (xpath=".//*[@id='nav-subnav']/a[2]/span[1]")
	public WebElement psp4CategoryButton;
	
	@FindBy (css="#searchDropdownBox option[selected='selected']")
	public WebElement optionSelected;
	
	
	public AmazonHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void setPSP4Category() throws InterruptedException{
		Actions actions = new Actions(driver);
		actions.moveToElement(menuDepartments);
		actions.moveToElement(subMenuMovieMusicGames);
		actions.moveToElement(subMenuGames);	
		actions.click().build().perform();
//		FIXME
//		MyWait.elementToBeClickableAndClick(psp4CategoryButton);
		psp4CategoryButton.click();
	}
	
	public void searchProduct(String product){
		searchBox.sendKeys(product);
		searchButton.click();
}
	
}
