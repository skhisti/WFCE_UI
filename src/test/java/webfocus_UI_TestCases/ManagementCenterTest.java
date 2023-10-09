package webfocus_UI_TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBaseJava.TestBase;
import utilities.Utility;
import webfocus_UI_Pages.LoginPage;
import webfocus_UI_Pages.ManagementCenterPage;

public class ManagementCenterTest extends TestBase{
	
	ManagementCenterPage managementCenterPage;
	LoginPage loginpage;
	
	@BeforeTest
	public void setup()
	{
		initialization();
		managementCenterPage = new ManagementCenterPage();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void validate_LoginPage() throws Throwable
	{
		//loginpage.validateWebFoucusPageTitle();
		loginpage.login();
	}
	
	
	@Test(priority=2)
	public void validate_WFCE_Version() throws Throwable
	{
		managementCenterPage.check_WFCE_version();
	}
	
	@Test(priority=3)
	public void switchToParentFrame()
	{
		Utility.SwitchToParentFrame();
	}
	
	@Test(priority=4)
	public void ResetView()
	{
		Utility.ResetView();
	}
	
	@Test(priority=5)
	public void SignOut()
	{
		Utility.SignOut();
	}
	

}
