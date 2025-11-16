package test_cases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object.HomePage;
import page_object.LoginPage;
import page_object.MenuOptions;
import page_object.MyAccountOptionsDisplay;
import test_base.BaseClass;

public class TC007_VerifyMenuOptionsHomePage extends BaseClass{

	@Test
	public void verifyOptions() throws Exception {
		HomePage hpp=new HomePage(driver);
		hpp.myAccountButton();
		hpp.loginPage();
		LoginPage lpp=new LoginPage(driver);
		lpp.EnterEmail("divsingh865@gmail.com");
		lpp.EnterPassword("Blacklist");
		lpp.ClickLoginBtn();
		
		MenuOptions mo=new MenuOptions(driver);
		mo.sizeMenuOptions();
		Assert.assertEquals(8, 8);
		
		mo.printMenuOptions();
		
		List<String> amo=mo.actualMenuOptions();
		List<String> emo=Arrays.asList(
		"Desktops",
        "Laptops & Notebooks",
        "Components",
        "Tablets",
        "Software",
        "Phones & PDAs",
        "Cameras",
        "MP3 Players"
				);
		Assert.assertEquals(amo, emo);
		
	}
	
}
