package Neo0StockPom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class UtilityNew {
 
	//commonly used method like excel reading,scroll,screenshots,wait
	
	public static String readDatafromPropertyFile(String key) throws IOException
	
	{
		
		//create object of Properties class
		
		Properties prop=new Properties();
		
		//create object of FileInputStream
		
	FileInputStream myFile = new FileInputStream("C:\\Users\\rf pune new\\eclipse-workspace\\selenium\\src\\myproperty.properties");
	
	prop.load(myFile);
	
	String value = prop.getProperty(key);
	
	Reporter.log("reading value of"+key+"from property file",true);
	return value;
	}
	
	
	
	public static void Screenshot(WebDriver driver, String FileName) throws IOException
	
	{
		String a=RandomString.make(2);
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Users\\rf pune new\\Desktop\\material\\AUTOMATION NOTES\\screenshots\\"+FileName+ a+".jpg");
	
	FileHandler.copy(src, dest);
	Reporter.log("Screenshot taken",true);
	}
	
	
	public static void Scroll(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("argument[0].scrollIntoView(true)", element);
		Reporter.log("scrooling into view"+element.getText(),true);
	}
	
	
	public static void wait(WebDriver driver,int waittime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
		Reporter.log("waitingtime"+waittime+"milis",true);
	}
}
