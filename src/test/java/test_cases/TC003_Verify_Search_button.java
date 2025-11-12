package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object.HomePage;
import page_object.LoginPage;
import page_object.MyAccountPage;
import test_base.BaseClass;

public class TC003_Verify_Search_button extends BaseClass{
	@Test
	public void Verify_Login_Page() throws Exception 
	{
	HomePage hp=new HomePage(driver);
	hp.myAccountButton();
	hp.loginPage();
		
		
	LoginPage lp=new LoginPage(driver);
	lp.EnterEmail("divsingh865@gmail.com");
	lp.EnterPassword("Blacklist");
	lp.ClickLoginBtn();
	
	Thread.sleep(1000);
	MyAccountPage mc=new MyAccountPage(driver);
	mc.SearchItem("iphoneeapple");
	mc.Searchbtn();
	screenShot();
	
	boolean cnfGetProduct=mc.GetProduct();
	Assert.assertEquals(cnfGetProduct, true);
	
	
	}

}
