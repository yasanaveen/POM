package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OHRMLoginPageObjects.OHRM_LogiPage;

public class TC_001LoginTest extends BaseClass {

	@Test
	public void OHRM_loginpage() throws InterruptedException, IOException {

		log.info("Login page...");
		OHRM_LogiPage lg = new OHRM_LogiPage(driver);

		// URL validation

		if (driver.getTitle().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			log.info("Login page title is verified successfully...");
		} else {
			Thread.sleep(2000);
			captureScreen(driver, "OHRM_loginpage");
			Assert.assertTrue(false);
			log.info("Login page title is not verified...");
		}

		log.info("details entered.....");
		Thread.sleep(2000);
		lg.setUsername(p.getProperty("userName"));
		lg.setPassword(p.getProperty("password"));

		boolean loGo = lg.logoValidation();
		log.info("checking logo is visible are not..");
		Assert.assertTrue(loGo, "Logo is not displayed at page...");
		Assert.assertEquals(loGo, true, "Logo is not displayed at page...");
		log.info("logo is displayed successfully...");

//		if (loGo) {
//			log.info("logo is displayed successfully...");
//			Assert.assertTrue(true);
//		} else {
//			captureScreen(driver, "OHRM_loginpage");
//			log.error("logo is not displayed at page...");
//			Assert.fail("logo is not displayed at page...");
//		}

		lg.clickLogout();
		log.info("click on logout...");
		log.info("test case1 completed...");

	}

}
