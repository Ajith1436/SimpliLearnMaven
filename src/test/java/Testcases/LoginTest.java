package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void test1() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("sreejaskurup2010@gmail.com", "Anna@2013");

	}

	@Test
	public void Test2() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("sreejaskurup2010@gmail.com", "Anna@2014");
		WebElement error = driver.findElement(By.id("msg_box"));
		String ActualValidationError = error.getText();
		String ExpValidationError = "The email or password you have entered is invalid.";
		Assert.assertEquals(ActualValidationError, ExpValidationError);
	}

	@Test
	public void test4() throws FilloException, InterruptedException {
		Recordset recordset = connection.executeQuery("select * from data where TestName='test4'");
		recordset.next();

		String Username = recordset.getField("UserName");
		String Password = recordset.getField("Password");

		LoginPage login = new LoginPage(driver);
		login.LoginFunction(Username, Password);
	}

}
