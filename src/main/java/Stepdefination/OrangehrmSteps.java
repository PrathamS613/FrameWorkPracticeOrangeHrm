package Stepdefination;

import java.io.IOException;

import Pages.LoginPage;
import Pages.Logout;
import Pages.PimUser;
import Pages.AdminUser;
import Utilities.CommonMethods;

//These will run as an intermideateor in between Runner and Pages
public class OrangehrmSteps { 

	public void loginSteps() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(CommonMethods.driver, 10);
		lp.fillLoginDetails();
	}

	public void PimUsersteps() throws IOException, InterruptedException {
		PimUser pm = new PimUser(CommonMethods.driver, 20);
		pm.fillpimdata();
		pm.PimAddContactDetails(); 
		pm.PimAddEmergencyContactDetails();
		pm.PimAddDependentDetails();
		pm.PimAddimmigrationDetails();
		pm.PimAddJobsDetails();
		pm.PimAddSalaryDetails();
		pm.PimAddReportToDetails();
		pm.PimAddQualificationDetails();
		pm.PimAddMembershipsDetails();
	}

	public void AddAdminUserSteps() throws IOException, InterruptedException {
	 AdminUser aup = new AdminUser(CommonMethods.driver, 10);
	 aup.FillAddUserDetails();
	}
	
	public void ValidateAdminUser() throws IOException, InterruptedException
	{
		AdminUser aup = new AdminUser(CommonMethods.driver, 10);
		aup.searchAdminUser();
		aup.ValidateAdminUser();
		
	}
	
	public void DeleteAdminUser() throws InterruptedException
	{
		AdminUser aup = new AdminUser(CommonMethods.driver, 10);
		aup.deleteAdminUser();
	}
	
	
	public void LogoutSteps()
	{
		Logout lg = new Logout(CommonMethods.driver, 10);
		lg.logoutApplication();
	}

} 
