package AutoPractice.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutoPractice.Resource.ContVar;
import AutoPractice.Utility.Log;
import AutoPractice.Utility.UtilityMethod;

public class Framework1 
{
	WebDriver driver;
	
	@Test
	public void Registration() throws Exception
	{
		

	}
	@BeforeMethod
	public void launchBrowser() throws Exception
		{
		DOMConfigurator.configure("log4j.xml");
		System.setProperty("webdriver.chrome.driver", ContVar.chrome);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityMethod.getAppData("Url"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Log.info("Lunch Browser");
	    }
	
	@AfterMethod
		public void logout() throws Exception
		{

	
	}
}
