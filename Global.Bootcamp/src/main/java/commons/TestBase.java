package commons;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import tests.SimpleLauncher;

public class TestBase {
	
	private static Logger logger = LoggerFactory.getLogger(TestBase.class);
	private WebDriver driver;
	
	public TestBase(){
	}
	
	public TestBase(String browser, String url){
		this.driver = WebDriverFactory.getWebDriver(browser);
		startDriver(url);
	}
	
	private void startDriver(String url){
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterClass
	protected void stopDriver(){
		driver.quit();
	}

}
