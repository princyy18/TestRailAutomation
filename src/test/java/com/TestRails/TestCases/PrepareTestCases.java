package com.TestRails.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import com.TestRails.Pages.Login;

import com.TestRails.Pages.OpenTestcase;

import io.github.bonigarcia.wdm.WebDriverManager;


public class PrepareTestCases {

	@Test
	public void AutomatingTestRails() throws InterruptedException, IOException
	{
		//load the file and read the data from file
		Properties pro = new Properties();
		FileInputStream io = new FileInputStream("/Users/princy.anghan/Documents/Selenium/test.properties"); //you need to give path of properties file here 
		System.out.print("hello:sidksds");
		pro.load(io);
		
		WebDriver driver =  WebDriverManager.chromedriver().create();
		driver.get(pro.getProperty("URL"));

		
		Login loginTestRails = PageFactory.initElements(driver, Login.class);
		OpenTestcase TestRailUser = PageFactory.initElements(driver, OpenTestcase.class);
		
		loginTestRails.LogIntoTestRails(pro.getProperty("Username"), pro.getProperty("Password"));
			
		TestRailUser.OpenProjectAndTestCase();
		TestRailUser.OpenTestCase();
		TestRailUser.AddTestCase();
		
		for(int i=0;i<=400;i++)
		{
			OpenTestcase TestRailUser1 = PageFactory.initElements(driver, OpenTestcase.class);
			TestRailUser1.selectSection();
			TestRailUser1.selectTestCaseType();
			TestRailUser1.precondition();
			TestRailUser1.waitforusertoclick();
		}
	}		
	
}
