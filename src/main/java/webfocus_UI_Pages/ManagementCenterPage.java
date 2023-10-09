package webfocus_UI_Pages;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import testBaseJava.TestBase;
import utilities.TestData;

public class ManagementCenterPage extends TestBase {
	
	
	@FindBy(xpath="(//div[@title=\"Management Center\"])[2]")
	WebElement Management_Center;
	
	@FindBy(xpath="//div[text()=\"Cluster Management Console\"]")
	WebElement Cluster_Management_Console;	
	
	@FindBy(xpath="(//div[@class='tnode-btn wcx-tree-btn-collapsed'])[4]")
	WebElement Configurations;
	
	@FindBy(xpath="//div[contains(text(),\"Container Edition Version\")]")
	WebElement Container_Edition_Version;
	
	@FindBy(xpath="/html/body/pre")
	WebElement Version_CE;
	
	 
	Actions builder = new Actions(driver);
	
	public ManagementCenterPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void check_WFCE_version() throws Throwable
	{
		
		Management_Center.click();
		wait.until(ExpectedConditions.visibilityOf(Cluster_Management_Console));
		Cluster_Management_Console.click();
		Thread.sleep(6000);
	    driver.switchTo().frame(2);
		wait.until(ExpectedConditions.visibilityOf(Configurations));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", Configurations);    
		Configurations.click();
	    wait.until(ExpectedConditions.visibilityOf(Container_Edition_Version));
		builder.doubleClick(Container_Edition_Version).perform();
		Thread.sleep(5000); 
		WebElement myframe1 = driver.findElement(By.xpath("//iframe[@class='ibx-iframe-frame']"));
		driver.switchTo().frame(myframe1);
		String ActlVerCE= Version_CE.getText();
		System.out.println(ActlVerCE);
		String[] words=ActlVerCE.split("\\s");
		 for(int i=0;i<words.length;i++)
	       {
	           System.out.println(words[i]);
	       } 
		 
		 String ActWFversion = words[6];
		 String ActWFbuild = words[7];
		 
		 Assert.assertEquals(ActWFversion, TestData.Exp_WFCE_Version );
		 Assert.assertEquals(ActWFbuild, TestData.Exp_WFCE_build );
		 
	}
	
	

}
