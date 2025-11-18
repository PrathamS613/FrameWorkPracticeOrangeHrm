package Runner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.collections.Lists;

import Utilities.ExcelReadUtil;

public class dataRunner {
	public static Map<Integer, Map<String, String>> newExecutionMap ;
	public static Map<String, String> newDataMap = new HashMap<String, String>();

	public static void main(String[] args) throws IOException {
		ExcelReadUtil excell = new ExcelReadUtil();
		newExecutionMap = excell.readDatafromExcel();
		
		// created obj of testNg
		TestNG testng = new TestNG();

		List<String> suites = Lists.newArrayList();
		
		suites.add("C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\testng.xml");

		testng.setTestSuites(suites);
		
		for (int i = 0; i <newExecutionMap.size() ; i++) {
			
			newDataMap = newExecutionMap.get(i);
			
			testng.run();
		 
		}
	}
}
