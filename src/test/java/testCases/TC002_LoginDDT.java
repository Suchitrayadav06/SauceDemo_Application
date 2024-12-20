package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid - login success - test pass - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail - logout
Data is invalid -- login failed - test pass
*/

public class TC002_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // getting data providers from different class
																				
	public void verify_loginDDT(String username, String password, String res) {
		logger.info("********Starting TC002_loginDDT*******");
		try {
			HomePage hp = new HomePage(driver);

			LoginPage lp = new LoginPage(driver);
			lp.setUsername(username);
			lp.setPassword(password);
			lp.clickLogin();

			String actualURL = driver.getCurrentUrl();
			String expectedURL = p.getProperty("web.expectedURL");

			if (res.equalsIgnoreCase("Valid")) {
				if (expectedURL == actualURL) {
					hp.clickOpenMenu();
					hp.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (res.equalsIgnoreCase("Invalid")) {
				if (expectedURL == actualURL) {
					hp.clickOpenMenu();
					hp.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("********Finished TC002_loginDDT*******");
	}
}