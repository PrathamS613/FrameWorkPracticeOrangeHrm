package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
//global declarations
	public static WebDriver driver;
	public Properties prop;
	public WebDriverWait wait_obj;
	public Actions action;

	public void LaunchBrowser() throws InterruptedException, IOException {
		// Read the Browser Name from config.properties file
		Properties prop_obj = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\config.properties");
		String browserName = prop_obj.getProperty("BrowserName");

		if (browserName.equals("chrome")) {
			// Script to launch chrome Browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			Thread.sleep(5000);
			System.out.println("Sucessfully opened Chrome Driver Browser!!");
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			// Script to launch Firefox Browser
			driver = new FirefoxDriver();
			Thread.sleep(5000);
			System.out.println("Sucessfully opened Internet Explorer Driver !!");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			// Script to launch Edge Browser
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
			Thread.sleep(5000);
			System.out.println("Sucessfully opened Internet Explorer Driver !!");
		} else {
			System.out.println("Invalid Browser Name !!");
		}
		// Launching URL by reading from .properties file
		String URL = prop_obj.getProperty("URL");
		driver.get(URL);
	}

	public Properties ReadConfig(String propertiesPath) throws IOException {
		FileInputStream fis = new FileInputStream(propertiesPath);
		prop = new Properties();
		prop.load(fis);
		return prop;
	}

	// common method for wait
	public void waitForElementToBeVisble(WebElement element, int waitTime) {
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait_obj.until(ExpectedConditions.visibilityOf(element));
	}

	// common method for wait element to be clickable
	public void waitElementToBeClickable(WebElement element, int waitTime) {
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait_obj.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Individual Method For Action perfromed on WEBPage for clear and Send keys
	public void clearAndSendKeys(WebElement element, String value, String fieldname) {
		waitForElementToBeVisble(element, 40);
		highlight(element);
		element.clear();
		element.sendKeys(value);
		// System.out.println("Entered " + value + " In " + fieldname);
		Reporter.log("Entered  " + value + " In " + fieldname);
	}

	// Action Sendkeys if normal clearAndSendKeys method not working
	public void sendKeysActions(WebElement element, String value, String fieldname) {
		action = new Actions(driver);
		waitForElementToBeVisble(element, 40);
		highlight(element);
		action.sendKeys(element, value).build().perform();
		Reporter.log("Entered  " + value + " In " + fieldname);
	}

	// Individual Method For Action perfromed on WEBPage for Click action
	public void click(WebElement element, String fieldname) {
		waitElementToBeClickable(element, 40);
		highlight(element);
		element.click();
//		System.out.println("Clicked on " + fieldname);
		Reporter.log("Clicked on " + fieldname);
	}

	// Action click if normal click method not working
	public void clickActions(WebElement element, String fieldname) {
		action = new Actions(driver);
		waitElementToBeClickable(element, 40);
		highlight(element);
		action.click().build().perform();
		Reporter.log("Clicked on " + fieldname);
	}

//	Individual Method For Action perfromed on WEBPage for Select 
	public void selectFromDropdown(WebElement element, String value, String choice, String fieldname) {
		waitElementToBeClickable(element, 10);
		highlight(element);
		Select select = new Select(element);

		switch (choice) {
		case "index":
			// converting from String to integer
			int index = Integer.parseInt(value);
			select.selectByIndex(index);
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}

//		System.out.println("Selected " + value + " From " + fieldname);
		Reporter.log("Selected " + value + " From " + fieldname);
	}

	public String getVisibleText(WebElement element, String fieldname) {
		highlight(element);

		String value = element.getText().trim();

		Reporter.log("Fetched " + value + " From " + fieldname); 

		return value;

	}

	public String getAttributeValue(WebElement element, String attributvalue, String fieldname) {
		highlight(element);

		String value = element.getAttribute(attributvalue);

		Reporter.log("Fetched " + value + " of Attribute " + attributvalue + " From " + fieldname);

		return value;
	}

	// Common method for attaching file
	public void attachFile(WebElement element, String fieldname, String filepath) throws InterruptedException {

        Thread.sleep(10000);
		element.sendKeys(filepath);
	}

	//Common method for highlight
	public void highlight(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public void scrollToElement(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.scrollToElement(element).build().perform();
	}
	
	public void scrollUpToElement()
	{
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.PAGE_UP).build().perform();;
		actions.keyUp(Keys.PAGE_UP).build().perform();;	
	}

}
