package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_ValidLoginTest extends BaseClass{
	@Test
	public void verifyLoginPage() {
		logger.info("Starting LoginTestCase");
		try
		{
		LoginPage lp = new LoginPage(driver);
	
		logger.info("Login info");
		
		lp.setUsername(p.getProperty("web.validUsername"));
		lp.setPassword(p.getProperty("web.validPassword"));
		lp.clickLogin();
		
		logger.info("Validating the expected message");
		String actualURL = driver.getCurrentUrl();
		String expectedURL = p.getProperty("web.expectedURL");
		
		assertEquals(actualURL, expectedURL);
		}
		catch(Exception e)
		{
			logger.error("test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info("Finishing LoginTestCase");
	}
}
