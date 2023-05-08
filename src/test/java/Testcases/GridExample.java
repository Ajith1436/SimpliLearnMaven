package Testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExample {
	@Test	
	public void testgrid() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setBrowserName("chrome");
		
		URL HubURL = new URL("http://192.168.1.40:4444/wd/hub");
		
		WebDriver driver = new RemoteWebDriver(HubURL, capabilities);
		driver.get("https://www.simplilearn.com/");
		driver.quit();
	}

}
