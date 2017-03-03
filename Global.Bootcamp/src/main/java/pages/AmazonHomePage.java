package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;
import commons.utils.MyWait;

public class AmazonHomePage extends BasePage {
	
	@FindBy (id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy (xpath=".//*[@id='nav-search']/form/div[2]/div/input")
	private WebElement searchButton;
	
	@FindBy (xpath=".//*[@id='nav-link-shopall']/span[2]")
	private WebElement menuDepartments;
	
	@FindBy (xpath=".//*[@id='nav-flyout-shopAll']/div[2]/span[10]/span")
	private WebElement subMenuMovieMusicGames;
	
	@FindBy (xpath=".//*[@id='nav-flyout-shopAll']/div[3]/div[10]/div/a[9]/span")
	private WebElement subMenuGames;
	
	@FindBy (xpath=".//*[@id='nav-subnav']/a[2]/span[1]")
	private WebElement psp4CategoryButton;
	
	@FindBy (css="#searchDropdownBox option[selected='selected']")
	private WebElement optionSelected;
	
	
	public AmazonHomePage(WebDriver driver) {
		super(driver);
	}
	
	
	public void setPSP4Category() throws InterruptedException{
		Actions actions = new Actions(driver);
		actions.moveToElement(menuDepartments);
		actions.moveToElement(subMenuMovieMusicGames);
		actions.moveToElement(subMenuGames);	
		actions.click().build().perform();
		myWait.elementToBeClickableAndClick(psp4CategoryButton);
		myWait.elementToBeVisible(optionSelected);
	}
	
	
	public void searchProduct(String product){
		searchBox.sendKeys(product);
		searchButton.click();
	}
	

	public String getOptionSelectedText() {
		return optionSelected.getText();
	}
	
}
