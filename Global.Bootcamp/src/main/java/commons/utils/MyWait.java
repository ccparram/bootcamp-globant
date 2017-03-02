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
	
	public static void elementToBeVisible(WebElement webElement){
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public static void elementToBeClickable(WebElement webElement){
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public static void cickAndWaitForElementToBeVisible(WebElement webElementClick, WebElement webElementWait){
		webElementClick.click();
		elementToBeVisible(webElementWait);
	}
	
	public static void cickAndWaitForElementToBeClickable(WebElement webElementClick, WebElement webElementWait){
		webElementClick.click();
		elementToBeClickable(webElementWait);
	}

}
