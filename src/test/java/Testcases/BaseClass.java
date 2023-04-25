package Testcases;

import org.testng.annotations.AfterTest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	Fillo fillo;
	Connection connection;

	@BeforeTest
	public void Reportsetup() throws FilloException {
		report = new ExtentReports("ExtendReports.html");
		fillo = new Fillo();
		connection = fillo.getConnection("DataSheet.xlsx");
	}

	@BeforeMethod
	public void setup(Method method) {
		// step-1 : Launch chrome browser and open simplilearn website

		WebDriverManager.chromedriver().setup();
		test = report.startTest(method.getName());
		test.log(LogStatus.INFO, "Test shoul be started", "test case started successfully");
		// WebDriverManager.edgedriver().setup();
		// WebDriverManager.firefoxdriver().setup();
		// this.driver = new EdgeDriver();
		// this.driver = new FirefoxDriver();
		this.driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		// step-2: Maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	}

	@AfterMethod
	public void teardown() {
		report.endTest(test);
		driver.quit();

	}

	@AfterTest
	public void ReportClean() {
		report.flush();
		report.close();

	}
}
