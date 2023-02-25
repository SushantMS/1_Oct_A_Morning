package Module1_Home_Test_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.Base_Class;
import Library_Files.Utility_Class;
import Module1_Home.Insurance_Broker_Insurance_Webpage;
import Module1_Home.Insurance_Login;

public class TestNG_TestClass extends Base_Class
{
	//public WebDriver driver
	//InitializeBrowser()
	
	Insurance_Login Login;
	
	Insurance_Broker_Insurance_Webpage Broker;
	
	int TestCaseID;
	
	@BeforeClass
	public void OpenBrowser() 
	{
		InitializeBrowser();
		
		//Create Object Of POM-I Class
		Login=new Insurance_Login(driver);
		
		//Create object of POM-II Class
        Broker=new Insurance_Broker_Insurance_Webpage(driver);
        
        
		
	}
	
	
	@BeforeMethod
	public void loginToApp() throws IOException 
	{
		Login.EnterEmail(Utility_Class.GetDataFromPF("EM"));
		
		Login.EnterPassowrd(Utility_Class.GetDataFromPF("PSW"));
		
		Login.ClickLoginBtn();
	}
	
	@Test(priority=1)                                 //Test Case/method
	public void TC1() throws EncryptedDocumentException, IOException 
	{
		
		TestCaseID=01;
		//verify Email Address
		
		String ActualEmail=Broker.getEmail();
		
		String ExpectedEmail=Utility_Class.getDataFromExcelSheet(2,0);
		
		
		Assert.assertEquals(ActualEmail, ExpectedEmail);
		
		
		
	}
	
	@Test(priority=2)
	public void VerifyTitle() throws EncryptedDocumentException, IOException
	{
		
		TestCaseID=02;
		Assert.fail();
		String ActualTitle=driver.getTitle();           //Insurance Broker System
		
		
		String ExpectedTitle=Utility_Class.getDataFromExcelSheet(3, 0);
		
		Assert.assertEquals(ActualTitle,ExpectedTitle);
		
	}

	@AfterMethod
	public void LogoutFromApp(ITestResult Result) throws IOException    //ITestResult is a  Listner OR Interface
	{
		
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.CaptureScreenshot(driver,TestCaseID);
		}
		
		
		
		Broker.ClickLogoutBtn();
	}
	
	@AfterClass
	public void CloseBrowser() 
	{
		driver.close();
	}
	
	

}
