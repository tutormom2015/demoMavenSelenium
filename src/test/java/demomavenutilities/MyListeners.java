package demomavenutilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

public class MyListeners   extends TestListenerAdapter {
	


	public void onStart(ITestContext tr) {
		System.out.println("On Start listener started");
	
		
	}
	
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println( " OnTestSuccessListener started");
		
		
		
	}
	
	public void onTestFailure(ITestResult tr) {
		System.out.println( " OnTestFailureListener started");
	}
	
	public void onTestSkipped(ITestResult tr) {
	}

	public void onFinish(ITestContext tr) {
	}
	
}
