package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import commons.utils.MyWait;

public abstract class BasePage {
	
	protected static Logger logger = LoggerFactory.getLogger(BasePage.class);
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
