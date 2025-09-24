package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']") WebElement lynMyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lynRegistration;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lynLogin;
	
	public void myAccountButton() {
		lynMyAccount.click();
	}
	
	public void registationButton() {
		lynRegistration.click();
	}
	
	public void loginPage() {
		lynLogin.click();
	}
	

}
