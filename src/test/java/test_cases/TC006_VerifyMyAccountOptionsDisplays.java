package test_cases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object.HomePage;
import page_object.LoginPage;
import page_object.MyAccountOptionsDisplay;
import test_base.BaseClass;

public class TC006_VerifyMyAccountOptionsDisplays extends BaseClass{

	@Test
	public void verifyOptions() throws Exception {
		HomePage hpp=new HomePage(driver);
		hpp.myAccountButton();
		hpp.loginPage();
		LoginPage lpp=new LoginPage(driver);
		lpp.EnterEmail("divsingh865@gmail.com");
		lpp.EnterPassword("Blacklist");
		lpp.ClickLoginBtn();
		
		MyAccountOptionsDisplay mcp=new MyAccountOptionsDisplay(driver);
		mcp.sizeOfOptions();
		screenShot();
		Assert.assertEquals(4, 4);
		screenShot();
		mcp.optionPrint();
		List<String> Ao=mcp.actualOptions();
		List<String> expectedList = Arrays.asList(
		                "Edit your account information",
		                "Change your password",
		                "Modify your address book entries",
		                "Modify your wish list"
		        );
		Assert.assertEquals(Ao, expectedList);
		
	}
	
}
