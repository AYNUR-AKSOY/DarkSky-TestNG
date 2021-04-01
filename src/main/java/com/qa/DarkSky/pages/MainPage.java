package com.qa.DarkSky.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DarkSky.base.BasePage;
import com.qa.DarkSky.util.ElementUtil;

public class MainPage extends BasePage{
	WebDriver driver;	
	ElementUtil elementUtil;
	
	 By myText=By.xpath("//input[@type='text']");
	 By searchBtn=By.xpath("//img[@alt='Search Button']");
	 By locationText=By.xpath("//input[@type='text']");
	 By lowTemp1=By.xpath("//span[@class='low-temp-text']");
	 By maxTemp1=By.xpath("//span[@class='high-temp-text']");
	 By lowTemp2=By.xpath("//a[@data-day='0']//span[@class='minTemp']");
	 By maxTemp2=By.xpath("//a[@data-day='0']//span[@class='maxTemp']");
			
	
	public MainPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public void enterLocationText(String location) {
        driver.findElement(myText).clear();
        elementUtil.doSendKeys(locationText, location);;
        }
        public void clickSearchBtn() throws InterruptedException {
            elementUtil.doClick(searchBtn);
            Thread.sleep(3000);
        }
        public String verifyTitle(){
        	return elementUtil.doGetPageTitle();
        }
        
        public String lowTemp1String(){
            return elementUtil.doGetText(lowTemp1);
        }
        public String lowTemp2String(){
            return elementUtil.doGetText(lowTemp2);
        }
        public String maxTemp1String(){
        	return elementUtil.doGetText(maxTemp1);
        }
        public String maxTemp2String(){
        	return elementUtil.doGetText(maxTemp2);
        }

    }
	

