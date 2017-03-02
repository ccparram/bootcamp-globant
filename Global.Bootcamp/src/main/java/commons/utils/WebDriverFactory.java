package commons.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	 
	 public static WebDriver getWebDriver(String browserString){ 
		 
		 Browser browser;
		 
		 try{
			 browser= Browser.valueOf(browserString);
		 }
		 catch(IllegalArgumentException e){
			 browser = Browser.FIREFOX;
		 }
		 
		 switch (browser) {
		 
		 case FIREFOX:
			 System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-linux");
			 return new FirefoxDriver();
		 case CHROME:
			 System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-linux");
			 return new ChromeDriver();
		 case OPERA:			 
			 System.setProperty("webdriver.opera.driver", "../drivers/operadriver-linux");
			 return new OperaDriver();
		 default:
			 return null;
		 }
	 }	 
}
