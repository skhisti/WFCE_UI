package testBaseJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait ;
	public static Map<String, Object> vars;


	
	public TestBase(){
		
		try {
			prop = new Properties();
			//FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/appconfig/qa/config/config.properties");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		 vars = new HashMap<String, Object>();
		
		if(browserName.equalsIgnoreCase("chrome")){
			
			driver = new ChromeDriver(); 
		}
		else if(browserName.equalsIgnoreCase("FF") || browserName.equalsIgnoreCase("Firefox")){
			
			driver = new FirefoxDriver(); 
		}
		
      else if(browserName.equalsIgnoreCase("edge") || browserName.equalsIgnoreCase("edge")){
			
    	  driver = new EdgeDriver();
		}
	
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		//return driver;		
	}
}
