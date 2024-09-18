package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import PageObjects.SuccesPage;
import Testbase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(priority=1,groups={"Master","Sanity"})
	
	public void verify_account_registration()
	{
		logger.info("***************Strting TC001 _AccountRegistrationTest****************");

		try {


		HomePage hp=new HomePage( driver); //v r calling from pageObject package v created Homepage class and import up too

		hp.clickingRegister();
		
	
		logger.info("***************Clicked on MyAccount Link****************");

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
		logger.info("***************Validation Message****************");
		//where v will get ,v think, v need to give logger.info
		SuccesPage sp=new SuccesPage(driver);
		
		if ( sp.DisplaythanksRegistration() )
		{
			
			Assert.assertTrue(true);
		}
				
		else
		{
			logger.error("Test failed");
			logger.debug("Dedug logs--- ");
			Assert.assertTrue(false);
		}

		Assert.assertEquals(true, value);
		
		}
		catch(Exception e)
		{

			Assert.fail();
		}

		logger.info("**********************Finished TC001_AccountRegistrationTest*******************");
	}
	
	
	}


