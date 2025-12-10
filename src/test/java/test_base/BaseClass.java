package test_base;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class BaseClass {

	/* ===================== WebDriver ===================== */
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    /* ===================== Extent Report ===================== */
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    /* ===================== Suite Level ===================== */
    @BeforeSuite
    public void startReport() {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                .format(new Date());

        spark = new ExtentSparkReporter(
                "Reports/AutomationReport_" + timeStamp + ".html");

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Parallel Execution Result");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }

    /* ===================== Test Level ===================== */
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser, Method method) {

        // ✅ Create Extent Test per thread
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);

        // ✅ Browser setup
        switch (browser.toLowerCase()) {
        case "chrome":
            driver.set(new ChromeDriver());
            break;
        case "edge":
            driver.set(new EdgeDriver());
            break;
        case "firefox":
            driver.set(new FirefoxDriver());
            break;
        default:
            throw new RuntimeException("Invalid Browser Name");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        getDriver().get("https://tutorialsninja.com/demo/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.FAILURE) {
            String path = captureScreenshot(result.getName());
            test.get().fail(result.getThrowable());
            test.get().addScreenCaptureFromPath(path);
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.get().pass("Test Passed");
        }
        else {
            test.get().skip("Test Skipped");
        }

        getDriver().quit();
        driver.remove();
        test.remove();
    }

    /* ===================== Screenshot ===================== */
    public String captureScreenshot(String testName) throws Exception {

        // ✅ Project ke andar Screenshots folder auto-create
        File dir = new File("Screenshots");
        if (!dir.exists()) {
            dir.mkdir();
        }

        // ✅ Screenshot capture
        File src = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.FILE);

        // ✅ Timestamp add (overwrite se bachne ke liye)
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                                .format(new Date());

        String path = "Screenshots/" + testName + "_" + timeStamp + ".png";

        // ✅ File save
        Files.copy(src, new File(path));

        return path; // Extent report ke liye
    }
    

    /* ===================== Utilities ===================== */
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphabetic(5)
             + RandomStringUtils.randomNumeric(5);
    }
	
	/*public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentSparkReporter spark;
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
	
	public void screenShot() throws Exception {
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\Hp\\Desktop\\SS\\"+ driver.getTitle()+ ".png"));
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
	}*/
	
	
	
}
