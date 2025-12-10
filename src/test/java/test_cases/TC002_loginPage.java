package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object.HomePage;
import page_object.LoginPage;
import page_object.MyAccountPage;
import test_base.BaseClass;

public class TC002_loginPage extends BaseClass {

	@Test
	public void Verify_Login_Page() 
	{
	HomePage hp=new HomePage(getDriver());
	hp.myAccountButton();
	hp.loginPage();
		
		
	LoginPage lp=new LoginPage(getDriver());
	lp.EnterEmail("divsingh865@gmail.com");
	lp.EnterPassword("Blacklist");
	lp.ClickLoginBtn();
	
	MyAccountPage mc=new MyAccountPage(getDriver());
	{
		boolean checkln=mc.MyAccDisplay();
		Assert.assertEquals(checkln, true);
	}
	
	
	
	}
	
}
