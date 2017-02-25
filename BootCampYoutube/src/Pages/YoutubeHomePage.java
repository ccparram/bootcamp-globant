package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubeHomePage {
	
	@FindBy(id="masthead-search-term")
	public WebElement searchBox;
	
	@FindBy(id="search-btn")
	public WebElement searchButton;
	
	public WebDriver driver;
	
	public YoutubeHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchVideo(String videoName){
		searchBox.sendKeys(videoName);
	}
	
	public void clickOnSearch(){
		searchButton.click();
	}
	
	
	public void setSearchVideoB(String videoName){
		searchBox.sendKeys(videoName);
		clickOnSearchB();
	}
	
	private void clickOnSearchB(){
		searchButton.click();
	}
	
	public void setSearchVideoC(String videoName){
		searchBox.sendKeys(videoName);
		searchButton.click();
	}
	
	
	public YoutubeHomePage setSearchVideoD(String videoName){
		searchBox.sendKeys(videoName);
		return this;
	}
	
	public YoutubeHomePage clickOnSearchD(){
		searchButton.click();
		return this;
	}
	
	
}
