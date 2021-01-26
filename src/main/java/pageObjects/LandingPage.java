package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {

	
	public WebDriver driver;
	
	private	By signin =By.cssSelector("a[href*='sign_in']");
	private By title=By.cssSelector(".text-center");
	private By NavBar=By.cssSelector(".navbar.navbar-default.navbar-static-top");
	private By popup= By.xpath("//button[contains(text(),'NO THANKS')]");
	private By header= By.cssSelector("div[class*='video-banner'] h3");
	


	public LandingPage(WebDriver driver) throws InterruptedException {
			// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
		
	}

	
	public LoginPage getLogin()
	{
      driver.findElement(signin).click();
      LoginPage lp = new LoginPage(driver);
      return lp;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	public int getPopupSize()
	{
		return driver.findElements(popup).size();
		
	}
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
}
