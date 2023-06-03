package testCases;
import pageObjects.*;
import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001_AcctRegistration extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	void test_account_registration() throws Exception {
		logger.debug("Application logs...");
		logger.info("*************** TC_001_AcctRegisration started**********");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount");
		hp.clickRegister();
		logger.info("Clicked on Register");
		AcctRegistrationPage arp = new AcctRegistrationPage(driver);
		logger.info("Providing customer data");
		arp.setFirstName(randomeString().toUpperCase());
		
		arp.setLastName(randomeString().toUpperCase());
		arp.setEmail(randomeString() + "@gmail.com");
		arp.setPassword(randomeAlphanumber());
		arp.clickAgreechk();
		arp.clickContinue();
		logger.info("Clicked Continue");
		String act_confmsg = arp.getConfmMsg();
		String exp_confmsg="Your account has been created!";
		//String exp_confmsg="Register Account";
		Assert.assertEquals(act_confmsg, exp_confmsg,"confirmation message differs" );
		
		}catch(Exception e) {
			logger.info("Test Failed");
			Assert.fail("Test failed");
			System.out.println(e.getMessage());
			}
		logger.info("*************** TC_001_AcctRegisration Ended**********");
	}
	
	
}
