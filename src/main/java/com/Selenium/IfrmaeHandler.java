package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IfrmaeHandler {
	

	WebDriver driver;

	@Test
	public void handleIframe()
	{
		//setting driver path properties before creating driver class object else will throw an error
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		//Load a new web page in the current browser window.the method will block until the load is complete
		driver.get("file:///D:/Adobe_Workspace/Selenium/startbootstrap-sb-admin-2-gh-pages/pages/forms.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//sendkeys cann't work directly with iframe (html inside the html)
		
		//Select a frame by its (zero-based) index. Selecting a frame by index is equivalent to the JS expression window.
		//Once the frame has been selected, all subsequent calls on the WebDriver interface are made to that frame.
		//1st ways- by indes: driver.switchTo().frame(0);
		
		//there are 2 more ways to do this
		//2nd way by name or ID- driver.switchTo().frame(nameOrId);
		//3rd way by xpath- 
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"frame.html\"]")));
		driver.findElement(By.xpath("/html/body/div/form/div/input[1]")).sendKeys("abc");
		
		driver.findElements(By.xpath("/html/body/div/form/div/input[1]")).get(0).sendKeys("xyz");
		
		//returns driver focused on the top window/first frame.
		driver.switchTo().defaultContent();
	}
	

}
