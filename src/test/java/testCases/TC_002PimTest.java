package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OHRMLoginPageObjects.HomePage_Objects;
import com.OHRMLoginPageObjects.OHRM_LogiPage;

public class TC_002PimTest extends BaseClass {

	@Test
	void PIMTest() throws InterruptedException

	{
		OHRM_LogiPage lg = new OHRM_LogiPage(driver);
		lg.setUsername(p.getProperty("userName"));
		log.info("username entered..");
		lg.setPassword(p.getProperty("password"));
		log.info("password  entered..");
		log.info("clicked on login button....");

		// Assert.fail("Login failed");

		HomePage_Objects hm = new HomePage_Objects(driver);
		Thread.sleep(2000);
		hm.clcikOn_pimBtn();
		log.info("clicked on PIM button...");
		hm.btn_add();
		Thread.sleep(2000);
		hm.enterdetails("naveen", "yasa");

		Thread.sleep(2000);
		// hm.clickLogout();
		lg.clickLogout();
		log.info("clicked on logout...");
		

		log.info("Finished testcase...");

	}

}
