package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonMethods;

public class PimUser extends CommonMethods {

	
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][contains(.,'PIM')]")
	WebElement pimButton;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement AddUser;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@name='middleName']")
	WebElement MiddleName;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement LastName;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement SaveButton;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement Personal_Details_SaveButton;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text']")
	WebElement PersonalDetailsAttachmentButton;

	// @FindBy(xpath = "//label[contains(text(),'Select
	// File')]/following::div[contains(text(),'Browse')]")

	@FindBy(xpath = "(//button[@type='submit'])[3]")
	WebElement AddAttachmentSaveButtonPersonaldetails;

	// Elements for Contact details Xpaths
	@FindBy(xpath = "//a[contains(text(),'Contact Details')]")
	WebElement contactDetailsbutton;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement street1Textfield;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement street2Textfield;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement contactDetailssaveButton;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text']")
	WebElement contactDetailsAddbutton;

	@FindBy(xpath = "//input[@type='file']")
	WebElement UploadFileField;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]")
	WebElement contactSavebutton;

	// Elements for Emergency contact tab
	@FindBy(xpath = "//a[contains(text(),'Emergency Contacts')]")
	WebElement emergencyContactButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
	WebElement emergencyContactaddButton;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement emergencyContactNameTextField;

	@FindBy(xpath = "//label[contains(text(),'Relationship')]/following::input[1]")
	WebElement emergencyContactRelationshipTextField;

	@FindBy(xpath = "//input[@modelmodifiers='[object Object]']")
	WebElement emergencyContactHomeTelephoneTextField;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement emergencyContactSaveButton1;

	@FindBy(xpath = "(//button[@type='button'][contains(.,'Add')])[2]")
	WebElement emergencyContactAddbutton;

	// Xpath from dependents
	@FindBy(xpath = "//a[contains(text(),'Dependents')]")
	WebElement dependentsbutton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
	WebElement AssignedDependentsAddButton;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement AssignedDependentsNameTextfield;

	@FindBy(xpath = "//label[contains(text(),'Relationship')]/following::div[contains(text(),'Select')]")
	WebElement dependentsRealationshipdropwdownClick;

	@FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'Child')]")
	WebElement dependentsRealationshipChildOption;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement dependentsAddDependentSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[2]")
	WebElement dependentsAddButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement dependentSavebutton;

	// Immigration Xpaths
	@FindBy(xpath = "//a[contains(text(),'Immigration')]")
	WebElement immigrationButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
	WebElement immigrationAddButton;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement immigrationNumber;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement immigrationSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[2]")
	WebElement immigrationAddAttachmebutton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement immigrationSaveButton2;

	// Jobs-xpaths
	@FindBy(xpath = "//a[contains(text(),'Job')]")
	WebElement JobButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement JobSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
	WebElement JobAddButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]")
	WebElement JobSaveButton2;

	// Salary-Xpaths
	@FindBy(xpath = "//a[contains(text(),'Salary')]")
	WebElement SalaryButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
	WebElement SalaryAssignedSalaryComponentsAddButton;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement SalaryComponentTextField;

	@FindBy(xpath = "//label[contains(text(),'Currency')]/following::div[contains(text(),'Select')]")
	WebElement SalaryCurrencydropwdownclick;

	@FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'CFP Franc')]")
	WebElement SalaryCurrencydropwdownCurrencyValue;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement SalaryAmountTextfield;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement SalarySaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[2]")
	WebElement SalaryAddAttachmentButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement SalarysaveButton;

	// Report to Tab
	@FindBy(xpath = "//a[contains(text(),'Report-to')]")
	WebElement reportToButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
	WebElement reportToAssignedSupervisorsAddButton;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement reportToNametextfield;

	@FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'James  Butler')]")
	WebElement reportToNameoption;

	@FindBy(xpath = "//label[contains(text(),'Reporting Method')]/following::div[contains(text(),'Select')]")
	WebElement reportToReportingMethodSelect;

	@FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'Indirect')]")
	WebElement reportToReportinDropdownOptionIndierect;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement reportToSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[2]")
	WebElement reportToAssignedSubordinatesAddButton;

	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	WebElement reportToAssignedSubordinatesNameTextField;

	@FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'Joseph')]")
	WebElement reportToAssignedSubordinateNameOption;

	@FindBy(xpath = "//label[contains(text(),'Reporting Method')]/following::div[contains(text(),'Select')]")
	WebElement reportToReportingMethodSelectDropdown;

	@FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'Direct')]")
	WebElement reportToReportingMethodvalueTestReporting;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement reportToAddSubordinateSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[3]")
	WebElement reportToAddAttachment;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement reportToAttachmentSavebutton;

//     Qualification-Tab xpaths 
	@FindBy(xpath = "//a[contains(text(),'Qualifications')]")
	WebElement Qualificationbutton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
	WebElement workexperienceaddbutton;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement CompanyTextfield;

	@FindBy(xpath = "//label[contains(text(),'Job Title')]//following::input[1]")
	WebElement jobTitleTextfield;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement WorkExperienceSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[2]")
	WebElement WorkExperienceeAddButton;

	@FindBy(xpath = "//label[contains(text(),'Level')]//following::div[contains(text(),'-- Select --')]")
	WebElement WorkExperienceeAddEducationSelectDropdown;

	@FindBy(xpath = "//div[@role='listbox']//*[contains(text(),'College Undergraduate')]")
	WebElement WorkExperienceeLevelSelectedValuefromDropdown;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement AddEducationSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[3]")
	WebElement SkillsAddButton;

	@FindBy(xpath = "//label[contains(text(),'Skill')]/following::div[contains(text(),'-- Select --')]")
	WebElement SkilldropdownSelectclick;

	@FindBy(xpath = "//div[@role = 'listbox']//*[contains(text(),'G Suite')]")
	WebElement SkilldropdownValue;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement SkillSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[4]")
	WebElement LanguageAddButton;

	@FindBy(xpath = "//label[contains(text(),'Language')]/following::div[contains(text(),'-- Select --')]")
	WebElement LanguageDropdownSelect;

	@FindBy(xpath = "//div[@role = 'listbox']//*[contains(text(),'English')]")
	WebElement LanguageDropdownValue;

	@FindBy(xpath = "//label[contains(text(),'Fluency')]/following::div[contains(text(),'-- Select --')]")
	WebElement LanguageFluencyDropdownSelect;

	@FindBy(xpath = "//div[@role = 'listbox']//*[contains(text(),'Writing')]")
	WebElement LanguageFluencyDropdownValue;

	@FindBy(xpath = "//label[contains(text(),'Competency')]/following::div[contains(text(),'-- Select --')]")
	WebElement LanguageCompetencyDropwdownSelect;

	@FindBy(xpath = "//div[@role = 'listbox']//*[contains(text(),'Good')]")
	WebElement LanguageCompetencyDropwdownValue;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement LanguageSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[5]")
	WebElement LicenseAddButton;

	@FindBy(xpath = "//label[contains(text(),'License Type')]/following::div[contains(text(),'-- Select --')]")
	WebElement LicenseTypeDropdownSelect;

	@FindBy(xpath = "//div[@role = 'listbox']//*[contains(text(),'Certified Information Security Manager (CISM)')]")
	WebElement LicenseTypeDropdownValue;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement LicenseSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[6]")
	WebElement LicenseAddAttachmentButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement LicenseAddAttachmentSaveButton;

	// Memberships-Tab Xpaths
	@FindBy(xpath = "//a[contains(text(),'Memberships')]")
	WebElement MembershipsButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[1]")
	WebElement MembershipsAddButton;

	@FindBy(xpath = "//label[contains(text(),'Membership')]/following::div[contains(text(),'-- Select --')]")
	WebElement MembershipsDropdownSelect;

	@FindBy(xpath = "//div[@role = 'listbox']//*[contains(text(),'British Computer Society (BCS)')]")
	WebElement MembershipsDropdownValue;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement MembershipsSaveButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text'])[2]")
	WebElement MembershipAddAttachmentButton;

	@FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	WebElement MembershipsFileSaveButton;

	// constructor
	public PimUser(WebDriver driver, int waittime) {
		// initalized Webdriver declartaion in Common method
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waittime));
		PageFactory.initElements(driver, this);
	}

	// method for inputting data in Pim
	public void fillpimdata() throws IOException, InterruptedException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		// using wait from constructor
		// wait_obj.until(ExpectedConditions.elementToBeClickable(pimButton));
//		waitElementToBeClickable(pimButton, 5);
//		pimButton.click();
		waitElementToBeClickable(pimButton, 20);
		click(pimButton, "Pim Menu");

		// Calling common wait method from Base class
//		waitElementToBeClickable(AddUser, 5);
//		AddUser.click();
		waitElementToBeClickable(AddUser, 20);
		click(AddUser, "Add User Button");

		// Calling common wait method from Base class
//		waitForElementToBeVisble(FirstName, 5);
//		FirstName.sendKeys(prop.getProperty("FirstName"));
		waitForElementToBeVisble(FirstName, 20);
		clearAndSendKeys(FirstName, prop.getProperty("FirstName"), "First Name Textfield");

		// using wait from constructor
		// wait_obj.until(ExpectedConditions.visibilityOf(MiddleName));
		// Calling common wait method from Base class
//		waitForElementToBeVisble(MiddleName, 5);
//		MiddleName.sendKeys(prop.getProperty("middleName"));
		clearAndSendKeys(MiddleName, prop.getProperty("middleName"), "MiddleName Textfield");

		// using wait from constructor
		// wait_obj.until(ExpectedConditions.visibilityOf(LastName));
		// Calling common wait method from Base class
//		waitForElementToBeVisble(LastName, 5);
//		LastName.sendKeys(prop.getProperty("LastName"));
		clearAndSendKeys(LastName, prop.getProperty("LastName"), "LastName Textfield");

		// using wait from constructor
		// wait_obj.until(ExpectedConditions.elementToBeClickable(SaveButton));
		// Calling common wait method from Base class
//		waitElementToBeClickable(SaveButton, 5);
//		SaveButton.click();
		click(SaveButton, "Save Button");
		System.out.println("Pim User Added Sucessfull !!");
		Thread.sleep(10000);
		click(Personal_Details_SaveButton, "Save Button");

		scrollToElement(PersonalDetailsAttachmentButton);

		click(PersonalDetailsAttachmentButton, "Add button");

		attachFile(UploadFileField, "Attach File", prop.getProperty("ExcellFileAttach"));

		click(AddAttachmentSaveButtonPersonaldetails, "Add attachment Save Button");

	}

	public void PimAddContactDetails() throws InterruptedException, IOException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		Thread.sleep(5000);
		// Contact details -method to be created
		scrollToElement(contactDetailsbutton);
		waitElementToBeClickable(contactDetailsbutton, 20);
		click(contactDetailsbutton, "Contact Details Button");

		waitForElementToBeVisble(street1Textfield, 20);
		clearAndSendKeys(street1Textfield, prop.getProperty("Street1"), "Street 1 Textfield");

		clearAndSendKeys(street2Textfield, prop.getProperty("Street2"), "Street 2 Textfield");

		click(contactDetailssaveButton, "Save Button");

		scrollToElement(contactDetailsAddbutton);
		click(contactDetailsAddbutton, "Add Button");

		attachFile(UploadFileField, "Attach file for Contact details ", prop.getProperty("ExcellFileAttach"));

		click(contactSavebutton, "Contact details Save button");
		Thread.sleep(10000);
	}

	// Emergency contact tab
	public void PimAddEmergencyContactDetails() throws InterruptedException, IOException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		Thread.sleep(10000);
		scrollUpToElement();
		waitForElementToBeVisble(emergencyContactButton, 30);
		click(emergencyContactButton, "Emergency Contact Button");

		click(emergencyContactaddButton, "Emergency Contact ADD Button");

		waitElementToBeClickable(emergencyContactNameTextField, 20);
		clearAndSendKeys(emergencyContactNameTextField, prop.getProperty("NameTextField"),
				"emergency Contact Name TextField");

		clearAndSendKeys(emergencyContactRelationshipTextField,
				prop.getProperty("emergencyContactRelationshipTextField"), "emergency Contact Relationship TextField");

		clearAndSendKeys(emergencyContactHomeTelephoneTextField,
				prop.getProperty("emergencyContactHomeTelephoneTextField"),
				"emergency Contact Home Telephone TextField");

		waitForElementToBeVisble(emergencyContactSaveButton1, 30);
		click(emergencyContactSaveButton1, "emergency Contact Save Button");

		scrollToElement(emergencyContactAddbutton);

		click(emergencyContactAddbutton, "emergency Contact ADD  Button ");
		Thread.sleep(10000);
	//	waitForElementToBeVisble(UploadFileField, 20);
		attachFile(UploadFileField, "Attach file for emergency Contact", prop.getProperty("ExcellFileAttach"));

		waitForElementToBeVisble(emergencyContactSaveButton1, 20);
		click(emergencyContactSaveButton1, "Emergency Contact Save Button");

	}

//	Dependent -method to be created 
	public void PimAddDependentDetails() throws InterruptedException, IOException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		scrollToElement(dependentsbutton);
		waitElementToBeClickable(dependentsbutton, 20);
		click(dependentsbutton, "Dependent Button");

		click(AssignedDependentsAddButton, " Assigned Dependents AddButton");

		clearAndSendKeys(AssignedDependentsNameTextfield, prop.getProperty("AssignedDependentsNameTextfield"),
				"Assigned Dependents Name Textfield");

		waitElementToBeClickable(dependentsRealationshipdropwdownClick, 20);
		click(dependentsRealationshipdropwdownClick, "dependents Realationship dropwdownClick");

		waitElementToBeClickable(dependentsRealationshipChildOption, 20);
		click(dependentsRealationshipChildOption, "dependents Realationship Child Option");

		waitElementToBeClickable(dependentsAddDependentSaveButton, 20);
		click(dependentsAddDependentSaveButton, "dependents Add Dependent SaveButton");

		scrollToElement(dependentsAddButton);
		click(dependentsAddButton, "dependents Add Button");

		attachFile(UploadFileField, "Attached file for dependents ", prop.getProperty("ExcellFileAttach"));

		click(dependentSavebutton, "dependent Save button");

	}

//	immigration -method
	public void PimAddimmigrationDetails() throws InterruptedException, IOException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		scrollToElement(immigrationButton);
		waitElementToBeClickable(immigrationButton, 20);
		click(immigrationButton, "Imigration Button");

		click(immigrationAddButton, "Immigration AddButton");

		clearAndSendKeys(immigrationNumber, prop.getProperty("immigrationNumber"), "immigration Number ");

		click(immigrationSaveButton, "Immigration SaveButton ");

		scrollToElement(immigrationAddAttachmebutton);
		click(immigrationAddAttachmebutton, "immigration Add Attachmet button ");

		attachFile(UploadFileField, "Attached file from Immigrants ", prop.getProperty("ExcellFileAttach"));

		click(immigrationSaveButton2, "Attachment Immigration Save Button ");
	}

	// Jobs-Methods
	public void PimAddJobsDetails() throws InterruptedException, IOException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		waitElementToBeClickable(JobButton, 20);
		click(JobButton, "Job Button");

		click(JobSaveButton, "Save Button");

		scrollToElement(JobAddButton);
		click(JobAddButton, "Job Add Button");

		attachFile(UploadFileField, "Attached file for Jobs", prop.getProperty("ExcellFileAttach"));

		click(JobSaveButton2, "Job Save Button ");

	}

	// Salary-Xpaths
	public void PimAddSalaryDetails() throws InterruptedException, IOException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		scrollToElement(SalaryButton);
		waitElementToBeClickable(SalaryButton, 20);
		click(SalaryButton, "Salary Button");

		click(SalaryAssignedSalaryComponentsAddButton, "Salary Assigned Salary Components AddButton");

		clearAndSendKeys(SalaryComponentTextField, prop.getProperty("SalaryComponentField"),
				"Salary Component TextField");

		click(SalaryCurrencydropwdownclick, "Salary Currency dropwdown click");

		click(SalaryCurrencydropwdownCurrencyValue, "Selected Currency value");

		clearAndSendKeys(SalaryAmountTextfield, prop.getProperty("SalaryAmountTextfield"), "Salary Amount Textfield");

		click(SalarySaveButton, "Salary Save Button");

		scrollToElement(SalaryAddAttachmentButton);
		click(SalaryAddAttachmentButton, "Salary AddAttachment Button");

		attachFile(UploadFileField, "Attached file for Salary", prop.getProperty("ExcellFileAttach"));

		click(SalarysaveButton, "Salary Attached save Button");
	}

	// Report to Method
	public void PimAddReportToDetails() throws InterruptedException, IOException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		scrollToElement(reportToButton);
		click(reportToButton, "report To Button");

		click(reportToAssignedSupervisorsAddButton, "reportTo Assigned Supervisors AddButton");

		clearAndSendKeys(reportToNametextfield, prop.getProperty("AddSupervisorNameTextfield"),
				"Add Supervisor Name Textfield");

		click(reportToNameoption, "report To Name textfield Selected from option");

		click(reportToReportingMethodSelect, "Select");

		click(reportToReportinDropdownOptionIndierect, "Indirect value");

		click(reportToSaveButton, "report To SaveButton");

		waitElementToBeClickable(reportToAssignedSubordinatesAddButton, 20);
		click(reportToAssignedSubordinatesAddButton, "reportTo AssignedSubordinates AddButton");
		
		Thread.sleep(5000);
		scrollToElement(reportToAssignedSubordinatesNameTextField);
//		waitForElementToBeVisble(AddAttachmentSaveButtonPersonaldetails, 20);
		clearAndSendKeys(reportToAssignedSubordinatesNameTextField,
				prop.getProperty("AssignedNameSubordinatesTextField"), "Assigned Name Subordinates TextField");

		click(reportToAssignedSubordinateNameOption, "report ToAssigned Subordinate textfield Selected from option");

		click(reportToReportingMethodSelectDropdown, "reportTo ReportingMethod Select Dropdown");

		click(reportToReportingMethodvalueTestReporting, "report ToReporting Method Selected value from options ");

		click(reportToAddSubordinateSaveButton, "report To Add Subordinate SaveButton");

		scrollToElement(reportToAddAttachment);
		click(reportToAddAttachment, "report To Add Attachment");

		attachFile(UploadFileField, "Attached file report To", prop.getProperty("ExcellFileAttach"));

		click(reportToAttachmentSavebutton, "report ToAttachment Savebutton");
	}

	// Qualification
	public void PimAddQualificationDetails() throws InterruptedException, IOException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		scrollToElement(Qualificationbutton);
		waitForElementToBeVisble(Qualificationbutton, 20);
		click(Qualificationbutton, "Qualification button");

		click(workexperienceaddbutton, "workexperience add button");

		clearAndSendKeys(CompanyTextfield, prop.getProperty("CompanyName"), " Company Text field");

		clearAndSendKeys(jobTitleTextfield, prop.getProperty("JobTitle"), "job Title Text field");

		click(WorkExperienceSaveButton, "Work Experience SaveButton");

		scrollToElement(WorkExperienceeAddButton);
		waitElementToBeClickable(WorkExperienceeAddButton, 20);
		click(WorkExperienceeAddButton, "Work Experiencee Add Button");

		waitElementToBeClickable(WorkExperienceeAddEducationSelectDropdown, 20);
		click(WorkExperienceeAddEducationSelectDropdown, "WorkExperiencee AddEducation SelectDropdown");

		
		waitElementToBeClickable(WorkExperienceeLevelSelectedValuefromDropdown, 20);
		click(WorkExperienceeLevelSelectedValuefromDropdown, "Work Experiencee Level Selected Value from Dropdown");

		Thread.sleep(5000);
		waitElementToBeClickable(AddEducationSaveButton, 20);
		click(AddEducationSaveButton, "Add Education Save Button");

		scrollToElement(SkillsAddButton);
		waitElementToBeClickable(SkillsAddButton, 20);
		click(SkillsAddButton, "Skills Add Button");

		waitElementToBeClickable(SkilldropdownSelectclick, 20);
		click(SkilldropdownSelectclick, " Skill dropdown Select click");

		waitElementToBeClickable(SkilldropdownValue, 20);
		click(SkilldropdownValue, "Skill dropdown Value");
		Thread.sleep(5000);
		click(SkillSaveButton, "Skill Save Button");

		scrollToElement(LanguageAddButton);
		waitElementToBeClickable(LanguageAddButton, 20);
		click(LanguageAddButton, "Language Add Button");
		Thread.sleep(5000);
		waitElementToBeClickable(LanguageDropdownSelect, 20);
		click(LanguageDropdownSelect, "Language Dropdown Select");

		waitElementToBeClickable(LanguageDropdownValue, 20);
		click(LanguageDropdownValue, "Language Dropdown Value");

		waitElementToBeClickable(LanguageFluencyDropdownSelect, 20);
		click(LanguageFluencyDropdownSelect, "Language Fluency Dropdown Select");

		waitElementToBeClickable(LanguageFluencyDropdownValue, 20);
		click(LanguageFluencyDropdownValue, "Language Fluency Dropdown Value");

		waitElementToBeClickable(LanguageCompetencyDropwdownSelect, 20);
		click(LanguageCompetencyDropwdownSelect, "Language Competency Dropwdown Select");

		waitElementToBeClickable(LanguageCompetencyDropwdownValue, 20);
		click(LanguageCompetencyDropwdownValue, "Language Competency Dropwdown ValueGood");
		Thread.sleep(5000);
		click(LanguageSaveButton, "Language Save Button");

		scrollToElement(LicenseAddButton);
		waitElementToBeClickable(LicenseAddButton, 20);
		click(LicenseAddButton, "License Add Button");

		waitElementToBeClickable(LicenseTypeDropdownSelect, 20);
		click(LicenseTypeDropdownSelect, "License Type Dropdown Select");

		waitElementToBeClickable(LicenseTypeDropdownValue, 20);
		click(LicenseTypeDropdownValue, "License Type Dropdown Vaue");
		Thread.sleep(5000);
		click(LicenseSaveButton, "License Save Button");

		scrollToElement(LicenseAddAttachmentButton);
		waitElementToBeClickable(LicenseAddAttachmentButton, 20);
		click(LicenseAddAttachmentButton, "License Add Attachment Button");

		Thread.sleep(10000);
		scrollToElement(UploadFileField);
		attachFile(UploadFileField, "License File Input", prop.getProperty("ExcellFileAttach"));
		
		Thread.sleep(10000);
		scrollToElement(LicenseAddAttachmentSaveButton);
		click(LicenseAddAttachmentSaveButton, "License Add Attachment SaveButton");
		
	}

	// Memberships Tab
	public void PimAddMembershipsDetails() throws InterruptedException, IOException {
		Properties prop = ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\data.properties");
		Thread.sleep(10000);
		scrollToElement(MembershipsButton);
		waitElementToBeClickable(MembershipsButton, 20);
		click(MembershipsButton, "Memberships Button");

		click(MembershipsAddButton, "Memberships AddButton");

		click(MembershipsDropdownSelect, "Memberships Dropdown Select");

		click(MembershipsDropdownValue, "Memberships Dropdown Value");

		click(MembershipsSaveButton, "Memberships Save Button");
		
		Thread.sleep(10000);
		scrollToElement(MembershipAddAttachmentButton);
		click(MembershipAddAttachmentButton, "Membership Add Attachment Button");

		Thread.sleep(10000);
		scrollToElement(UploadFileField);
		attachFile(UploadFileField, "Membership File Input", prop.getProperty("ExcellFileAttach"));

		click(MembershipsFileSaveButton, "Memberships File Save Button");
	}

}
