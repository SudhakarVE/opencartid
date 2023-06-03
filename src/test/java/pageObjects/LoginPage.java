package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.UtilityCustomFunctions;

public class LoginPage extends BasePage {

	WebDriver driver;
	public LoginPage (WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(name="email")
	WebElement ele_email;
	
	@FindBy(id="input-password")
	WebElement ele_pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement ele_btnLogin;
	
	public void setEmail(String stremail) throws Exception {
		UtilityCustomFunctions.sendKeys(driver, ele_email, stremail);
	}
	public void setPwd(String strpwd) throws Exception {
		UtilityCustomFunctions.sendKeys(driver, ele_pwd,strpwd);
	}
	public void clickLogin() throws Exception {
		//UtilityCustomFunctions.doClick(driver, ele_btnLogin);
		ele_btnLogin.click();
	}
	
	
	
	
}
