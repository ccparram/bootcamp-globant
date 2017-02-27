package Chains;

import org.openqa.selenium.WebDriver;

import Pages.AmazonHomePage;
import Pages.AmazonResultsPage;

public class SearchChain {
	
	private WebDriver driver;
	private AmazonHomePage amazonHomePage;
	private AmazonResultsPage amazonResultsPage;
	
	public SearchChain(WebDriver driver){
		this.driver = driver;
		amazonHomePage = new AmazonHomePage(driver);
		amazonResultsPage = new AmazonResultsPage(driver);
	}
	
	public void searchProduct(String product) throws InterruptedException{
		amazonHomePage.setPSP4Category();
		Thread.sleep(3000);
		amazonHomePage.setSearchProduct(product);
		amazonHomePage.clickOnSearch();
		Thread.sleep(3000);
		amazonResultsPage.sortResultsPriceLowToHigh();
	}

}
