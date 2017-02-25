package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubeResultsPage {
	
	@FindBy(xpath=".//*[@id='results']/ol/li[2]/ol/li/div/div/div[2]/h3/a")
	public WebElement videoTwo;

	private WebDriver driver;
	
	public YoutubeResultsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isVideoTwoDisplayed(){
    	return videoTwo.isDisplayed();
    }
}
