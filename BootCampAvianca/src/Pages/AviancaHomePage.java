package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AviancaHomePage {
	
	
	@FindBy (id="ctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_rbIdaRegreso")
	public WebElement departureAndReturnOptionButton;
	
	
	@FindBy (id="idctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_ddlCiudadOrigenBooking")
	public WebElement originCity;
	
	@FindBy (id="idctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_ddlCiudadDestinoBooking")
	public WebElement destinationCity;
	
	@FindBy (id="ctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_txtFechaIda")
	public WebElement departureDate;
	
	@FindBy (id="ctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_txtFechaRegreso")
	public WebElement returnDate;
	
	@FindBy (id="ctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_ddlAdultos")
	public WebElement adultsPassengersNumber;
	
	@FindBy (id="ctl00_g_c1b9b0ad_83b8_4ff7_abbb_170c4e8795d0_ctl00_booking_BtnGuardar")
	public WebElement searchButton;
	
	private WebDriver driver;
	
	public AviancaHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setOriginCity(String originCity) {
		this.originCity.sendKeys(originCity);
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity.sendKeys(destinationCity);
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate.sendKeys(departureDate);
	}

	public void setReturnDate(String returnDate) {
		this.returnDate.sendKeys(returnDate);
	}

	public void setPassengersNumber(String passengersNumber) {
		Select passengerNumber = new Select(adultsPassengersNumber);
		passengerNumber.selectByValue(passengersNumber);
		
	}
		

}
