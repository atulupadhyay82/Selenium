package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EnterDataInTextField {
	
	WebDriver driver;

	@Test
	public void enterDataInTextField()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("test@gmail.com");
	}
	
	@Test
	public void enterDataInMultipleTextField()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@name='reg_email__']")).sendKeys("test@gmail.com");
	} 
}
