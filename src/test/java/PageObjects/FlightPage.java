package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightPage  extends BasePage{
	
			public FlightPage(WebDriver driver) {
				super(driver);
		// TODO Auto-generated constructor stub
	}
		
			
		
		@FindBy(xpath="//input[@value='roundtrip']")WebElement roundtrip;
		@FindBy(xpath="//select[@name='passCount']")WebElement passangers;
		@FindBy(xpath=" //select[@name='fromPort']")WebElement fromPort;
		@FindBy(xpath="//select[@name='fromMonth']")WebElement fromMonth;
		@FindBy(xpath="//select[@name='fromDay']")WebElement fromDay;
		@FindBy(xpath="//select[@name='toPort']")WebElement toPort;
		@FindBy(xpath=" //select[@name='toMonth']")WebElement toMonth;
		@FindBy(xpath=" //select[@name='toDay']")WebElement toDay;
		@FindBy(xpath="//input[@value='Coach']")WebElement Economy;
		@FindBy(xpath="//input[@value='Business']")WebElement Business;
		@FindBy(xpath="//input[@value='First']")WebElement first;
		@FindBy(xpath="//select[@name='airline']")WebElement Airlines;
		@FindBy(xpath="//input[@name='findFlights']")WebElement FindFlight_button;
		@FindBy(xpath="//font[contains(text(),'Please press your browser')]")WebElement urdetails;
		
		
		
		public void clickingroundtrip()
		{
			roundtrip.click();
		}
		public void setpassagers(String passangers1)
		{
			passangers.sendKeys(passangers1);
		}
		public void setfromPort(String dep)
		{
			fromPort.sendKeys(dep);
		}
		public void setfromMonth(String mn)
		{
			fromMonth.sendKeys(mn);
		}
		public void setfromDay(String date)
		{
			fromDay.sendKeys(date);
		}
		public void settoPort(String arrive)
		{
			toPort.sendKeys(arrive);
		}
		public void settoMonth(String mn1)
		{
			toMonth.sendKeys(mn1);
		}
		public void settoDay(String day)
		{
			toDay.sendKeys(day);
		}
		public void clickingEconomy()
		{
			roundtrip.click();
		}
		public void setAirline(String Airlines1)
		{
			Airlines.sendKeys(Airlines1);
		}
		public void clickingFindFlight_button()
		{
			FindFlight_button.click();
		}
		public String geturdetails()
		{
			try {
				
				return urdetails.getText();
			}
			catch(Exception e)
			{
				return e.getMessage();
			}
			   
			
		}

	}




