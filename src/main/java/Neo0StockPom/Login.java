package Neo0StockPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class Login {

	@FindBy(xpath="//input[@id='MainContent_signinsignup_txt_mobilenumber']") private WebElement mobNum;
	
	@FindBy(xpath="//a[@id='lnk_signup1']")private WebElement signin;
	
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void sendmob(WebDriver driver,String no)
	
	{
	UtilityNew.wait(driver, 700);
	
	mobNum.sendKeys(no);
	Reporter.log("sending mob no",true);
	
	}
	
	public void signinButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 1500);
		signin.click();
		Reporter.log("click on sign in button ",true);
	}
	
}
