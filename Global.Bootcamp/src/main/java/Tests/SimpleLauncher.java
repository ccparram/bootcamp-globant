package Tests;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common.WebDriverFactory;

public class SimpleLauncher {
	
	WebDriver driver;

	@Parameters ({"browser"})
	public SimpleLauncher(String browser){
		this.driver = WebDriverFactory.getWebDriver(browser);
	}
	
	@Test
	public void launcher(String browser){
		Logger logger = LoggerFactory.getLogger(SimpleLauncher.class);
		driver.get("https://google.com");
	}
}
