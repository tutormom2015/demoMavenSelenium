package demomavenutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBaseURL( ) {
		return pro.getProperty("baseURL");
	}
	
	public String getuserEmail( ) {
		return pro.getProperty("userEmail");
	}
	
	public String getuserPassword() {
		return pro.getProperty("userPassword");
	}
	
	public String  getchromepath( ) {
		return pro.getProperty("chromepath");
	}
	
	public String getiepath() {
		return pro.getProperty("iepath");
	}
	
	public String getfirefoxpath() {
		return pro.getProperty("firefoxpath");
	}
	
	public String getoperapath() {
		return pro.getProperty("operapath");
	}
	
	
	
}

