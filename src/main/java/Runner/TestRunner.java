package Runner;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.PimUser;
import Utilities.CommonMethods;

public class TestRunner { 
	//Global declaration of object 
	CommonMethods cm_obj;
	
	@BeforeMethod
	public void Launch() throws InterruptedException, IOException
	{
		cm_obj = new CommonMethods();
		
		cm_obj.LaunchBrowser(); 
	}
	
	@Test (priority = 0)
	public void loginFunctionalityTest() throws InterruptedException, IOException
	{
		
		LoginPage login = new LoginPage(cm_obj.driver , 5);
		
		login.fillLoginDetails();
	}
	
	@Test (priority = 1)
	public void addPimUser() throws InterruptedException, IOException
	{
		LoginPage login = new LoginPage(cm_obj.driver , 5);
		
		login.fillLoginDetails(); 
		
		PimUser addpimuser = new PimUser(cm_obj.driver , 5);
		
		addpimuser.fillpimdata();
	}
	
	@AfterMethod
	public void quitSession()
	{

		cm_obj.driver.quit();
	}
	
	
}
