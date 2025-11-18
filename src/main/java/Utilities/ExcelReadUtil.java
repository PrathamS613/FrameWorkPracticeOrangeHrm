package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtil {
	// global declaration
	FileInputStream fs;
	XSSFWorkbook workbook;
	CommonMethods cm = new CommonMethods();

	public List<String> scriptNamelist;
	public List<String> stepKeywordlist;
	public Map<String, List<String>> data;
	public List<String> dataHeaders;
	public Map<Integer, Map<String, String>> exectionMap;
	public Map<String, String> dataMap;
	public List<String> flagData;

	public Map<String, List<String>> readStepKeyword(String SheetName) throws IOException {

		Properties dataprop = cm.ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\config.properties");

		String datafilepath = dataprop.getProperty("DatafilePath");

		fs = new FileInputStream(datafilepath);

		workbook = new XSSFWorkbook(fs);

		Sheet sheet = workbook.getSheet(SheetName);

		int rows = sheet.getLastRowNum();

		int column = sheet.getRow(0).getLastCellNum();

		scriptNamelist = new ArrayList<>();
		stepKeywordlist = new ArrayList<>();

		data = new LinkedHashMap<String, List<String>>();

		for (int i = 0; i < column; i++) {
			String Key = "";
			String Value = "";
			for (int j = 0; j < rows; j++) {
				// Header will be constant 0th row
				Key = sheet.getRow(0).getCell(i).getStringCellValue();

				Value = sheet.getRow(j + 1).getCell(i).getStringCellValue();

				if (Key.equalsIgnoreCase("AutomationScriptName")) {
					scriptNamelist.add(Value);
				} else if (Key.equalsIgnoreCase("StepKeyword")) {
					stepKeywordlist.add(Value);
				}

			}

			if (Key.equalsIgnoreCase("AutomationScriptName")) {
				data.put(Key, scriptNamelist);
			} else if (Key.equalsIgnoreCase("StepKeyword")) {
				data.put(Key, stepKeywordlist);
			}

		}
		return data;
	}

	public void getHeaders() throws IOException {
		Properties dataprop = cm.ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\config.properties");

		String dataFilePath = dataprop.getProperty("DatafilePath");

		fs = new FileInputStream(dataFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);

		Sheet sheet = workbook.getSheet("DataSheet");

		int rows = sheet.getLastRowNum();

		int columns = sheet.getRow(0).getLastCellNum();

		dataHeaders = new ArrayList<String>();

		for (int j = 0; j < columns; j++) {
			// header constant
			String Header = sheet.getRow(0).getCell(j).getStringCellValue();

			dataHeaders.add(Header);
		}

		System.out.println(dataHeaders);

	}

	public Map<Integer, Map<String, String>> readDatafromExcel() throws IOException {
		Properties dataprop = cm.ReadConfig(
				"C:\\Users\\prath\\SeleniumAutomation\\Automation Practicals\\FrameWorkPracticeOrangeHrm\\src\\test\\java\\datafiles\\config.properties");

		String dataFilePath = dataprop.getProperty("DatafilePath");

		fs = new FileInputStream(dataFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);

		Sheet sheet = workbook.getSheet("DataSheet");

		int rows = sheet.getLastRowNum();

		int columns = sheet.getRow(0).getLastCellNum();

		flagData = new ArrayList<String>();

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < columns; j++) {

				String flagValue = sheet.getRow(i).getCell(j).getStringCellValue();

				if (flagValue.equalsIgnoreCase("Execution_Flag")) {
					for (int k = 1; k <= rows; k++) {
						flagData.add(sheet.getRow(k).getCell(j).getStringCellValue());
					}
					break;
				}
			}
			break;
		}

		System.out.println(flagData);

		exectionMap = new HashMap<Integer, Map<String,String>>();
		
		int datacount =0;
		for (int i = 0; i < flagData.size(); i++) {
			dataMap = new HashMap<String, String>();

			for (int j = 0; j < columns; j++) {
 				if (flagData.get(i).equalsIgnoreCase("Yes")) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i + 1).getCell(j).getStringCellValue();
					dataMap.put(key, value);
				}

			}
			//Handeled Null pointer
			if(dataMap!=null && !dataMap.isEmpty())
			{
				exectionMap.put(datacount, dataMap);
				datacount++;
			}
		
		}
		System.out.println(exectionMap);
		return exectionMap;
	}

	public static void main(String[] args) throws IOException {
		ExcelReadUtil obj = new ExcelReadUtil();
		obj.getHeaders();
		obj.readDatafromExcel();
	}

}
