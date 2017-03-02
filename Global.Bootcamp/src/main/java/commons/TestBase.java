package commons;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

import commons.utils.Screenshot;
import commons.utils.WebDriverFactory;

public class TestBase {
	
	protected static Logger logger = LoggerFactory.getLogger(TestBase.class);
	protected WebDriver driver;
	
	public TestBase(){
	}
	
	public TestBase(String browserName, String url){
		this.driver = WebDriverFactory.getWebDriver(browserName);
		logger.info("Opening browser: " + browserName);
		startDriver(url);
	}
	
	private void startDriver(String url){
		driver.manage().window().maximize();
		driver.get(url);
	}
	

	@BeforeMethod
	protected void startSession(Method method) throws Exception {
		logger.info("Starting test method: " + method.getName());
	}
	
	@AfterClass
	protected void quitDriver(){
		Screenshot.takeScreenshot(driver, this.getClass().getSimpleName());
		logger.info("Finished: " + this.getClass().getSimpleName());
		driver.quit();
	}

}
