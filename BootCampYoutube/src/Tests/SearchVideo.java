package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SearchVideo {
	
	private final String SONG_NAME = "Bohemian Rhapsody";
	private final String KEYWORD = "lyrics";
	private final String EMAIL = "kmiloparra@gmail.com";
	private final String PASSWORD = "bootcamp2017";
	
	private WebDriver driver;
	
	private WebElement searchBox;
	private WebElement searchButton;
	private WebElement filterButton;
	private List<WebElement> videoTitlesPerPage;
	
	public SearchVideo(){
		System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-linux");
		driver = new FirefoxDriver();
	}
	
	// Login, Search video, click in video with keyword in title and like
	@Test
	public void searchVideoAndLike() throws InterruptedException{
		
		driver.get("https://youtube.com");
		Thread.sleep(3000);
		
		login(EMAIL, PASSWORD);
		searchVideo(SONG_NAME, KEYWORD);
		clickLike();
	}

	private void searchVideo(String SONG_NAME, String KEYWORD) throws InterruptedException {
		
		searchBox = driver.findElement(By.id("masthead-search-term"));
		searchBox.sendKeys(SONG_NAME);

		searchButton = driver.findElement(By.id("search-btn"));
		searchButton.click();
		Thread.sleep(3000);
		
		videoTitlesPerPage = driver.findElements(By.xpath(".//*[@id='results']/ol/li[2]/ol/li/div/div/div[2]/h3"));
		iterateTitles(videoTitlesPerPage);
		Thread.sleep(3000);
	}
	
	private void iterateTitles(List<WebElement> webElements){
		
		for (WebElement videoTitle : webElements) {
			if (videoTitle.getText().contains(KEYWORD)){
				videoTitle.click();
				System.out.println(videoTitle.getText());
				break;
			}
		}
	}
	
	private void login(String email, String password) throws InterruptedException{
		
		WebElement loginButton;
		WebElement emailBox;
		WebElement passwordBox;
		WebElement nextButton;
		WebElement signInButton;
		
		loginButton = driver.findElement(By.xpath(".//*[@id='yt-masthead-signin']/div/button"));
		loginButton.click();
		Thread.sleep(3000);
		
		emailBox = driver.findElement(By.id("Email"));
		emailBox.sendKeys(email);
		
		nextButton = driver.findElement(By.id("next"));
		nextButton.click();
		Thread.sleep(3000);
		
		passwordBox = driver.findElement(By.id("Passwd"));
		passwordBox.sendKeys(password);
		
		signInButton = driver.findElement(By.id("signIn"));
		signInButton.click();
		Thread.sleep(4000);
	}
	
	private void clickLike(){
		
		WebElement likeButton = driver.findElement(By.xpath(".//*[@id='watch8-sentiment-actions']/span/span[1]/button"));
		likeButton.click();
	}
}
