package page_object;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement inputEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement inputPassword;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	@FindBy(tagName="a") List<WebElement> allLinks;
	
	public void EnterEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void EnterPassword(String pass) {
		inputPassword.sendKeys(pass);
	}
	
	public void ClickLoginBtn() {
		loginbtn.click();
	}
	
	public void sizeOfLink() {
		System.out.println(allLinks.size());
	}
	
	public List<WebElement> getAllLinks(){
		return allLinks;
	}
	/*public void printAllLink() {
		for(WebElement link: allLink) {
			String linkText=link.getText();
			String linkUrl=link.getAttribute("href");
			System.out.println("Link Text: " + linkText + " | URL: " + linkUrl);
		}
	}*/

}
