package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MySQLListener implements ITestListener {
	
	MySQLBeans mySQLBeans = new MySQLBeans();

	public void onTestStart(ITestResult iTestResult) {

	}

	public void onTestSuccess(ITestResult iTestResult) {
		this.postTestMethodStatus(iTestResult, 200);
	}

	public void onTestFailure(ITestResult iTestResult) {
		this.postTestMethodStatus(iTestResult, 500);
	}

	public void onTestSkipped(ITestResult iTestResult) {
		this.postTestMethodStatus(iTestResult, 500);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	private void postTestMethodStatus(ITestResult iTestResult, int status) {
		
		String name = iTestResult.getName();
		
		float responseTime = mySQLBeans.getResponseTime();
		
		MySQLUpdateResults mySQLUpdateResults = new MySQLUpdateResults();
				
		mySQLUpdateResults.updateResults(name, status, responseTime);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}