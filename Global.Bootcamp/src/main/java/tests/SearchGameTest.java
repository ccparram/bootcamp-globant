package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import pages.AmazonHomePage;
import pages.AmazonProductPage;
import pages.AmazonResultsPage;

public class SearchGameTest extends BaseTest {
	
	private AmazonHomePage amazonHomePage;
	private AmazonResultsPage amazonResultsPage;
	private AmazonProductPage amazonProductPage;

	
	@Parameters ({"browser", "url"})
	public SearchGameTest(String browser, String url){
		super(browser, url);
	}
	
	
	@BeforeClass
	@Override
	public void setupPages() {
		amazonHomePage = new AmazonHomePage(driver);
		amazonResultsPage = new AmazonResultsPage(driver);
		amazonProductPage = new AmazonProductPage(driver);
	}
	
	
	@Test
	@Parameters ({"game"})
	public void searchGameInHomePage(String game) throws InterruptedException {
		String optionSelectedExpected = "PlayStation 4 Games, Consoles & Accessories";
		
		amazonHomePage.setPSP4Category();
		Assert.assertEquals(optionSelectedExpected, amazonHomePage.getOptionSelectedText());
		amazonHomePage.searchProduct(game);
		
		amazonResultsPage.sortResultsPriceLowToHigh();
		Assert.assertTrue(amazonResultsPage.isResultSortedPriceLowToHigh());
		
		amazonResultsPage.chooseProduct(game);
		myWait.elementToBeVisible(amazonProductPage.getProductTitle());
		Assert.assertTrue(amazonProductPage.isProductNameInTitle(game));
	}
}
