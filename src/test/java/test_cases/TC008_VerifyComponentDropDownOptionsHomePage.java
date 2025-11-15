package test_cases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object.ComponentDropDown;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.MenuOptions;
import page_object.MyAccountOptionsDisplay;
import test_base.BaseClass;

public class TC008_VerifyComponentDropDownOptionsHomePage extends BaseClass{

	@Test
	public void verifyOptions() throws Exception {
		HomePage hpp=new HomePage(driver);
		hpp.myAccountButton();
		hpp.loginPage();
		LoginPage lpp=new LoginPage(driver);
		lpp.EnterEmail("divsingh865@gmail.com");
		lpp.EnterPassword("Blacklist");
		lpp.ClickLoginBtn();
		
		ComponentDropDown cdd=new ComponentDropDown(driver);
		cdd.clickOnComponent();
		Thread.sleep(10);
		cdd.sizeOfMonitorDropDown();
		Thread.sleep(10);
		cdd.printComponentDropDownOption();
		Thread.sleep(10);
		cdd.clickOnMonitor();
		Thread.sleep(10);
		String msgCheck=cdd.getValidationMsg();
		Assert.assertEquals(msgCheck, "Monitors");
		
	}
	
}
