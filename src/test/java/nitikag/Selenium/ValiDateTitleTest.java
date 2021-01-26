package nitikag.Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import nitikag.Selenium.base;

public class ValiDateTitleTest extends base{
	public WebDriver driver;
//public static Logger log=LogManager.getLogger(base.class.getName());	
	
	LandingPage l;
@BeforeTest
	
	public void initialize() throws IOException, InterruptedException 
	{   
		driver=initializeDriver();
		//log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		//log.info("Navigated to home page");
        
		}
	
	@Test
	
	public void basePageNavigation() throws IOException, InterruptedException
	{
		
        
		l= new LandingPage(driver);
		//l.getLogin().click();
	    //Compare the text from the browser with actual text- Error
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");// (actual,expected)//l.getTitle().getText();
		//log.info("Successfully validated Text message");
	}
	@Test
	
	public void validateHeader()
	{
		Assert.assertEquals(l.getHeader().getText(), "An Academy to learn Everything about Testing");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
