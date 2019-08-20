package com.Selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calender {


	private ChromeDriver driver;

	@Test
	public void enterDateInCalender()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}
		
}

