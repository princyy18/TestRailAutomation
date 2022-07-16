package com.TestRails.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

final WebDriver driver;
	
	//Constructor, as every page needs a Webdriver to find elements
	public Login(WebDriver driver){
			this.driver=driver;
		}
	
	
	//Locating elements
	@FindBy(how = How.XPATH,using="//input[@id='name']")
	@CacheLookup
	WebElement username;
	
	@FindBy(how = How.XPATH,using="//input[@id='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how = How.XPATH,using="//button[@id='button_primary']")
	@CacheLookup
	WebElement login;
	
	
	
	
	public void LogIntoTestRails(String uName, String pwd) throws InterruptedException{
		
		username.sendKeys(uName);
		password.sendKeys(pwd);
		login.click();
		Thread.sleep(2000);
			
	}
}
