package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement userFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement userLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement userEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement userTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement userPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement userConfirmPassword;
	@FindBy(xpath="//input[@value='0']") WebElement radioBtn;
	@FindBy(xpath="//input[@name='agree']") WebElement checkBox;
	@FindBy(xpath="//input[@value='Continue']") WebElement continueBtn;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confmsg;
	
	public void FirstName(String firstname) {
		userFirstName.sendKeys(firstname);
	}
	
	public void LastName(String lastname) {
		userLastName.sendKeys(lastname);
	}
	
	public void Email(String email) {
		userEmail.sendKeys(email);
	}
	
	public void Phone(String teleno) {
		userTelephone.sendKeys(teleno);
	}
	
	public void Pwd(String pwd) {
		userPassword.sendKeys(pwd);
	}
	
	public void CnfPwd(String pwd) {
		userConfirmPassword.sendKeys(pwd);
	}
	
	public void RadioButton() {
		radioBtn.click();
	}
	
	public void CheckBox() {
		checkBox.click();
	}
	
	public void ContinueButton() {
		continueBtn.click();
	}
	
	public String GetConfirmMsg() {
		try {
			return (confmsg.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	

	
}
