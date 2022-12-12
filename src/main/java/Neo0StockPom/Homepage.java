package Neo0StockPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class Homepage {

	@FindBy(xpath="(//a[text()='OK'])[2]")  private WebElement okButton;
	
	@FindBy(xpath="(//a[text()='Close'])[5]") private WebElement CloseButton;
	
	@FindBy(id="lbl_username") private WebElement username ;
	
	
	
	@FindBy(id="lbl_curbalancetop") private WebElement balance;
	
	@FindBy(xpath="//span[text()='Logout']")private WebElement logoutButton ;
	
	
	
	public Homepage(WebDriver driver)
	
	{
		PageFactory.initElements(driver,this);
	}
	
	public void PopUpHandle(WebDriver driver)
	
	{
		
		if(okButton.isDisplayed())
		{
		
		UtilityNew.wait(driver, 1000);
		okButton.click();
		//Utility.Scroll(driver, CloseButton);
		UtilityNew.wait(driver, 1000);
		CloseButton.click();
		Reporter.log("handelling popup..",true);
	    }
		
		else
		{
			UtilityNew.wait(driver, 1000);
			Reporter.log("there is no pop up.",true);
		}
	}
	
	public String getUsername()
	{
		String actualUser = username.getText();
		Reporter.log("getting user name ",true);
		return actualUser;
	}
	
	
	public String balance(WebDriver driver )
	{
		UtilityNew.wait(driver, 1000);
		String actualbalance = balance.getText();
		Reporter.log("getting balance",true);
		return actualbalance;
	}
	
	
	public void Logout(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		username.click();
		UtilityNew.wait(driver, 1000);
		logoutButton.click();
		Reporter.log("logout the application",true);
	}
	
	
}
