package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.UtilityCustomFunctions;

public class SaiSudrikMyAcctPage extends BasePage{

	public SaiSudrikMyAcctPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h3[@class='elementor-heading-title elementor-size-default']")
	WebElement ele_msgWelcome;
	
	@FindBy(xpath="//ul[@id='menu-main-menu']//li[@id='menu-item-552']//a")
	WebElement ele_myAcctLink;
	
	@FindBy(linkText="Log out")
	WebElement ele_LogoutLink;
	
	//@FindBy(xpath="//div[@class='subbox']//li[@class='my-account-logout']/a[1]")
	@FindBy(linkText="Logout")
	WebElement ele_Logout_link;
	
	@FindBy(linkText="Dashboard")
	WebElement ele_DashBoard_Link;
	
	public void clickMyAcctMenu() throws Exception {
		//UtilityCustomFunctions.doClick(driver, ele_btnLogin);
		ele_myAcctLink.click();
	}
	public void clickLogout() {
		ele_LogoutLink.click();
	}
	public void clickLogoutfromSubBox()
	{
		ele_Logout_link.click();
	}
	public boolean isDashBoardPresent() {
		try {
			boolean isDashbrd = ele_DashBoard_Link.isDisplayed(); 
		return isDashbrd;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	public boolean isLogoutLinkPresent() {
		return ele_Logout_link.isDisplayed();
	}
	public String getWelcomeMsg() {
		String strRetMsg="";
		
		try {
			strRetMsg = UtilityCustomFunctions.getValue(driver, ele_msgWelcome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strRetMsg;
	}
}
