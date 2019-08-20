package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorCapabilities {
	
	private ChromeDriver driver;

	@Test
	public void executeJS() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Indicates that a driver can execute JavaScript, providing access to the mechanism to do so. 
		JavascriptExecutor jsExec = (JavascriptExecutor)driver;
		
		//performing sendkeys via JS.		
		jsExec.executeScript("document.getElementById('email').setAttribute('value','test123@gmail.com')");
		
		jsExec.executeScript("document.getElementById('pass').setAttribute('value','password')");
		
		//performing click via JS
		
		jsExec.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@data-testid='royal_login_button']")));
		
		
		//get the document domain. will work in console window also of broswer
		System.out.println(jsExec.executeScript("return document.domain;").toString());
		
		//get the document URL
		System.out.println(jsExec.executeScript("return document.URL;").toString());
		
		//get the document title
		System.out.println(jsExec.executeScript("return document.title;").toString());
		
		//scroll till the end vertically
		jsExec.executeScript("window.scrollTo(0,document.body.scrollHeight)")	;
		
		//scroll back to the beginning
		jsExec.executeScript("window.scrollTo(0,-document.body.scrollHeight)")	;
		
		//scroll till some pixel
		jsExec.executeScript("window.scrollBy(0,100)")	;
		
		//scroll till some specific element
		jsExec.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//*[@title='Show more languages']")))	;
		
		
	}
	

}
