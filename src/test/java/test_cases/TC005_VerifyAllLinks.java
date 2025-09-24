package test_cases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object.HomePage;
import page_object.LoginPage;
import page_object.MyAccountPage;
import test_base.BaseClass;

public class TC005_VerifyAllLinks extends BaseClass {

	int validLinks = 0;
    int brokenLinks = 0;
    
	@Test
	public void Verify_Login_Page() throws IOException 
	{
	HomePage hp=new HomePage(driver);
	hp.myAccountButton();
	hp.loginPage();
		
		
	LoginPage lp=new LoginPage(driver);
	lp.EnterEmail("divsingh865@gmail.com");
	lp.EnterPassword("Blacklist");
	lp.ClickLoginBtn();
	
	int totalLinks = lp.getAllLinks().size();
	System.out.println("🔗 Total Links Found: " + totalLinks);
	
	for (int i = 0; i < totalLinks; i++) {
        String url = lp.getAllLinks().get(i).getAttribute("href");
        
        if (url == null || url.isEmpty()) {
            System.out.println("⚠️ Link at index " + i + " is EMPTY or NULL");
            brokenLinks++;
            continue;
        }
        
        if (checkLinkStatus(url)) {
            validLinks++;
        } else {
            brokenLinks++;
        }
        
        System.out.println("✅ Valid Links: " + validLinks);
        System.out.println("❌ Broken Links: " + brokenLinks);

        // Assert: No broken links should be present
        Assert.assertEquals(brokenLinks, 0, "Some broken links are found on the page!");
        
	}
	
	}

	public boolean checkLinkStatus(String linkUrl) throws IOException {
        URL url = new URL(linkUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(5000);
        connection.connect();

        int statusCode = connection.getResponseCode();
        if (statusCode >= 200 && statusCode < 400) {
            System.out.println(linkUrl + " --> ✅ VALID (" + statusCode + ")");
            return true;
        } else {
            System.out.println(linkUrl + " --> ❌ BROKEN (" + statusCode + ")");
            return false;
        }
    }
}
