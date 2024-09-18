package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[normalize-space()='REGISTER']")WebElement Register;
	@FindBy(xpath="//a[normalize-space()='SIGN-ON']")WebElement	Signin;
	@FindBy(xpath="//a[normalize-space()='SUPPORT']")WebElement support;
	@FindBy(xpath="//a[normalize-space()='CONTACT']")WebElement contact;
	@FindBy(xpath="//a[normalize-space()='Home']")WebElement Home;
	@FindBy(xpath=" //a[normalize-space()='Flights']")WebElement flights;
	@FindBy(xpath="//a[normalize-space()='Hotels']")WebElement hotels;
	@FindBy(xpath="//a[normalize-space()='Car Rentals']")WebElement carRental;
	@FindBy(xpath="//a[normalize-space()='Cruises']")WebElement cruises;
	@FindBy(xpath="//a[normalize-space()='Destinations']")WebElement destination;
	@FindBy(xpath="//a[normalize-space()='Vacations']")WebElement vacation;
	@FindBy(xpath="//input[@name='userName']")WebElement userName;
	@FindBy(xpath="//input[@name='password']")WebElement pwd;
	@FindBy(xpath="//input[@name='submit']")WebElement submit_button;
	@FindBy(xpath="//a[normalize-space()='SIGN-OFF']")WebElement sign_off;
	
	
	public void clickingRegister()
	{
		Register.click();
	}
	public void clickingsignin()
	{
		Signin.click();
	}
	public void setuserName(String uname1)
	{
		userName.sendKeys(uname1);
	}
	public void setpwd(String pwd1)
	{
		pwd.sendKeys(pwd1);
	}
	public void clickingsubmitbutton()
	{
		submit_button.click();
	}
	public void clickingflights()
	{
		flights.click();
	}
	public void clickingsign_off()
	{
		sign_off.click();
	}
}
