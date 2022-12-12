package Neo0StockPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class Password {

	@FindBy(id="txt_accesspin") private WebElement password;
	@FindBy(xpath="(//a[text()='Submit'])") private WebElement submitButton;
	
	
	
	public  Password(WebDriver driver)
	{
	PageFactory.initElements( driver,this);	
	}
	
	
	


	public  void Sendpassword(WebDriver driver,String code)
	{
		UtilityNew.wait(driver, 500);
		password.sendKeys(code);

		Reporter.log("sending code",true);
	}
	
	public void submit(WebDriver driver)
	{
		//UtilityNew.wait(driver, 500);
		submitButton.click();
		Reporter.log(" clicking on submit",true);
	}
	
	
	
	
	
	
	
}
