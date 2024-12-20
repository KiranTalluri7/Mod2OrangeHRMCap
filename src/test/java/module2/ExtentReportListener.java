package module2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    private ExtentReports extent;
    private ExtentTest test;

    // Called when the test suite starts
    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    // Called when a test starts
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    // Called when a test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    // Called when a test fails
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    // Called when a test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped");
    }

    // Called after all tests are finished
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();  // This will save the report
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: for partial failures
    }
}
