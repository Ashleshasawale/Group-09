package neoOstockListener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Neo0StockPom.UtilityNew;
import neoOstockBase.BaseNew;




public class Listener extends BaseNew implements ITestListener {
	
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getName();
		Reporter.log("test case"+methodName+" is successfully excuted",true);
	}
	public void onTestFailure(ITestResult result) 
	{
		try {
			UtilityNew.Screenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("test case  "+result.getName()+" is failed",true);
	}

	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("test case"+result.getName()+"check it",true);
	}
}
