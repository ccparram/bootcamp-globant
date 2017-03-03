package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.utils.MyWait;
import pages.AmazonHomePage;
import pages.AmazonResultsPage;

public class SearchGameTest extends BaseTest {
	
	AmazonHomePage amazonHomePage;
	AmazonResultsPage amazonResultsPage;
	
	String gameName;
	
	@Parameters ({"browser", "url"})
	public SearchGameTest(String browser, String url){
		super(browser, url);
	}
	
	@BeforeClass
	@Override
	public void setupPages() {
		amazonHomePage = new AmazonHomePage(driver);
		amazonResultsPage = new AmazonResultsPage(driver);
		
	}
	
	@Test (priority=10)
	@Parameters ({"game"})
	public void searchGameInHomePage(String game) throws InterruptedException {
		this.gameName = game;
		
		amazonHomePage.setPSP4Category();
		myWait.elementToBeVisible(amazonHomePage.optionSelected);
		Assert.assertEquals("PlayStation 4 Games, Consoles & Accessories", amazonHomePage.optionSelected.getText());
		amazonHomePage.searchProduct(gameName);
	}
	
	@Test (priority=20)
	public void sortGamesPriceLowToHigh() {
		amazonResultsPage.sortResultsPriceLowToHigh();
	}
/*
	@Test (priority=30)
	@Parameters ({"game"})
	public void searchGameInResult(String game) {
		amazonResultsPage.chooseProduct(game);
	}
*/
	
}
