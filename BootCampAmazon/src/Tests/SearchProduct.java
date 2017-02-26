package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Chains.SearchChain;

public class SearchProduct {
	
	private WebDriver driver;
	private SearchChain searchChain;
	
	private String PRODUCT = "Resident Evil 7 playstation 4";
	
	public SearchProduct(){
		System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-linux");
		driver = new FirefoxDriver();
		searchChain = new SearchChain(driver);
	}
	
	@BeforeClass
	public void getBrowser(){
		driver.get("https://amazon.com");
	}
	
	@Test
	public void searchProduct() throws InterruptedException {
		searchChain.searchProduct(PRODUCT);
	}
}
