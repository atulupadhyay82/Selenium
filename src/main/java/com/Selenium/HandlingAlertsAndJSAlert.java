package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingAlertsAndJSAlert {

	
	WebDriver driver;

	@Test
	public void handleJSAlert() throws InterruptedException
	{
		//setting driver path properties before creating driver class object else will throw an error
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//Load a new web page in the current browser window.the method will block until the load is complete
		driver.get("file:///D:/Adobe_Workspace/Selenium/startbootstrap-sb-admin-2-gh-pages/pages/index.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//locate JSalerts
		
		driver.findElement(By.xpath("//*[@id='side-menu']/li[7]/a")).click();
		
		driver.findElement(By.xpath("//*[text()='Try it']")).click();
		Thread.sleep(3000);
		
		//press ok
		driver.switchTo().alert().accept();
		
		//press cancel
		
		//driver.switchTo().alert().dismiss();
		
		String result= driver.findElement(By.xpath("//*[@id='demo']")).getText();
		if(result.equals("You pressed OK!"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertEquals(result, "You pressed OK!");
		}
		
		
	}
}
