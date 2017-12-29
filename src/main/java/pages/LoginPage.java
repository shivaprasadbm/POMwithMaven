package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class LoginPage extends LeafTapsWrappers{
	
	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(verifyTitle("Opentaps Open Source ERP + CRM")==false){			
			reportStep("This is not My Login Page", "Fail");
		}
		
	}
	public LoginPage enterUserName(String data){
		enterById("username1", data);
		return this;
	}
	public LoginPage enterPassword(String data){
		enterById("password", data);
		return this;
	}
	public HomePage clickLogin(){
		clickByClassName("decorativeSubmit");
		return new HomePage(driver, test);
	}
	public LoginPage failedLogin(){
		clickByClassName("decorativeSubmit");
		return this;
	}
	public void verifyErrorMsg(String data){
		verifyTextContainsById("errorDiv",data);
	}

}
