package demomavenpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoMaven_LoginTestPage {
	
	WebDriver ldriver;
	
	public DemoMaven_LoginTestPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy( id = "Email")
	WebElement txtUserNameEmail;
	
	@FindBy(id = "Password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(linkText = "Logout")
	WebElement txtLogout;
	
	
	public void setUsrNameEmail( String usrNameEmail) {
		txtUserNameEmail.clear();
		txtUserNameEmail.sendKeys(usrNameEmail);	
	}
	
	public void setUsrPassword( String usrPassword) {
		txtPassword.clear();
		txtPassword.sendKeys(usrPassword);
	}
	
	public void clickLogin( ) {
		btnSubmit.click();
	}
	
	public void clickLogout( ) {
		txtLogout.click();
	}
	
	
}
