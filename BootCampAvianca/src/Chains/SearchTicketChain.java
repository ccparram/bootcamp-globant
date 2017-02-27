package Chains;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Pages.AviancaHomePage;

public class SearchTicketChain {
	
	private AviancaHomePage aviancaHomePage;
	
	public SearchTicketChain(WebDriver driver){
		aviancaHomePage = new AviancaHomePage(driver);				
	}
	
	public void searchTicket(String originCity, String destinationCity, String departureDate,
							String returnDate, String passengersNumber){
		
		aviancaHomePage.departureAndReturnOptionButton.click();
		aviancaHomePage.setOriginCity(originCity);
		aviancaHomePage.originCity.sendKeys(Keys.ENTER);
		aviancaHomePage.setDestinationCity(destinationCity);
		aviancaHomePage.destinationCity.sendKeys(Keys.ENTER);
		aviancaHomePage.setDepartureDate(departureDate);
		aviancaHomePage.setReturnDate(returnDate);
		aviancaHomePage.setPassengersNumber(passengersNumber);
		aviancaHomePage.searchButton.click();
	}

}
