package demomavenutilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportExtentReport extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext context) {
		
		System.out.println("OnStart Listener");
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Anju");
		
		htmlReporter.config().setDocumentTitle("nopCommerce Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);


	}
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println("OnTest Success Listener");

		logger = extent.createTest( tr.getName()); // create a new entry in extent report
		logger.log(Status.PASS,  MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	
	public void onTestFailure( ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		System.out.println("OnTest Failure: in ReportExtentReport");
		
		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png" ;
		
		File f = new File(screenShotPath);
		if( f.exists()) {
			
			System.out.println("Screen Shot file exists");
			try {
				logger.fail("ScreenShot is below : " +  logger.addScreenCaptureFromPath(screenShotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else {
			System.out.println( screenShotPath );
			System.out.println("Screen Shot file  Does not exist!!!");
			
		}
	}
	
	
	public void onTestSkipped( ITestResult tr) {
		logger = extent.createTest( tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	
	public void onFinish( ITestContext context) {
		
		System.out.println("OnTestFinish called");
		extent.flush();
	}
	
}

