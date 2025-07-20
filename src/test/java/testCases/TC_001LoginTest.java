package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OHRMLoginPageObjects.OHRM_LogiPage;

public class TC_001LoginTest extends BaseClass {

	@Test
	public void OHRM_loginpage() throws InterruptedException {

		log.info("Login page...");
		OHRM_LogiPage lg = new OHRM_LogiPage(driver);
		log.info("details entered.....");
		lg.setUsername(p.getProperty("userName"));
		lg.setPassword(p.getProperty("password"));
		

		boolean loGo = lg.logoValidation();
		log.info("checking logo is visible are not..");
		Assert.assertTrue(loGo, "Logo is not displayed at page...");
		log.info("logo is displayed successfully...");

		lg.clickLogout();
		log.info("click on logout...");
		log.info("test case1 completed...");

	}

}
