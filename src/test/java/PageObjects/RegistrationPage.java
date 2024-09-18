package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@name='firstName']")WebElement fname;
	
	@FindBy(xpath="//input[@name='lastName']")WebElement lname;
	@FindBy(xpath=" //input[@name='phone']")WebElement phone_no;
	@FindBy(xpath="//input[@id='userName']")WebElement email;
	@FindBy(xpath=" //input[@name='address1']")WebElement address1;
	@FindBy(xpath=" //input[@name='city']")WebElement city;
	@FindBy(xpath="//input[@name='state']")WebElement state;
	@FindBy(xpath="//input[@name='postalCode']")WebElement postalCode;
	@FindBy(xpath="//select[@name='country']")WebElement country;
	@FindBy(xpath="//input[@id='email']")WebElement username;
	@FindBy(xpath="//input[@name='password']")WebElement pwd;
	@FindBy(xpath=" //input[@name='confirmPassword']")WebElement confirm_pwd;
	@FindBy(xpath="//input[@name='submit']")WebElement submit_button;
	@FindBy(xpath="//img[@src='images/mast_register.gif']")WebElement confirm_msg;
	
	
	public void setfname(String firstname)
	{
		fname.sendKeys(firstname);
				
	}
	public void setlname(String lastname)
	{
		lname.sendKeys(lastname);
	}
	public void setphoneno(String ph_no)
	{
		phone_no.sendKeys(ph_no);
	}
	public void setemail(String email1)
	{
		email.sendKeys(email1);
	}
	public void setaddess1(String add1)
	{
		address1.sendKeys(add1);
		
	}
	public void setcity(String city1)
	{
		city.sendKeys(city1);;
		
	}
	public void setstate(String state1)
	{
		state.sendKeys(state1);
		
	}
	public void setpostalCode(String pin_code)
	{
		postalCode.sendKeys(pin_code);
	}
	public void setcountry(String country1)
	{
		country.sendKeys(country1);;
	}
	public void setuname(String userName)
	{
		username.sendKeys(userName);
	}
	public void setpassword(String pwd1)
	{
		pwd.sendKeys(pwd1);
	}
	public void setconfirmpassword(String pwd)
	{
		 confirm_pwd.sendKeys(pwd);
	}
	public void clickingsubmit_button()
	{
		submit_button.click();
	}
	public String getconfirm_msg()
	{
		//v dont write any conditions in pageObjects classes thats why v r using try catch here.
			try {
				System.out.println(confirm_msg.getText());
				
				return(submit_button.getAccessibleName());
			}
			catch(Exception e)
			{
				return(e.getMessage());
			}
		}

		
	}
	
	
