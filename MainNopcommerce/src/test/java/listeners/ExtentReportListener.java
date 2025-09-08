package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import utils.ScreenshotUtils;
import utils.ExtentReportManager;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.getReportInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static WebDriver driver;

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, " Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "❌ Test Failed: " + result.getThrowable());

        if (driver != null) {
            String base64Screenshot = ScreenshotUtils.captureScreenshotBase64(driver);
            try {
                test.get().fail("📸 Screenshot on Failure",
                        com.aventstack.extentreports.MediaEntityBuilder
                                .createScreenCaptureFromBase64String(base64Screenshot, "Failed Step Screenshot")
                                .build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, " Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}