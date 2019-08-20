package com.Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomInZoomOut {
	
	private ChromeDriver driver;

	@Test
	public void zoomInAndZoomOut() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		((JavascriptExecutor)driver).executeScript("document.body.style.zoom='40%'");
		
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("document.body.style.zoom='100%'");
		
		Thread.sleep(3000);
		
	}

}
