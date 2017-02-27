package Tests;

import org.testng.annotations.Test;

import Chains.SearchTicketChain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class SearchTicket {
	
	private WebDriver driver;
	private SearchTicketChain searchTicket;
  
	public SearchTicket() {
		System.setProperty("webdriver.gecko.driver", "../drivers/chromedriver-linux");
		driver = new ChromeDriver();
		searchTicket = new SearchTicketChain(driver);
	} 
	
	@BeforeTest
	public void beforeTest() {
		driver.get("http://www.avianca.com/es-co");
	}
	
	@Test
	public void searchTicket() {
		searchTicket.searchTicket("Medellín", "Cancún", "15/03/2017", "25/03/2017", "5");
	}
}
