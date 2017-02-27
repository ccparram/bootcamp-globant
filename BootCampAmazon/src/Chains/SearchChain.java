package Chains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public void searchProduct(String productName) throws InterruptedException{
		amazonHomePage.setPSP4Category();
		Thread.sleep(3000);
		amazonHomePage.setSearchProduct(productName);
		amazonHomePage.clickOnSearch();
		Thread.sleep(3000);
		amazonResultsPage.sortResultsPriceLowToHigh();
	}
	
	public void chooseProduct(String productName) throws InterruptedException{
		WebElement choosedProduct = amazonResultsPage.getProductTitle(productName);
		while(choosedProduct == null){
			if(amazonResultsPage.nextPage.isEnabled()){
				amazonResultsPage.nextPage.click();
				Thread.sleep(2000);
				choosedProduct = amazonResultsPage.getProductTitle(productName);
			}
			else{
				break;
			}
		}
		choosedProduct.click();
	}
}
