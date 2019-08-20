package com.Selenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteAndGetCookies {

	private ChromeDriver driver;

	@Test
	public void deleteCookies() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Adobe_Workspace\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		Set<Cookie> cookiesList = driver.manage().getCookies();
		System.out.println("Getting Cookies");
		for(Cookie getCookies:cookiesList)
		{
			System.out.println(getCookies);
		}
		
		
		//deleting particular cookies
		System.out.println("deleting cookie:x-wl-uid");
		driver.manage().deleteCookieNamed("x-wl-uid");
		cookiesList = driver.manage().getCookies();
		System.out.println("Getting Cookies");
		for(Cookie getCookies:cookiesList)
		{
			System.out.println(getCookies);
		}
		
		//deleting all cookies
		driver.manage().deleteAllCookies();
		
		cookiesList = driver.manage().getCookies();
		System.out.println("Deleting all the Cookies");
		for(Cookie getCookies:cookiesList)
		{
			System.out.println(getCookies);
		}
		
		
 	}
}
