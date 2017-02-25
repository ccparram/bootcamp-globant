package Chains;

import org.openqa.selenium.WebDriver;

import Pages.YoutubeHomePage;
import Pages.YoutubeResultsPage;

public class SearchsChain {
	
	private YoutubeHomePage youtubeHomePage;
	private YoutubeResultsPage youtubeResultsPage;
	
	private WebDriver driver;
	
	public SearchsChain(WebDriver driver){
		youtubeHomePage = new YoutubeHomePage(driver);
		youtubeResultsPage = new YoutubeResultsPage(driver);
	}
	
	public void searchAndSelectVideo(String nameOfArtist, String nameOfVideo) throws InterruptedException{
		searchVideo(nameOfArtist);
		Thread.sleep(3000);
		youtubeResultsPage.videoTwo.click();
	}
	
	public void searchVideo(String nameOfArtist){
		youtubeHomePage.searchBox.sendKeys(nameOfArtist);
		youtubeHomePage.searchButton.click();
	}

}
