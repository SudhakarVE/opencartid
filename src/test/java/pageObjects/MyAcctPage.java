package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcctPage extends BasePage{

	public MyAcctPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Account']")
	WebElement mnu_account;
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement mnu_myAcct;
	
	public boolean IsMnuAcctDisplayed() {
		boolean mnu_acct_status = mnu_account.isDisplayed();
		return mnu_acct_status;
	}
	public boolean IsMnuMyAcctDisplayed() {
		boolean mnu_myacct_status = mnu_myAcct.isDisplayed();
		return mnu_myacct_status;
	}

}
