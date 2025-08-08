package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.OHRMLoginPageObjects.OHRM_LogiPage;

public class TC_003LoginTest_DDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = utilities.DataProviders.class)
	public void LogiTest_DDT(String username, String password, String exp) throws InterruptedException, IOException {
		log.info("Tc3 started...");

		OHRM_LogiPage lg = new OHRM_LogiPage(driver);
		lg.setUsername(username);
		log.info("username entered..");
		lg.setPassword(password);
		log.info("password  entered..");

		lg.clickLogout();

		log.info("Tc3 completed...");
		
		
		

	}

}
