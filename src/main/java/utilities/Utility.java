package utilities;

import java.util.Set;

import org.openqa.selenium.By;

import testBaseJava.TestBase;


public class Utility extends TestBase{
	
		
	
	public static void SwitchToParentFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	
	public static void ResetView()
	{
		driver.findElement(By.xpath("//div[@class='ibx-label-glyph ibx-label-icon ds-icon-user-male']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Reset View')]")).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void SignOut()
	{
		
		driver.findElement(By.xpath("//div[@class='ibx-label-glyph ibx-label-icon ds-icon-user-male']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Sign Out')]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}
	
	public static String waitForWindow(int timeout) {
	    try {
	      Thread.sleep(timeout);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    Set<String> whNow = driver.getWindowHandles();
	    Set<String> whThen = (Set<String>)vars.get("window_handles");
	    if (whNow.size() > whThen.size()) {
	      whNow.removeAll(whThen);
	    }
	    return whNow.iterator().next();
	  }
	
	
	 
	

}
