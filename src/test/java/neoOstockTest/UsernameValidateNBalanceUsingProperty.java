package neoOstockTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Neo0StockPom.Homepage;
import Neo0StockPom.Login;
import Neo0StockPom.Password;
import Neo0StockPom.Start;
import Neo0StockPom.UtilityNew;
import neoOstockBase.BaseNew;
@Listeners(neoOstockListener.Listener.class)
public class UsernameValidateNBalanceUsingProperty extends BaseNew
{
	Login login;
	Password password;
	Homepage homepage;
Start St;
	
	
@BeforeClass
public  void launchNeostock() throws IOException
{
	launchBrowser();
	 login = new Login(driver);
	password=new Password(driver);
	homepage=new Homepage(driver);
	St=new Start(driver);
	
}
	
	@BeforeMethod
	public void loginNeoStock() throws InterruptedException, EncryptedDocumentException, IOException
	{
		St.Click(driver);
		login.sendmob(driver,UtilityNew.readDatafromPropertyFile("mobNum"));
		Thread.sleep(1000);
		login.signinButton(driver);
		Thread.sleep(1000);
		
		
		password.Sendpassword(driver,UtilityNew.readDatafromPropertyFile("passcode"));
		password.submit(driver);
		
		
		homepage.PopUpHandle(driver);
	}
	
	
  @Test
  public void ValidateUserName() throws EncryptedDocumentException, IOException 
  {
	  
	 Assert.assertEquals(homepage.getUsername(),UtilityNew.readDatafromPropertyFile("userName"),"TC is failed Actual and expected Username is not same"); 

	  
  }
  @Test
  public void Balance() throws EncryptedDocumentException, IOException 
  {
	  
	 Assert.assertNotNull(homepage.balance(driver));
	
	  Reporter.log("Ac balance is "+homepage.balance(driver),true);
	  
  }
  
  
  @AfterMethod
  public void logout()
  {
	  homepage.Logout(driver);
  }
  
  @AfterClass
  public void CloseApp() throws InterruptedException
  {
	  Thread.sleep(500);
	  closeBrowser();
  }
  
}
