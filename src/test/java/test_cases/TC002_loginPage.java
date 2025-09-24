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
	HomePage hp=new HomePage(driver);
	hp.myAccountButton();
	hp.loginPage();
		
		
	LoginPage lp=new LoginPage(driver);
	lp.EnterEmail("divsingh865@gmail.com");
	lp.EnterPassword("Blacklist");
	lp.ClickLoginBtn();
	
	MyAccountPage mc=new MyAccountPage(driver);
	{
		boolean checkln=mc.MyAccDisplay();
		Assert.assertEquals(checkln, true);
	}
	
	
	
	}
	
}
