package webfocus_UI_Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import testBaseJava.TestBase;
import utilities.Utility;

public class VisualizationPage extends TestBase{

	Actions builder = new Actions(driver);

	@FindBy(xpath="//div[@class='ibx-label-glyph ibx-label-icon ds-icon-plus']")
	WebElement Start_Button;

	@FindBy(xpath="//div[contains(text(),'Create Visualizations')]")
	WebElement Create_Visualization;

	@FindBy(xpath="(//div[@title=\"getting_started\"])[1]")
	WebElement Getting_Started;

	@FindBy(xpath="//div[@title=\"retail_sales.mas\"]")
	WebElement Retail_Sales_mas;

	@FindBy(xpath="//div[text()=\"Sale Date\"]")
	WebElement Sale_Date;

	@FindBy(xpath="//div[text()=\"Store\"]")
	WebElement Store;

	@FindBy(xpath="//div[text()=\"Store Type\"]")
	WebElement Store_Type;

	@FindBy(xpath="//div[text()=\"Product\"]")
	WebElement Product;    

	@FindBy(xpath="//div[text()=\"Product Category\"]")
	WebElement Product_Category;

	@FindBy(xpath="//div[text()=\"Revenue\"]")
	WebElement Revenue;

	@FindBy(xpath="//div[text()=\"Gross Profit\"]")
	WebElement Gross_Profit;

	@FindBy(xpath="(//div[contains(@id,\"ibx-aria-id\") and contains(@title,\"Vertical\")]//div[@class='ibx-label-glyph ibx-label-icon'])[1]")
	WebElement Verticle_Side_Bar_Chart;

	@FindBy(xpath="//div[@title=\"Save\"]//div[contains(@class,\"ibx-label-glyph ibx-label-icon\")]")
	WebElement Save_Button;

	@FindBy(xpath="(//input[@role=\"textbox\"])[6]")
	WebElement Text_Box;

	@FindBy(xpath="(//div[text()=\"Save\"])[3]")
	WebElement Save_Visaulization;  

	@FindBy(xpath="//div[text()=\"My workspace\"]")
	WebElement My_Workspace;     

	@FindBy(xpath="(//div[text()=\"MyTest1\"])[2]")
	WebElement MyTest1;

	@FindBy(xpath="//div[contains(text(),'Geography')]")
	WebElement Geography;    

	@FindBy(xpath="//div[contains(text(),'City')]")
	WebElement City;

	@FindBy(xpath="//div[contains(text(),'Edit')]")
	WebElement Edit_Visualization_Button;
    
	@FindBy(xpath="//div[contains(text(),'Delete')]")
	WebElement Delete_Visualization_Button;

	@FindBy(xpath="//div[text()=\"OK\"]")
	WebElement OK_Button;


	

	public VisualizationPage()
	{
		PageFactory.initElements(driver, this);
	}




	public void Create_Visualization() throws Throwable
	{
		System.out.println(driver.getTitle());
		Start_Button.click();
		vars.put("window_handles", driver.getWindowHandles());
		Create_Visualization.click();
		Thread.sleep(20000);
		vars.put("win8241", Utility.waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win8241").toString());
		//driver.switchTo()
		System.out.println(" ********************************************* ");

		System.out.println(driver.getTitle());

		builder.doubleClick(Getting_Started).perform();
		Thread.sleep(5000);
		builder.doubleClick(Retail_Sales_mas).perform();
		Thread.sleep(10000);
		builder.doubleClick(Sale_Date).perform();
		Thread.sleep(3000);
		builder.doubleClick(Store).perform();
		Thread.sleep(3000);
		builder.doubleClick(Store_Type).perform();
		Thread.sleep(3000);
		builder.doubleClick(Product).perform();
		Thread.sleep(3000);
		builder.doubleClick(Product_Category).perform();
		Thread.sleep(3000);
		builder.doubleClick(Revenue).perform();
		Thread.sleep(3000);
		builder.doubleClick(Gross_Profit).perform();
		Thread.sleep(5000);
		builder.doubleClick(Verticle_Side_Bar_Chart).perform();
		Thread.sleep(5000);
		Save_Button.click();
		Thread.sleep(5000);
		Text_Box.clear();
		Text_Box.sendKeys("MyTest1");
		Save_Visaulization.click();
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(vars.get("root").toString());
		//driver.switchTo().frame(0);
		driver.switchTo().defaultContent();
		Utility.ResetView();
		My_Workspace.click();
		driver.switchTo().frame(0);
		Assert.assertEquals(MyTest1.isDisplayed(),true, "Visualization MyTest1 Not created or saved, please check");
		driver.switchTo().defaultContent();
	}


	public void Edit_Visualization() throws Throwable
	{

		Utility.ResetView();
		My_Workspace.click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		vars.put("window_handles", driver.getWindowHandles());
		builder.contextClick(MyTest1).perform();
		Edit_Visualization_Button.click();
		Thread.sleep(20000);
		vars.put("win1819", Utility.waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win1819").toString());
		System.out.println(" ********************************************* ");

		System.out.println(driver.getTitle());
		builder.doubleClick(Geography).perform();
		Thread.sleep(3000);
		builder.doubleClick(City).perform();
		Thread.sleep(3000);
		Save_Button.click();
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(vars.get("root").toString());
		driver.switchTo().frame(0);	 
		driver.switchTo().defaultContent();
	}
	
	public void DeleteVisualization() throws Throwable
	{
		
		Utility.ResetView();
		My_Workspace.click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		builder.contextClick(MyTest1).perform();
		Delete_Visualization_Button.click();
		Thread.sleep(3000);
		OK_Button.click();
		Thread.sleep(3000);		
		driver.switchTo().defaultContent();
		Utility.ResetView();
		My_Workspace.click();
		driver.switchTo().frame(0);		
		Assert.assertEquals(0, driver.findElements(By.xpath("(//div[text()=\"MyTest1\"])[2]")).size());
		driver.switchTo().defaultContent();
	}


}
