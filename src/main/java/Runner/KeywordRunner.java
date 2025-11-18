package Runner;

import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Stepdefination.OrangehrmSteps;
import Utilities.CommonMethods;
import Utilities.ExcelReadUtil;


public class KeywordRunner {
	OrangehrmSteps os = new OrangehrmSteps();
	CommonMethods cm_obj;
	public dataRunner runner = new dataRunner();
	
	
	@BeforeMethod
	public void Launch() throws InterruptedException, IOException {
		cm_obj = new CommonMethods();

		cm_obj.LaunchBrowser();
	}

	@Test
	public void getGetKeyword() throws IOException, InterruptedException {
		ExcelReadUtil ex_obj = new ExcelReadUtil();
		CommonMethods cm = new CommonMethods(); 
		Properties prop = cm.ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\config.properties");

		String scenerioDesc = runner.newDataMap.get("Scenerio_Description");
		Reporter.log("<div style='text-align:center;color:green;'><strong><i><u>"+scenerioDesc.toUpperCase()+"</u></i></strong></div>");

		
		ex_obj.readStepKeyword("StepKeyword");

		for (int i = 0; i < ex_obj.scriptNamelist.size(); i++) {
			//String scriptName = prop.getProperty("Sceneriotype");
			
			String scriptName = runner.newDataMap.get("AutomationScriptName");
	
			if (ex_obj.scriptNamelist.get(i).equalsIgnoreCase(scriptName)) {
				String keyword = ex_obj.stepKeywordlist.get(i);

				if (keyword.equalsIgnoreCase("Login")) {
					Reporter.log("<div style='text-align:left;color:blue;'><strong><i><u>Login Steps</u></i></strong></div>");
					os.loginSteps();
				} 
				else if (keyword.equalsIgnoreCase("AddPimUser")) {
					Reporter.log("<div style='text-align:left;color:blue;'><strong><i><u>Adding Pim User Steps</u></i></strong></div>");
					os.PimUsersteps();
				} 
				else if (keyword.equalsIgnoreCase("AddAdminUser")) {
					Reporter.log("<div style='text-align:left;color:blue;'><strong><i><u>Adding Admin User Steps</u></i></strong></div>");
					os.AddAdminUserSteps();
				} 
				else if (keyword.equalsIgnoreCase("ValidateAdminUser")) {
					Reporter.log("<div style='text-align:left;color:blue;'><strong><i><u> Validating Admin User Steps</u></i></strong></div>");
					os.ValidateAdminUser();
				}
				else if (keyword.equalsIgnoreCase("DeleteAdminUser"))
				{
					Reporter.log("<div style='text-align:left;color:blue;'><strong><i><u> Delete Admin User Steps</u></i></strong></div>");
					os.DeleteAdminUser();
				}
				else if (keyword.equalsIgnoreCase("logoff")) {
					Reporter.log("<div style='text-align:left;color:blue;'><strong><i><u> Logoff Steps</u></i></strong></div>");
					os.LogoutSteps();
				}
			}
		}
	}

	@AfterMethod
	public void quitSession() {

		cm_obj.driver.quit();
	}
}
