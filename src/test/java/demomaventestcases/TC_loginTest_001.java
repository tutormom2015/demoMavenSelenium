package demomaventestcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import demomavenpageobjects.DemoMaven_LoginTestPage;


public class TC_loginTest_001  extends BaseClass{
	

	
	@Test
	public void loginTest() throws InterruptedException {
		driver.get(baseURL);
		logger.info("URL is opened.....");
		
		DemoMaven_LoginTestPage  pg = new DemoMaven_LoginTestPage(driver);
		pg.setUsrNameEmail(userEmail);
		logger.info("user is provided" );
		
		pg.setUsrPassword(userPassword);
		logger.info("password provided....");

		pg.clickLogin();
		logger.info("loggin is clicked.....");
		
		Thread.sleep(3000);
		
		if ( driver.getTitle().equals("Dashboard / nopCommerce administration") )
		{
			Assert.assertTrue(true);
			pg.clickLogout();
			
			logger.info("login is passed....");
		}
		else {
			System.out.println("login is failed....");
			logger.info("login failed" );
			try {
				System.out.println("Capturing the screenshot for TC_loginTest_001");
				captureScreen(driver, "loginTest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);

		}
	}
	

}
