package Chains;

import org.openqa.selenium.WebDriver;

import Pages.AmazonHomePage;

public class SearchChain {
	
	private WebDriver driver;
	private AmazonHomePage amazonHomePage;
	
	public SearchChain(WebDriver driver){
		this.driver = driver;
		amazonHomePage = new AmazonHomePage(driver);
		
	}
	
	public void searchProduct(String product) throws InterruptedException{
		amazonHomePage.setSearchProduct(product);
		amazonHomePage.clickOnSearch();
		Thread.sleep(3000);
		amazonHomePage.sortResultsPriceLowToHigh();
	}

}
