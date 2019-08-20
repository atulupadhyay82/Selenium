package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EnterDataInSelectBox {
	
	WebDriver driver;

	@Test
	public void enterDataInSelectBox()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement day= driver.findElement(By.xpath("//*[@id=\"day\"]"));
		Select select= new Select(day);
		select.selectByValue("5");
		
		WebElement month= driver.findElement(By.xpath("//*[@id=\"month\"]"));
		select= new Select(month);
		select.selectByIndex(5);
		
		WebElement year= driver.findElement(By.xpath("//*[@id=\"year\"]"));
		select= new Select(year);
		select.selectByVisibleText("2016");
		
	}

}
