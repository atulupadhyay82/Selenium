package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataFromWebTable {

	private ChromeDriver driver;

	@Test
	public void countRowsAndColumn() throws InterruptedException
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
		int rowsNo= driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
		int colNo=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td")).size();
		
		System.out.println("total no of rows is:"+rowsNo);
		System.out.println("total no of col is:"+colNo);
	}
	
	
	@Test
	public void printDataOfWebTable() throws InterruptedException
	{
		
		int rowsNo= driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
		int colNo=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td")).size();
		
		String firstPart= "//*[@id='leftcontainer']/table/tbody/tr[";
		String secondPart="]/td[";
		String thirdPart="]";
		for(int i=1;i<=rowsNo;i++)
		{
			for (int j=1;j<=colNo;j++)
			{
				String finalPart=firstPart+i+secondPart+j+thirdPart;
				String element = driver.findElement(By.xpath(finalPart)).getText();
				System.out.print(element+ "|");
			}
			System.out.println();
		}
		
	}
}
