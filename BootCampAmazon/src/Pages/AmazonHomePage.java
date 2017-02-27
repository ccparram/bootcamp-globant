package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomePage {
	
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
	public WebElement psp4Category;
	
	private WebDriver driver;
	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setPSP4Category() throws InterruptedException{
		Actions actions = new Actions(driver);
		actions.moveToElement(menuDepartments);
		actions.moveToElement(subMenuMovieMusicGames);
		actions.moveToElement(subMenuGames);	
		actions.click().build().perform();
		Thread.sleep(2000);
		psp4Category.click();
		
	}
	
	public void setSearchProduct(String product){
		searchBox.sendKeys(product);
	}
	
	public void clickOnSearch(){
		searchButton.click();
	}
}
