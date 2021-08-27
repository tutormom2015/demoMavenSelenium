package demomaventestcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demomavenpageobjects.DemoMaven_LoginTestPage;
import demomavenutilities.XLUtils;

public class TC_loginTest_DDT_002 extends BaseClass{

	@Test( dataProvider = "DDTLoginData")
	public void loginTestDDT(String ddtUserName  , String ddtPwd ) throws Exception{
		
		logger.info("TC login Test  DDT 002 started ");
		
		driver.get(baseURL);
		logger.info(" open Url : " + baseURL);
		
		DemoMaven_LoginTestPage  pg = new DemoMaven_LoginTestPage(driver);
		
		logger.info("Send user Name : " + ddtUserName + ", password :  " + ddtPwd );
		pg.setUsrNameEmail( ddtUserName);
		pg.setUsrPassword(ddtPwd);
		pg.clickLogin();
		
		// wait for login to complete and load new page
		Thread.sleep(3000);
		
		if ( driver.getTitle().equals("Dashboard / nopCommerce administration") )
		{
			Assert.assertTrue(true);
			pg.clickLogout();
			
			logger.info("login is passed....");
		}
		else {
			Assert.assertTrue(false);
			logger.info("login failed" );
				// no need to capture screenshot as this is data driven test
				// captureScreen(driver, "TC_loginTest_001");
		}
		
	}
	
	@DataProvider( name = "DDTLoginData")
	public String[][] testDataProvider() throws IOException {
		
		String filePath = System.getProperty("user.dir") + "/src/test/java/demomaventestdata";
		String fileName = "LoginData.xlsx";
		
		int rowCount = XLUtils.getRowCount(filePath, fileName, "Sheet1");
		int colCount = XLUtils.getCoulmnCount(filePath, fileName, "Sheet1", 1);
		
		System.out.println("total number of rows in excel : " + rowCount);
		System.out.println("total number of columns in excel : " + colCount);
		
		
		String testData[][] = new String [rowCount][colCount];
		
		for( int i = 1; i <= rowCount; i++) {
			for( int j = 0; j < colCount; j++) {
				System.out.println(" reading row  : " + i + " from excel");
				testData[i - 1][j] = XLUtils.getCoulmnData(filePath, fileName, "Sheet1", i, j);
			}
		}
		
		return testData;
		
	}
	
}
