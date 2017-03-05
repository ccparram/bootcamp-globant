package commons.helpers;

import org.openqa.selenium.WebElement;

public class WorkWithWebElement {
	
	public static boolean containsThisString(WebElement webElement, String keyword){
		
		return webElement.getText().contains(keyword);
	}

}
