package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver Pagedriver;

	// ===========Objects========================//

	@FindBy(linkText = "Log in")
	WebElement LoginLink;

	@FindBy(name = "user_login")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(className = "rememberMe")
	WebElement rememberCheckbox;

	@FindBy(name = "btn_login")
	WebElement LoginClick;

	// ======================Methods====================//

	public LoginPage(WebDriver driver) {
		Pagedriver = driver;
		PageFactory.initElements(Pagedriver, this);

	}

	public void LoginFunction(String UserNameVal, String PasswordVal) throws InterruptedException {

		LoginLink.click();
		username.sendKeys(UserNameVal);
		password.sendKeys(PasswordVal);
		rememberCheckbox.click();
		LoginClick.click();
		Thread.sleep(3000);

	}

}
