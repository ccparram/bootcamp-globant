package commons;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import commons.utils.MyWait;
import commons.utils.Screenshot;
import commons.utils.WebDriverFactory;


public abstract class BaseTest {
	
	protected static Logger logger = LoggerFactory.getLogger(BaseTest.class);
	protected WebDriver driver;
	protected MyWait myWait;
	
	public BaseTest(){
	}
	
	
	public BaseTest(String browserName, String url){
		this.driver = WebDriverFactory.getWebDriver(browserName);
		logger.info("Opening browser: " + browserName);
		myWait = new MyWait(driver);
		startDriver(url);
	}
	
	
	private void startDriver(String url){
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	@BeforeClass
	abstract protected void setupPages();
	
	
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
