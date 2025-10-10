package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import test_base.BaseClass;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ExtentReportListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testThread.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        BaseClass baseClass = new BaseClass();
        WebDriver driver = baseClass.driver;
        if (driver != null) {
            try {
                // Screenshot path
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String destPath = System.getProperty("user.dir") + "/reports/screenshots/" + result.getName() + ".png";
                Files.createDirectories(new File(destPath).getParentFile().toPath());
                Files.copy(src.toPath(), new File(destPath).toPath());

                testThread.get().addScreenCaptureFromPath(destPath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

