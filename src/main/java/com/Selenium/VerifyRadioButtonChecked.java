package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyRadioButtonChecked {
	
	WebDriver driver;

	@Test
	public void isRadioButtonChecked()
	{
		//setting driver path properties before creating driver class object else will throw an error
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		//Load a new web page in the current browser window.the method will block until the load is complete
		driver.get("https://jqueryui.com/checkboxradio/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//all these web element are in IFRAME, so switch to it
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		//get the radio button element and click on it
		
		driver.findElement(By.xpath("//div[@class='widget']/fieldset/label[@for='radio-1']/span")).click();
		
		//now the radio button is clicked. Because of that classname attribute in its label gets changed.
		

		String classname=driver.findElement(By.xpath("//div[@class='widget']/fieldset/label[@for='radio-1']")).getAttribute("class");
		if(classname.contains("ui-checkboxradio-checked ui-state-active"))
			Assert.assertTrue(true, "it is not clicked");
		else
			Assert.assertTrue(false, "it is not clicked");
	}

}
