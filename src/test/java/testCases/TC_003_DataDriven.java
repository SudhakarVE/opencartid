package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.SaiSudrikBaseClass;
import utilities.DataProviders;
import pageObjects.*;

public class TC_003_DataDriven extends SaiSudrikBaseClass{

	@Test(dataProvider="LoginData",dataProviderClass = DataProviders.class)
	//@Test
	void test_Login_DDT(String strEmail,String strPwd,String resFlag) throws Exception {
		try {
		logger.info("**********Login Data Driven Test Started***************");
		
		//Validate Home Page
		
		SaiSudrikMyAcctPage MyAcctPg = new SaiSudrikMyAcctPage(driver);
		/*
		String act_welmsg = MyAcctPg.getWelcomeMsg();
		String exp_welmsg="Welcome to amama's cooking!";
		logger.info("Validation of Welcome Msg in Home Page");
		sa.assertEquals(act_welmsg, exp_welmsg);*/
		
		MyAcctPg.clickMyAcctMenu();
		logger.info("My Account Link Clicked");
		
		SaiSudrikLoginPage lp = new SaiSudrikLoginPage(driver);
		logger.info("Validate Login Page Opened or not");
		
		String act_lpheader = lp.getLoginHeader();
		String exp_lpheader = "Login";
		Assert.assertEquals(act_lpheader, exp_lpheader);
		
		lp.setUserEmail(strEmail);
		logger.info("Login Email Entered");
		lp.setUserPassword(strPwd);
		logger.info("Login Password Entered");
		Thread.sleep(500);
		lp.ClickLogin();
		logger.info("Login Button Submitted");
		Thread.sleep(500);
		
		if(resFlag.equals("Valid")) {
			boolean bAct_Dashboard = MyAcctPg.isDashBoardPresent();
			System.out.println("IsDashBoard " + bAct_Dashboard);
			logger.info("dashboard presence " + bAct_Dashboard);
			//boolean bAct_Logout = MyAcctPg.isLogoutLinkPresent();
			if(bAct_Dashboard==true) {
				Assert.assertTrue(true);
				logger.info("Login with "+ strEmail + " successful");
				//Logout from App
				MyAcctPg.clickLogoutfromSubBox();
				logger.info(strEmail +" logout successful");
			}
			else {
				System.out.println("Dashboard false");
				logger.info("Login not successful");
				Assert.fail("Login not successful");
				
			}//inner if
				
		}//if
		else
		{
			if(lp.isLoginHeaderPresent())
			{
				logger.info("Invalid Login "+ strEmail + " Test Success");
				//Assert.assertEquals(lp.getLoginHeader(),"Login");
				Assert.assertTrue(true);
			}
			else
			{
				
				logger.info("Login with Invalid "+ strEmail + " successful");
				//Logout from App
				Assert.fail("Login with Invalid "+ strEmail + " successful");
				if(MyAcctPg.isDashBoardPresent()){
					MyAcctPg.clickLogoutfromSubBox();
				}
				
				
				/*
				boolean bAct_Dashboard = MyAcctPg.isDashBoardPresent();
				//boolean bAct_Logout = MyAcctPg.isLogoutLinkPresent();
				if(bAct_Dashboard==true) {
					Assert.fail("Login with Invalid "+ strEmail + " successful");
					logger.info("Login with Invalid "+ strEmail + " successful");
					//Logout from App
					MyAcctPg.clickLogoutfromSubBox();
				*/	
			} // inner else
		}//else end
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*************** Finished TC_003_DataDrivenTest****************");
	
	}//Test
}//class