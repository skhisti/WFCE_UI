package webfocus_UI_TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBaseJava.TestBase;
import utilities.Utility;
import webfocus_UI_Pages.LoginPage;
import webfocus_UI_Pages.ManagementCenterPage;
import webfocus_UI_Pages.VisualizationPage;

public class VisualizationTest extends TestBase {

	ManagementCenterPage managementCenterPage;
	LoginPage loginpage;
	VisualizationPage visualizationpage;


	@BeforeTest
	public void setup()
	{
		initialization();
		managementCenterPage = new ManagementCenterPage();
		loginpage = new LoginPage();
		visualizationpage = new VisualizationPage();
	}


	@Test(priority=1)
	public void validate_LoginPage() throws Throwable
	{
		//loginpage.validateWebFoucusPageTitle();
		loginpage.login();
	}

	@Test(priority=2)
	public void Create_Visualization() throws Throwable
	{
		visualizationpage.Create_Visualization();

	}


	@Test(priority=3)
	public void Edit_Visulization() throws Throwable
	{
		visualizationpage.Edit_Visualization();
	}


	@Test(priority=4)
	public void Delete_Visulization() throws Throwable
	{
		visualizationpage.DeleteVisualization();
	}

	@Test(priority=5)
	public void SignOut()
	{
		Utility.SignOut();
	}

}
