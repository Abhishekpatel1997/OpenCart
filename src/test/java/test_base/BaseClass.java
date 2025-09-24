package test_base;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void SetUp(String br) {
		
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "edge" : driver=new EdgeDriver();break;
		case "firefox" : driver=new FirefoxDriver();break;
		default : System.out.println("This is invalid browser"); return;
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void Tearup() {
		driver.quit();
	}
	
	public String randomString() {
		String generateString=RandomStringUtils.randomAlphabetic(6);
		return generateString;	
	}
	
	public String randomNumber() {
		String generateString=RandomStringUtils.randomNumeric(10);
		return generateString;	
	}
	
	public String randomAlphaNumeric() {
		String generateAlph=RandomStringUtils.randomAlphabetic(5);
		String generateNum=RandomStringUtils.randomNumeric(5);
		return (generateAlph +generateNum);
	}
	
}
