package nitikag.Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import nitikag.Selenium.base;

public class ValidateNavigationBarTest extends base{
	
	public WebDriver driver;
	//public static Logger log=LogManager.getLogger(ValidateNavigationBarTest.class);
	@BeforeTest
	
	public void initialize() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(6000);
		
		WebElement popUp = driver.findElement(By.className("listbuilder-popup-content"));

    	int popSize = driver.findElements(By.className("listbuilder-popup-content")).size();

    	if(popSize > 0){

        driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
    	}
		
	
	}
	
	@Test
	
	public void basePageNavigation() throws IOException, InterruptedException
	{
		
		LandingPage l= new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());// Always expects true
		//Assert.assertFalse(false);
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
