package com.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleCalenderTextBoxSelectBox {
	
	
	private ChromeDriver driver;

	@Test
	public void enterDateAndSelectbox() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.phptravels.net/");
	
		//User enter some text, based on that app returns matching result. You have to select the 1st result
		//this result box need to click first before entering the text
		driver.findElement(By.xpath("//*[@id=\"s2id_location\"]/a/span[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("Block");
		//wait for 5sec to see matched results on the UI
		Thread.sleep(5000);
		
		////*[@id="select2-drop"]/ul/li/ul/li[1]/div- is xpath for 1st matched result but we should not use such xpath
		//make it argumentative, supplied from the external sources i.e. code itself
		
		//1 way to locate the 1st matched results
		//driver.findElement(By.xpath("//*[contains(text(),' Island, United States')]")).click();
		
		//2nd way is to get all li elements, match their text in the loop
		
		List<WebElement> allListElement = driver.findElements(By.xpath("//*[@class='select2-result-sub']/li"));
		
		for(int i=0;i<allListElement.size();i++)		
		{
			WebElement element = allListElement.get(i);
			System.out.println(element.getText());
			if(element.getText().equals("Block Island, United States"))
			{
				element.click();
				break;
			}
		}
		
		String month="November 2019";
		String date="21";
		
		
		
		
	}

}
