package webfocus_UI_TestCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBaseJava.TestBase;
import utilities.Utility;
import webfocus_UI_Pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeTest
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validate_LoginPage()
	{
		loginpage.validateWebFoucusPageTitle();
	}
	
	
	@Test(priority=2)
	public void login() throws Throwable
	{
		loginpage.login();
		
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
