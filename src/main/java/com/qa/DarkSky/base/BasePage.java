package com.qa.DarkSky.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {	
	// Fields, driver, properties
	
	WebDriver driver;
	Properties properties;
	OptionsManager optionsManager;
	
//	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//	public static synchronized WebDriver getDriver(){
//		return driver.get();
//	}
	
	// initialize driver
	public WebDriver initializeDriver(Properties prop) {
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else {
			System.out.println(browser + " name is not found!");
		}
		
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}

	
	
	
	// initializing properties
	public Properties initialize_properties(){
		properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("/Users/user/"
					+ "eclipse-workspace/DarkSky/src/main/java/com/qa/DarkSky/config/config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			
		}
		return properties;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}