package nitikag.Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	//public static Logger log=LogManager.getLogger(base.class);

	public static WebDriver driver;  //driver can be accessed outside the class,so we made it public
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
	 prop = new Properties();
	 //System.getProperty("user.dir")
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
	prop.load(fis);
	//String browserName=System.getProperty("browser");
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	
	//if(browserName=="chrome") // You cannot use == when extracting value from a properties file
	if(browserName.equals("chrome"))
	{
      WebDriverManager.chromedriver().setup();
    /* ChromeOptions options = new ChromeOptions();
      options.addArguments("headless");*/
	  driver = new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		driver= new FirefoxDriver();
	}
	else if (browserName.equals("IE"))
	{
	    
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		 FileUtils.copyFile(source, new File(destinationFile));
		 return destinationFile;
	}
}
