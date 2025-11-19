package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Runner.dataRunner;
import Utilities.CommonMethods;

public class LoginPage extends CommonMethods { 

	//Globally initalize  
	public dataRunner runner = new dataRunner();
	//Globally declare  
	public Map<String, String> dataProp;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameTextfield;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextfield;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//img[contains(@class,'oxd-userdropdown-img')]")
	WebElement userIcon;
	
	// constructor 
	public LoginPage(WebDriver driver, int waitTime) {  
		// initalized Webdriver declartaion in Common method
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		PageFactory.initElements(driver, this); 
	}

	// method for inputting data
	public void fillLoginDetails() throws InterruptedException, IOException {
//		Properties prop = ReadConfig("C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\config.properties");
		
		 dataProp = runner.newDataMap;
		
		// wait_obj.until(ExpectedConditions.visibilityOf(usernameTextfield));
		// Instead of Wait creating in Same method we are calling Common Wait method
		// from Base class
//		waitForElementToBeVisble(usernameTextfield, 5);
//		usernameTextfield.sendKeys(prop.getProperty("UserName"));
		Thread.sleep(3000);
//		clearAndSendKeys(usernameTextfield, prop.getProperty("UserName"), "Username Textfield");
		clearAndSendKeys(usernameTextfield, dataProp.get("UserName"), "Username Textfield");

		// wait_obj.until(ExpectedConditions.visibilityOf(passwordTextfield));
		// Instead of Wait creating in Same method we are calling Common Wait method
		// from Base class
//		waitForElementToBeVisble(passwordTextfield, 5);
//		passwordTextfield.sendKeys(prop.getProperty("Password"));
//		clearAndSendKeys(passwordTextfield, prop.getProperty("Password"), "Password Textfield");
		clearAndSendKeys(passwordTextfield, dataProp.get("Password"), "Password Textfield");

		// wait_obj.until(ExpectedConditions.elementToBeClickable(loginButton));
		// Instead of Wait creating in Same method we are calling Common Wait method
		// from Base class
//		waitElementToBeClickable(loginButton, 5);
//		loginButton.click();
		System.out.println("*waiting for login *");
		click(loginButton, "Login Button");
		
		waitForElementToBeVisble(userIcon, 15);
		Assert.assertTrue(userIcon.isDisplayed());
		
		System.out.println("Login Sucessfull !!");

	}
}
