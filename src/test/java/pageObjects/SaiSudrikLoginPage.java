package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.UtilityCustomFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaiSudrikLoginPage extends BasePage{

	public SaiSudrikLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="username")
	WebElement ele_txtUserName;
	
	@FindBy(xpath="//h2[normalize-space()='Login']")
	WebElement ele_LoginHeader;
	
	@FindBy(id="password")
	WebElement ele_txtPassword;
	
	@FindBy(xpath="//button[@name='login']")
	WebElement ele_btnLogin;
	
	public void setUserEmail(String strEmail) {
		UtilityCustomFunctions.sendKeys(driver, ele_txtUserName, strEmail);
	}
	public void setUserPassword(String Pwd) {
		UtilityCustomFunctions.sendKeys(driver, ele_txtPassword, Pwd);
	}
	public void ClickLogin() throws Exception {
		UtilityCustomFunctions.doClick(driver, ele_btnLogin);
	}
	public String getLoginHeader() {
		String strLoginHdr="";
		try {
			strLoginHdr = UtilityCustomFunctions.getValue(driver, ele_LoginHeader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strLoginHdr;
	}
	public boolean isLoginHeaderPresent() {
		try {
		boolean bLoginHdr = ele_LoginHeader.isDisplayed();
		return bLoginHdr;
		}catch(NoSuchElementException e) {
			return false;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
}
