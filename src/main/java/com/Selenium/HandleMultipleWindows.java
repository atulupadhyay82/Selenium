package com.Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HandleMultipleWindows {
	
	
	WebDriver driver;

	@Test
	public void enterDataInSelectBox()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		//click on youtube link
		driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[3]/a")).click();
		
		//here we will get all windows id's
		Set<String> windowsID = driver.getWindowHandles();
		
		Iterator<String> itr = windowsID.iterator(); 
		
		String parentId=itr.next();
		String childId=itr.next();
		
		//switch to child window.Without this, you cannot work in child window.
		driver.switchTo().window(childId);
		
		//Just put a sleep for 3 sec to see how new window is opening
		try {
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close the youtube window.
		driver.close();
		
		//switch to parent window.Without this, you cannot work in parent window.
		driver.switchTo().window(parentId);
		
		//click on women link in parent window
		driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[2]/div/div/ul/li/a")).click();
		
	}

}
