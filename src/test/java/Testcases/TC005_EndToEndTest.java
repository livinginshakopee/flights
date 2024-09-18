package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import PageObjects.SuccesPage;
import PageObjects.FlightPage;
import Testbase.BaseClass;

public class TC005_EndToEndTest extends BaseClass {
	SoftAssert myassert=new SoftAssert();
	public boolean value=true; 
	
	
	@Test(groups={"Master","Regression"})
	
	public void FinalTest() throws IOException{
		
		logger.info("*************TC0005_EndToEndTest page Message****************");
		try
		{
		//Account Registration
			SoftAssert myassert=new SoftAssert();
	
	System.out.println("Home page Login------------------");
	HomePage hp=new HomePage(driver);
	
	hp.clickingRegister();
	
	logger.info("*************Logout page Message****************");
	
	RegistrationPage regpage=new RegistrationPage(driver); //same here too

	logger.info("***************Providing customer details****************");

	regpage.setfname(randomeString().toUpperCase());
	regpage.setlname(randomeString().toUpperCase());

	String password=randomeAlphaNumric();//if v dont assign to variable ,it can change that value in confirm password
	regpage.setpassword(password);
	regpage.setconfirmpassword(password);
	Thread.sleep(3000);
	regpage.setemail("jkdf"+randomeString()+"@gmail.com");//ramdomly generated the email
	regpage.setphoneno( randomeNumber());
	regpage.setaddess1(randomeString());
	regpage.setpostalCode(randomeNumber());
	regpage.setcity(randomeString());
	regpage.setstate(randomeString());
	Thread.sleep(3000);
	regpage.setcountry(randomeString());
	regpage.setuname(randomeString());
	regpage.setcountry(countryName());
	regpage.clickingsubmit_button();
	logger.info("***************Registered Message****************");
	//where v will get ,v think, v need to give logger.info
	SuccesPage sp=new SuccesPage(driver);
	
	if ( sp.DisplaythanksRegistration() )
	{
		
		System.out.println("the file is Registered");
		Assert.assertTrue(true);
	}
		hp.clickingsign_off();
		hp.clickingsignin();
		hp.setuserName(p.getProperty("uname"));
		hp.setpwd(p.getProperty("password"));
		hp.clickingsubmitbutton();
	logger.info("******************Clicked Login button*************");
	
	if(sp.DispaysuccesfulLogin())
	{
		System.out.println("It is loged in");
		Assert.assertTrue(true);
	}	

	Thread.sleep(3000);
	logger.info("*********************Going to Flights Page**************");
	FlightPage fp=new FlightPage(driver);
	hp.clickingflights();
	fp.clickingroundtrip();
	fp.setfromDay("12");
	fp.setfromMonth("March");
	fp.setfromPort("NEW YORK");
	fp.settoDay("24");
	fp.setpassagers("2");
	fp.settoPort("LONDON");
	fp.settoMonth("March");
	fp.setAirline("Blue Skies Airlines");
	fp.clickingEconomy();
	fp.clickingFindFlight_button();
	
	
	logger.info("******************I bookes my Flight***************");
	Thread.sleep(0);
	
	if(sp.DisplayMsg())
	{
			System.out.println("Going to logout to my my Account  ");
			myassert.assertAll();
	}
	}
		catch(Exception e)
		{
			Assert.fail();
			logger.error("this is logger error");
			System.out.println(e.getMessage());
		}
			
	}
	}	


