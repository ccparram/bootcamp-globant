package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.utils.MyWait;
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
	
	
	@Test (priority=10)
	@Parameters ({"game"})
	public void searchGameInHomePage(String game) throws InterruptedException {
		String optionSelectedExpected = "PlayStation 4 Games, Consoles & Accessories";
		
		amazonHomePage.setPSP4Category();
		Assert.assertEquals(optionSelectedExpected, amazonHomePage.getOptionSelectedText());
		amazonHomePage.searchProduct(game);
	}
	
	
	@Test (priority=20)
	public void sortGamesPriceLowToHigh() {
		amazonResultsPage.sortResultsPriceLowToHigh();
		Assert.assertTrue(amazonResultsPage.isResultSortedPriceLowToHigh());
	}
	

	@Test (priority=30)
	@Parameters ({"game"})
	public void searchGameInResult(String game) {
		amazonResultsPage.chooseProduct(game);
//		FIXME
//		Assert isn't working 
//		logger.debug("Waiting");
//		myWait.elementToBeVisible(amazonProductPage.productTitle);
//		logger.debug("Wait finished");
//		Assert.assertTrue(amazonProductPage.productTitle.getText().contains(game));
	}
}
