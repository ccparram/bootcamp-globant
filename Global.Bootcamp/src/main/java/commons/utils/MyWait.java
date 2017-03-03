package commons.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWait {
	
	private static WebDriverWait wait;
	private static int waitTime = 10;
	
	public MyWait(WebDriver driver){
		 wait = new WebDriverWait(driver, waitTime);
	}
	
	public void elementToBeVisible(WebElement webElement){
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void elementToBeClickable(WebElement webElement){
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	
	public void elementToBeClickableAndClick(WebElement webElement){
		elementToBeClickable(webElement);
		webElement.click();
	}
	
	public void cickAndWaitForElementToBeVisible(WebElement webElementClick, WebElement webElementWait){
		webElementClick.click();
		elementToBeVisible(webElementWait);
	}
	
	public void cickAndWaitForElementToBeClickableAndClick(WebElement webElementClick, WebElement webElementWaited){
		webElementClick.click();
		elementToBeClickable(webElementWaited);
		webElementWaited.click();
	}

}
