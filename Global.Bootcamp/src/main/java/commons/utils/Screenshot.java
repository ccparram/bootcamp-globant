package commons.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import commons.BaseTest;


public class Screenshot {
	
	private static Logger logger = LoggerFactory.getLogger(BaseTest.class);
	private static String folderName = "screenshots/";
	
	public static void takeScreenshot(WebDriver driver, String screenshotName) {
		
		String screenshotFileName = getTime() + "_" + screenshotName + ".png";
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(folderName + screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Screenshot saved: " + screenshotFileName);
      	}
	
	private static String getTime(){
	    Date today = Calendar.getInstance().getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
	    return formatter.format(today);
	}
	
}
