package pageObjects;
import utilities.UtilityCustomFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver){
		super(driver);
		//this.driver = driver;
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement ele_MyAcct;
	
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement ele_Register;
	
	@FindBy(linkText="Login")
	WebElement ele_LoginLnk;
	
	//Action methods
	public void clickMyAccount() throws Exception {
		UtilityCustomFunctions.doClick(driver, ele_MyAcct);
	}
	
	public void clickRegister() throws Exception {
		UtilityCustomFunctions.doClick(driver, ele_Register);
	}
	public void clickLoginLnk() throws Exception{
		UtilityCustomFunctions.doClick(driver, ele_LoginLnk);
	}
	
}
