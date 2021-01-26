package nitikag.Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import nitikag.Selenium.base;

public class HomePageTest extends base {
	
	public WebDriver driver;
	//public static Logger log=LogManager.getLogger(base.class.getName());
	
@BeforeTest
	
	public void initialize() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		

	}
		
    
	@Test(dataProvider = "getData") // Call getData method)

	public void basePageNavigation(String UserName, String Password, String text) throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		
		if(l.getPopupSize()>0)
		{
			l.getPopUp().click();
		}
		
		LoginPage lp= l.getLogin();

		
		lp.getEmail().sendKeys(UserName);
		lp.getPassword().sendKeys(Password);
		
		lp.getLogin().click();
		ForgotPassword fp= lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.getsendMeInstructions().click();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider

	public Object[][] getData() {

		// Row stands for how many different data types test should run
		// Column stands for how many values per each test
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestricteduser@qwerty.com";
		data[0][1] = "12345";
		data[0][2] = "Restricted User";
		//1st row
		data[1][0] = "restricteduser@qwerty.com";
		data[1][1] = "45678";
		data[1][2] = "Non Restricted User";

		return data;

	}

}
