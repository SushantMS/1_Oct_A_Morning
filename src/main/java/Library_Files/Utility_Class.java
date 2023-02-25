package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Utility_Class 
{
	//Automation TE:@Rohit
	//Date:15/02/2023
	//Day:Wednesday
	//Title:Fetch data from property file
	
	@Test
	public static String GetDataFromPF(String key) throws IOException
	{
		//to reach up to property file
		FileInputStream file=new  FileInputStream("C:\\Users\\sushs\\eclipse-workspace\\1_Oct_Maven\\Prop_file.properties");
		
		//to open property file we have call load method
		//load is non-static method from properties class hence to call this method we need object of properties class
		
		Properties prop=new Properties();
		
		//to open property file
		prop.load(file);
		
		//to fetch data from property file
		String value1=prop.getProperty(key);        //EM=saradeg41@gmail.com
		                                            //PSW=Sai@1117
		
		return value1;        //EM=saradeg41@gmail.com         //PSW=Sai@1117    
	}
	
	
	//Automation TE:@Rohit
		//Date:17/02/2023
		//Day:Friday
		//Title:Fetch data from Excel sheet
	
	
	@Test
	public static String getDataFromExcelSheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
	{
		
		
		//to reach up to excel
		FileInputStream file=new FileInputStream("C:\\Users\\sushs\\eclipse-workspace\\1_Oct_Maven\\Test_Data\\1_oct_morning.xlsx ");
			
		//To open an excel sheet
		Sheet sh=WorkbookFactory.create(file).getSheet("Sheet1");
				
		String value2=sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		
		return value2;
		
		
		
		
	}
	
	@Test
	public static void CaptureScreenshot(WebDriver driver,int TestCaseID) throws IOException
	{
		
		//Takes Screenshot of web-page
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		System.out.println(source);
		
		
		File Destination=new File("C:\\Users\\sushs\\eclipse-workspace\\1_Oct_Maven\\Screenshot"+TestCaseID+".jpg");
		
		FileHandler.copy(source,Destination);
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
