package Runner;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Stepdefination.OrangehrmSteps;
import Utilities.CommonMethods;
 
public class StepRunner  {  
//global declaration
	OrangehrmSteps os = new OrangehrmSteps(); 
	CommonMethods cm = new CommonMethods();
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException, IOException {
		cm.LaunchBrowser();
	}
  
	@Test(priority = 0)
	public void loginTest() throws IOException, InterruptedException {
		os.loginSteps();
		os.LogoutSteps();
	}

	@Test(priority = 1)
	public void addPimuser() throws IOException, InterruptedException {
		os.loginSteps();
		os.PimUsersteps();		
		os.LogoutSteps();
	}
	
	
//	@Test(priority = 2)
//	public void AddNewAdminUser() throws IOException, InterruptedException
//	{
//		os.loginSteps();
//		os.AddAdminUserSteps();
//		os.LogoutSteps();
//	}
	
	@Test(priority =1)
	public void DeleteAdminUser() throws IOException, InterruptedException
	{
		os.loginSteps();
		os.DeleteAdminUser();
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		CommonMethods.driver.quit();
	}
}
