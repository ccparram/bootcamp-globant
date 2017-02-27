package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Chains.SearchChain;

public class SearchProduct {
	
	private WebDriver driver;
	private SearchChain searchChain;
	
	private String PRODUCT_NAME = "Resident Evil 7";
	
	public SearchProduct(){
		System.setProperty("webdriver.gecko.driver", "../drivers/chromedriver-linux");
		driver = new FirefoxDriver();
		searchChain = new SearchChain(driver);
	}
	
	@BeforeClass
	public void getBrowser(){
		driver.get("https://amazon.com");
	}
	
	@Test
	public void searchProduct() throws InterruptedException {
		searchChain.searchProduct(PRODUCT_NAME);
		Thread.sleep(3000);
		searchChain.chooseProduct(PRODUCT_NAME);
	}
}
