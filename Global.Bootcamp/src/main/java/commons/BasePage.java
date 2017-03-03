package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commons.utils.MyWait;

public class BasePage {
	
	protected WebDriver driver;
	protected MyWait myWait;
	
	public BasePage(){
	}
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		myWait = new MyWait(driver);
		PageFactory.initElements(driver, this);
	}

}
