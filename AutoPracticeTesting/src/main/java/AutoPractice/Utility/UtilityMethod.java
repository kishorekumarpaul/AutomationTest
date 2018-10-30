package AutoPractice.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import AutoPractice.Resource.ContVar;

public class UtilityMethod 
{

	 public class getAppLocaters {

	}

	private static String value;
		static WebDriver driver;
		private static WebElement loct;

		public static String getLocators(String key) throws IOException {
			try {
				FileInputStream fis = null;
				fis = new FileInputStream(ContVar.LocatorFile);
				Properties prop = new Properties();
				prop.load(fis);
				value = prop.getProperty(key);
			} catch (FileNotFoundException e) {
				System.out.println("Error in fetching property from SlingLocater File");
			}
			return value;
		}

		public static String getAppData(String key) throws IOException {
			try {
				FileInputStream fis = null;
				fis = new FileInputStream(ContVar.ConfigFile);
				Properties prop = new Properties();
				prop.load(fis);
				value = prop.getProperty(key);
			} catch (FileNotFoundException e) {
				System.out.println("Error in fetching property from SlingLocater File");
			}
			return value;
		}

		public static WebElement getAppLocaters(WebDriver driver, String locater) throws IOException {
			String locaters = UtilityMethod.getLocators(locater);
			String locArray[] = locaters.split("##");
			String reqloctValue = locArray[0];
			String loctType = locArray[1];
			if (loctType.equalsIgnoreCase("XP")) {

				loct = driver.findElement(By.xpath(reqloctValue));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid IndianRed'", loct);

			} else if (loctType.equalsIgnoreCase("id")) {
				loct = driver.findElement(By.id(reqloctValue));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", loct);

			} else if (loctType.equalsIgnoreCase("linktxt")) {
				loct = driver.findElement(By.linkText(reqloctValue));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid Aqua'", loct);
			} else if (loctType.equalsIgnoreCase("partialLnk")) {
				loct = driver.findElement(By.partialLinkText(reqloctValue));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", loct);
			} else if (loctType.equalsIgnoreCase("css")) {
				loct = driver.findElement(By.cssSelector(reqloctValue));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", loct);
			} else if (loctType.equalsIgnoreCase("name")) {
				loct = driver.findElement(By.name(reqloctValue));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", loct);
			} else if (loctType.equalsIgnoreCase("tagname")) {
				loct = driver.findElement(By.tagName(reqloctValue));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", loct);
			} else if (loctType.equalsIgnoreCase("class")) {
				loct = driver.findElement(By.className(reqloctValue));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", loct);
			} else {
				System.out.println("locater not matched");
			}

			return loct;

		}

	
	}


