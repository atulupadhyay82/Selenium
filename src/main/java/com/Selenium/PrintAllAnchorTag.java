package com.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintAllAnchorTag {

	
	private ChromeDriver driver;

	@Test
	public void printAnchorTag() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//Specifies the amount of time the driver should wait when searching for an element if it is not immediately present. 
//		When searching for a single element, the driver should poll the page until the element has been found, or this timeout expires
//		before throwing a NoSuchElementException. When searching for multiple elements, the driver should poll the page until at least one 
//		element has been found or this timeout has expired.  
//		Increasing the implicit wait timeout should be used judiciously as it will have an adverse effect on test run time, 
//		especially when used with slower location strategies like XPath. 
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		List<WebElement> anchorLink = driver.findElements(By.tagName("a"));
		System.out.println("total link is: "+anchorLink.size());
		for(int i=0;i<anchorLink.size();i++)
		{
			System.out.println(anchorLink.get(i).getAttribute("href"));
		}
	}
}
