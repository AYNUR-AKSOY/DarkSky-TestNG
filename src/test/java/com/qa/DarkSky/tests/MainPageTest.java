package com.qa.DarkSky.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.DarkSky.base.BasePage;
import com.qa.DarkSky.pages.MainPage;


public class MainPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	MainPage mainPage;
	
	
	@BeforeTest
//	@Parameters(value = { "browser" })
	public void setup() {
//		String browserName = null;
		basePage = new BasePage();
		properties = basePage.initialize_properties();

		driver = basePage.initializeDriver(properties);
		mainPage= new MainPage(driver);
		
	}
	
	@Test(priority = 1)
	public void verifyTitleTest(){
		String expectedTitle = "Dark Sky ";
		String actualTitle = mainPage.verifyTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}
	
	@Test(priority = 2)
	public void enterlocation() throws InterruptedException{
		mainPage.enterLocationText("24 Union Blvd, Wallington, NJ");
		mainPage.clickSearchBtn();
		Thread.sleep(3500);
	}
	
	@Test(priority = 3)
	public void verifyMinTemp(){
		Assert.assertEquals(mainPage.lowTemp1String(), mainPage.lowTemp2String());
        System.out.println("Lowest temperatures are the same");
	}
	
	
	@Test(priority = 4)
	public void verifyMaxTemp() throws InterruptedException{
		
		Assert.assertEquals(mainPage.maxTemp1String(), mainPage.maxTemp2String());
        System.out.println("maximum temperatures are the same");
		
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
}
