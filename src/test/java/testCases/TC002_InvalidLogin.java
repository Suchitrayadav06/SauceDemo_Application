package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_InvalidLogin extends BaseClass{
	
	@Test
	public void invalidLogin() {
		LoginPage lp1 = new LoginPage(driver);
		lp1.setUsername(p.getProperty("web.invalidUsername"));
		lp1.setPassword(p.getProperty("web.invalidPassword"));
		lp1.clickLogin();
		
		String actualErrorMessage = lp1.getErrorMessage();
		String expectedErrorMessage = p.getProperty("web.expectedErrorMessage");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		
	}

}
