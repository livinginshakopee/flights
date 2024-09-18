package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.SuccesPage;
import PageObjects.FlightPage;
import Testbase.BaseClass;


public class TC004_FlightDetailsTest  extends BaseClass
{
	
	
	@Test(groups={"Master","Sanity"})
	
	public void Flights()
	{
		logger.info("*****************String TC002Logintest**************");
		try {
		
				HomePage hp=new HomePage(driver);
				hp.clickingflights();
				
				FlightPage fp=new FlightPage(driver);
				fp.clickingroundtrip();
				fp.setpassagers("2");
				fp.setfromPort("paris");
				fp.setfromMonth("March");
				fp.setfromDay("15");
				fp.settoPort("San Francisco");
				fp.settoMonth("September");
				fp.settoDay("18");
				fp.clickingEconomy();
				fp.setAirline("Blue Skies Airline");
				fp.clickingFindFlight_button();
				SuccesPage sp=new SuccesPage(driver);
				if(sp.DisplayMsg())
				{
					Assert.assertTrue(true);
				}
				else
			
				{
						logger.error("Test failed");
						logger.debug("Dedug logs--- ");
						Assert.assertTrue(false);
				}
				
		}
		catch(Exception e)
		{

			Assert.fail();
		}

		logger.info("**********************Finished TC001_AccountRegistrationTest*******************");
		
		}
		
	

}