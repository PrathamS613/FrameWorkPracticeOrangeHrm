package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import Runner.dataRunner;
import Utilities.CommonMethods;

public class AdminUser extends CommonMethods {
	//Global initalize 
	public dataRunner runner = new dataRunner();
	public Map<String, String> dataprop = new HashMap();

	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")
	WebElement Admin;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement AddButton;

	@FindBy(xpath = "//label[contains(text(),'User Role')]/following::div[@class='oxd-select-text-input'][1]")
	WebElement User_Role_dropdown;

//Created Dynamic Xpath 
//	 @FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'ESS')]")
//	 WebElement UserRoleESS;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement EmployeeNametextfield;

//	Created Dynamic Xpath 
//	@FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'Ranga  Akunuri')]")
//	WebElement User_sugesstion;

	@FindBy(xpath = "//label[contains(text(),'Status')]/following::div[@class='oxd-select-text-input'][1]")
	WebElement Status_dropdown;

//	@FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'Enabled')]")
//	WebElement status_enable;
	
//Created Dynamic Xpath 
	@FindBy(xpath = "//label[contains(text(),'Username')]/following::input[@class='oxd-input oxd-input--active'][1]")
	WebElement username;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement password;


	@FindBy(xpath = "(//input[@autocomplete='off'])[3]")
	WebElement confirmpassword;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement Savebutton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchbutton;

	@FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span[1]")
	WebElement searchRecordCounts;

	@FindBy(xpath = "//div[@role='columnheader']")
	List<WebElement> adminHeaders;

	@FindBy(xpath = "//div[@role='cell']/div")
	List<WebElement> adminUserDataValues;

//	DeleteAdminUserCheckBox
	@FindBy(xpath = "//div[@role='cell']//button")
	List<WebElement> adminUserdeleteEditIcon;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	WebElement confrimDeleteAlert;
	
	

// Constructor
	public AdminUser(WebDriver driver, int waitTime) {
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		PageFactory.initElements(driver, this);
	}

	public void FillAddUserDetails() throws IOException, InterruptedException {
//		Properties prop = ReadConfig(
//				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\AddNewUser.properties");

	dataprop = runner.newDataMap;
		
		
		click(Admin, "Admin to add user");
		click(AddButton, "Add Button to add new user");

//		Dynamic Xpath called
		click(User_Role_dropdown, "Clicked on UserRole");
//		 click(UserRoleESS, "Selected ESS from the dropdown");

//		 Dynamic Xpath for UserRole dropdown for user option
		WebElement userRoleOption = driver.findElement(
				By.xpath("//div[@role='listbox']//*[contains(text(),'" + dataprop.get("UserRole") + "')]"));
		click(userRoleOption, dataprop.get("UserRole"));

		clearAndSendKeys(EmployeeNametextfield, dataprop.get("EmployeeName"),
				"Inserted Value in field Employee Name");
		// click(User_sugesstion, "Selected from Employeename dropdown");
		Thread.sleep(5000);

//		Dynamic Xpath called
//		Created Dynamic Xpath 
		WebElement FillAddUserDetailsuserSuggestionNameOption = driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + dataprop.get("EmployeeName") + "')]"));
		click(FillAddUserDetailsuserSuggestionNameOption, dataprop.get("EmployeeName"));

		click(Status_dropdown, " Status field ");
//		click(status_enable, "Selected Status Enable from dropdown");
		Thread.sleep(5000);

		WebElement AddUserstatusSuggestion = driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + dataprop.get("Status") + "')]"));
		click(AddUserstatusSuggestion, "Status Suggestion");

		wait_obj.until(ExpectedConditions.visibilityOf(username));
		clearAndSendKeys(username, dataprop.get("AdminUsername"), "Inserted value UserName field ");

		clearAndSendKeys(password, dataprop.get("AdminPassword"), "Inserted value in Passsword field");
		clearAndSendKeys(confirmpassword, dataprop.get("AdminConfirmPassword"),
				"Inserted value in confirm Passsword field");

		click(Savebutton, " Save button");
		Thread.sleep(10000);
		System.out.println("Admin User Added  Sucessfull !!");

	}

	public void searchAdminUser() throws InterruptedException, IOException {
//		Properties prop = ReadConfig(
//				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\AddNewUser.properties");
		dataprop = runner.newDataMap;
		
		click(Admin, "Admin to add user");
		
		waitForElementToBeVisble(User_Role_dropdown, 10);
		click(User_Role_dropdown, "Clicked on UserRole");

		// click(UserRoleESS, "Selected ESS from the dropdown");
//		Dynamic Xpath Created 
		WebElement searchAdminUseruserRoleOption = driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + dataprop.get("UserRole") + "')]"));
		click(searchAdminUseruserRoleOption, dataprop.get("UserRole"));

		clearAndSendKeys(EmployeeNametextfield, dataprop.get("EmployeeName"),
				"Inserted Value in field Employee Name");
		Thread.sleep(5000);
//		click(User_sugesstion, "Selected from Employeename dropdown");
//		DynamicUserSuggestion
		Thread.sleep(5000);

//		Created Dynamic Xpath 
		WebElement searchAdminUseruserSuggestionNameOption = driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + dataprop.get("EmployeeName") + "')]"));
		// Dynamic Xpath
		click(searchAdminUseruserSuggestionNameOption, dataprop.get("EmployeeName"));

		click(Status_dropdown, " Status field ");
		// click(status_enable, "Selected Status Enable from dropdown");

//		passing Dynamic Xpath Statussuggestion
//		Dynamic Xpath Statussuggestion
		WebElement searchAdminUserstatusSuggestion = driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + dataprop.get("Status") + "')]"));
		click(searchAdminUserstatusSuggestion, "Status Suggestion");

		wait_obj.until(ExpectedConditions.visibilityOf(username));
		clearAndSendKeys(username, dataprop.get("AdminUsername"), "Inserted value UserName field ");

		click(searchbutton, "Search button");
		Thread.sleep(5000);

		String searchRecordText = getVisibleText(searchRecordCounts, "Search Record Count"); // value = (1) record found
																								// // , no record found
																							// etc

		String totalRecordFound = searchRecordText.split("\\)")[0].trim().replace("(", "");

		try {
			int totalrecords = Integer.parseInt(totalRecordFound);
			Assert.assertEquals(totalrecords, 1);
			Reporter.log("Verfication Sucessful for total Records !!");
		} catch (Exception e) {
			Assert.assertEquals(totalRecordFound, "1");
			Reporter.log("Verfication Sucessful for total Records !!");
		}

	}

	public void ValidateAdminUser() throws IOException {
//		Properties prop = ReadConfig(
//				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\AddNewUser.properties");
		dataprop = runner.newDataMap;
		
		for (int i = 0; i < adminHeaders.size(); i++) {

			String headerValue = adminHeaders.get(i).getText().trim();
			String dataValue = adminUserDataValues.get(i).getText().trim();

			if (headerValue.equalsIgnoreCase("Username")) {
				Assert.assertTrue(dataValue.contains(dataprop.get("AdminUsername")));
				Reporter.log("Validated UserName as " + dataValue);
			} else if (headerValue.equalsIgnoreCase("User Role")) {
				Assert.assertEquals(dataValue, dataprop.get("UserRole"));
				Reporter.log("Validated UserRole as " + dataValue);
			} else if (headerValue.equalsIgnoreCase("Employee Name")) {
				Assert.assertTrue(dataValue.contains(dataprop.get("EmployeeName")));
				Reporter.log("Validated Employee Name as " + dataValue);
			} else if (headerValue.equalsIgnoreCase("Status")) {
				Assert.assertEquals(dataValue, dataprop.get("Status"));
				Reporter.log("Validated Status as " + dataValue);
			}

		}
	}
	
	public void deleteAdminUser() throws InterruptedException {
		dataprop = runner.newDataMap;
		
		//Delete Admin User
		Thread.sleep(5000);
		click(adminUserdeleteEditIcon.get(0), "Delete icon");
		
		waitForElementToBeVisble(confrimDeleteAlert, 15);
		click(confrimDeleteAlert, "Yes in Delete Alert");
		
		waitForElementToBeVisble(searchRecordCounts, 15);
		String searchRecordText = getVisibleText(searchRecordCounts, "Search Record Count");
		
		Assert.assertEquals(searchRecordText, "No Records Found");
		
		
	}
	
}
