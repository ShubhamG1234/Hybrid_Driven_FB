package ExtentListener;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	
	public class ExtentReporter_NG implements ITestListener{
	
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
		public ExtentReports extent = new ExtentReports();
		ExtentTest test;
	


	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+" :onTestSuccess");
		extent.attachReporter(spark);
		extent.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName()+" :onTestSuccess");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		test.pass("Test successfully executed");
		extent.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestFailure");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		test.fail("Test failed");
		extent.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestSkipped");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		test.skip("Test is skipped");
		extent.flush();
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}