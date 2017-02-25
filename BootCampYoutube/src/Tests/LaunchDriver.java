package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Chains.SearchsChain;
import Pages.YoutubeHomePage;
import Pages.YoutubeResultsPage;

public class LaunchDriver {
	
	private WebDriver driver;
	private YoutubeHomePage youtubeHomePage;
	private YoutubeResultsPage youtubeResultsPage;
	private SearchsChain searchsChain;
	
	public LaunchDriver(){
		System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-linux");
		driver = new FirefoxDriver();
		youtubeHomePage = new YoutubeHomePage(driver);
		youtubeResultsPage = new YoutubeResultsPage(driver);
		searchsChain = new SearchsChain(driver);
	}
	
	// Using YoutubeHomePage and YoutubeResultsPage POM
	@Test
	public void launchDriver() throws InterruptedException{
		
		driver.get("https://youtube.com");
		youtubeHomePage.setSearchVideo("Rodolfo Aicardi");
		youtubeHomePage.clickOnSearch();
		Thread.sleep(3000);
        Assert.assertTrue(youtubeResultsPage.isVideoTwoDisplayed());
	}
	
	@Test
	public void launchDriverB() throws InterruptedException{
		driver.get("https://youtube.com");
		youtubeHomePage.setSearchVideoB("Rodolfo Aicardi");
	}
	
	@Test
	public void launchDriverC() throws InterruptedException{
		driver.get("https://youtube.com");
		youtubeHomePage.setSearchVideoC("Rodolfo Aicardi");
	}
	
	// Using SearchsChain
	@Test
	public void launchDriverD() throws InterruptedException{
		driver.get("https://youtube.com");
		searchsChain.searchAndSelectVideo("rodolfo aicardi", "adonay");
	}

}
