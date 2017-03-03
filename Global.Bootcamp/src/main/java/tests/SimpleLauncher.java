package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class SimpleLauncher extends BaseTest {
	
	@Parameters ({"browser", "url"})
	public SimpleLauncher(String browser, String url){
		super(browser, url);
	}
	
	@Test
	public void launcher(){
		
	}

	@BeforeClass
	@Override
	protected void setupPages() {
	}


}
