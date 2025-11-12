package test_cases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page_object.HomePage;
import page_object.RegistrationPage;
import test_base.BaseClass;

public class TC001_AccountRegistartionTest extends BaseClass {

	
	
	@Test
	public void Verify_Account_RegistartionPage() throws Exception {
		HomePage hm=new HomePage(driver);
		screenShot();
		hm.myAccountButton();
		
		hm.registationButton();
		
		RegistrationPage rp=new RegistrationPage(driver);
		rp.FirstName("koyal"+randomString());
		rp.LastName("Parashar p"+ randomString());
		rp.Email(randomAlphaNumeric()+"@gmail.com");
		rp.Phone(randomNumber());
		
		
		String password= randomAlphaNumeric();
		
		rp.Pwd(password);
		rp.CnfPwd(password);
		
		
		rp.RadioButton();
		rp.CheckBox();
		rp.ContinueButton();
		
		screenShot();
		
		String msgc=rp.GetConfirmMsg();
		Assert.assertEquals(msgc, "Your Account Has Been Created!");
		
		}
	
		
}

