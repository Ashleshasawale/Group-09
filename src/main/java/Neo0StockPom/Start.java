package Neo0StockPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Start {

	@FindBy(xpath="(//a[text()='Sign In'])[1]") private  WebElement StartButton;

public Start(WebDriver driver)

{
	PageFactory.initElements(driver, this);
}

public void Click(WebDriver driver)
{
	UtilityNew.wait(driver, 500);
	StartButton.click();
}

}
