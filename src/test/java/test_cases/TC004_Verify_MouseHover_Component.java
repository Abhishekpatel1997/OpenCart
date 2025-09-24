package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object.ComponentPage;
import test_base.BaseClass;

public class TC004_Verify_MouseHover_Component extends BaseClass{

	@Test
	public void VerifyMouseHover() throws InterruptedException {
		ComponentPage cm=new ComponentPage(driver);
		Thread.sleep(1000);
		cm.hoverAndClickSubmenu();
		
		String confirmComponentText=cm.cnfMonMsg();
		Assert.assertEquals("Monitors", confirmComponentText);
	}
}
