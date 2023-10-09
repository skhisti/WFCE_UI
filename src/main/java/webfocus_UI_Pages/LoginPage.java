package webfocus_UI_Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import testBaseJava.TestBase;

public class LoginPage extends TestBase{


	String ExpectedLoginPageTitle = "ibi™ WebFOCUS® Login Page";
	String Username = "secret";
	String Password = "terces";

	@FindBy(xpath="//input[@name=\"uname\"]")
	WebElement username;


	@FindBy(xpath="//input[@name=\"psw\"]")
	WebElement password;


	@FindBy(xpath="//div[@id=\"SignonbtnLogin\"]")
	WebElement sign_in_Button;



	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}	

	public void validateWebFoucusPageTitle(){
		String ActualTitle=driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedLoginPageTitle, "Page not loaded correctly, check webfocus UI URL(hostname or IP address is correct or not) in config.properties else Webfocus CE deployments failed........" );
	}

	public void login() throws Throwable
	{
		username.sendKeys(Username);
		password.sendKeys(Password);
		sign_in_Button.click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.getTitle(), "ibi™ WebFOCUS® Hub");


	}

}
