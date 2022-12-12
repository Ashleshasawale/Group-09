package neoOstockBase;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;

import Neo0StockPom.UtilityNew;




public class BaseNew 

{
	
			protected static WebDriver driver;
        	
	public void launchBrowser() throws IOException
	{
	System.setProperty("webdriver.chrome.driver","G:\\chrome\\chromedriver.exe");
	

	 driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(UtilityNew.readDatafromPropertyFile("url"));
    
    Reporter.log("launching the browser",true);
    UtilityNew.wait(driver, 500);
	}
        	
    public void closeBrowser()
    {
    	Reporter.log("closing the browser");
    	UtilityNew.wait(driver, 500);
    	driver.close();
    }
        	
}