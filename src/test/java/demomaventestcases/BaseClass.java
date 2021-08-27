package demomaventestcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import demomavenutilities.ReadConfig;
import jdk.internal.org.jline.utils.Log;

public class BaseClass {
	
	public static WebDriver   driver;
	ReadConfig readconfig = new ReadConfig();
	
	String baseURL = readconfig.getBaseURL();
	String userEmail  =  readconfig.getuserEmail();
	String userPassword = readconfig.getuserPassword();
	
	public static Logger logger;

	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser ) {
		logger = Logger.getLogger("demoMavenSelenium");
		PropertyConfigurator.configure("log4j.properties");

		if( browser.equals("chrome")) {
			logger.info("Chrome browser selected");
			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			driver = new ChromeDriver();			
		}
		else 	if( browser.equals("firefox")) {
			logger.info("firefox  browser selected");

			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver = new FirefoxDriver();			
		}
		else 	if( browser.equals("opera")) {
			logger.info("opera browser selected");

			System.setProperty("webdriver.opera.driver", readconfig.getoperapath());
			driver = new OperaDriver();			
		}
		else 		if( browser.equals("ie")) {
			logger.info("You need to setup path variable for IE driver to work....");
			
			System.setProperty("webdriver.ie.driver", readconfig.getiepath());
			driver = new InternetExplorerDriver();	
			logger.info("You need to setup path variable for IE driver to work....");
		}


		

		
		
	}

	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname)  throws IOException
	{
//		if (result.getStatus() == ITestResult.FAILURE) 
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			System.out.println("Get the screen shot : " + tname);
			File source = ts.getScreenshotAs(OutputType.FILE); // capture the screenshot file
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("screenshot catured");

	}

	
	
	
	
}
