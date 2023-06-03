package pageObjects;
import utilities.UtilityCustomFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcctRegistrationPage extends BasePage {
	WebDriver driver;
	public AcctRegistrationPage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement ele_FirstName;
	
	@FindBy(id="input-lastname")
	WebElement ele_LastName;
	
	@FindBy(name="email")
	WebElement ele_Email;
	
	@FindBy(css="input[name='password']")
	WebElement ele_Password;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement ele_agreechk;
	
	@FindBy(css="button[type='submit']")
	WebElement ele_continue;
	
	//@FindBy(xpath="//main//h1")
	//@FindBy(xpath="//h1[text()='Register Account']")
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement ele_confmsg;
	public void setFirstName(String fname) {
		UtilityCustomFunctions.sendKeys(driver, ele_FirstName, fname);
	}
	public void setLastName(String lname) {
		UtilityCustomFunctions.sendKeys(driver, ele_LastName, lname);
	}
	public void setEmail(String email) {
		UtilityCustomFunctions.sendKeys(driver, ele_Email, email);
	}
	public void setPassword(String pwd) {
		UtilityCustomFunctions.sendKeys(driver, ele_Password, pwd);
		
	}
	public void clickAgreechk() throws Exception {
		UtilityCustomFunctions.doClick(driver, ele_agreechk);
		//ele_agreechk.click();
		
	}
	public void clickContinue() throws Exception{
		UtilityCustomFunctions.doClick(driver, ele_continue);
		//ele_continue.click();
	}
	public String getConfmMsg() throws Exception{
		String strConfmMsg = UtilityCustomFunctions.getValue(driver, ele_confmsg);
		return strConfmMsg;
	}
}
