package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "user-name")
	WebElement txtUsername;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(id = "login-button")
	WebElement btnLogin;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errorMsg;
	

	public void setUsername(String Uname) {
		txtUsername.sendKeys(Uname);
	}

	public void setPassword(String Pwd) {
		txtPassword.sendKeys(Pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	public String getErrorMessage() {
		return errorMsg.getText();
	}
	
	

}
