package Tests;

import org.testng.annotations.Test;

import Chains.SearchTicketChain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
	@Parameters({"originCity", "destinationCity", "departureDate", "returnDate", "passengersNumber"})
	public void searchTicket(String originCity, String destinationCity, String departureDate,
			String returnDate, String passengersNumber) {
		searchTicket.searchTicket(originCity, destinationCity, departureDate, returnDate, passengersNumber);
	}
}
