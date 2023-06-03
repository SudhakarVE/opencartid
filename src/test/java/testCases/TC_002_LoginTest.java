package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.*;
import pageObjects.*;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	void login_test()  {
		logger.info("*********** TC_002_LoginTest Started ******************");
		
		HomePage hp = new HomePage (driver);
		LoginPage lp = new LoginPage(driver);
		MyAcctPage Myp = new MyAcctPage(driver);
		SoftAssert sa = new SoftAssert();
		try {
			hp.clickMyAccount();
			logger.info("My Account Link clicked");
			hp.clickLoginLnk();
			logger.info("Login Link clicked");
			
			lp.setEmail(rb.getString("email"));
			logger.info("Email Entered");
			
			lp.setPwd(rb.getString("password"));
			logger.info("Password Entered");
			
			lp.clickLogin();
			logger.info("Clicked Login");
			
			boolean isMnuTitleAcct = Myp.IsMnuAcctDisplayed();
			sa.assertEquals(isMnuTitleAcct, true);
			logger.info("Account Title Validation completed");
			try {
			boolean isMnuMyAcctHdr = Myp.IsMnuMyAcctDisplayed();
			sa.assertEquals(isMnuMyAcctHdr, true);
			}
			catch(Exception e) {
				Assert.fail("Menu My Account not found");
			}
			logger.info("My Account Header validation completed");
			
			logger.info("**************** TC_002_LoginTest Completed***************");
			sa.assertAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
