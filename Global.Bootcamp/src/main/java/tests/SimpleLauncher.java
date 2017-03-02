package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.TestBase;

public class SimpleLauncher extends TestBase {
	
	@Parameters ({"browser", "url"})
	public SimpleLauncher(String browser, String url){
		super(browser, url);
	}
	
	@Test
	public void launcher(){
		
	}
}
