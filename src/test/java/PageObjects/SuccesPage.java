package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccesPage extends BasePage{

	public SuccesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//font[contains(text(),'Thank you for registering.')]")WebElement thanksRegistration;
	@FindBy(xpath="//h3[normalize-space()='Login Successfully']")WebElement succesesfulLogin;
	@FindBy(xpath="//tbody/tr[@valign='top']/td/p[@align='left']/font[@face='Arial, Helvetica, sans-serif']/b/font[1]")WebElement Msg;
	public boolean DisplaythanksRegistration()
	{
		return thanksRegistration.isDisplayed();
	}
	public boolean DispaysuccesfulLogin()
	{
		return succesesfulLogin.isDisplayed();
	}
	public boolean DisplayMsg()
	{
		return Msg.isDisplayed();
	}

}
