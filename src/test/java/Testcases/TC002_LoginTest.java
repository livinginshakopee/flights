package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SuccesPage;
import Testbase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	public boolean value=true;
	@Test(priority=2,groups={"Master","Sanity"})
	public void Login()
	{
		logger.info("*****************String TC002Logintest**************");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickingsignin();
			hp.setuserName(p.getProperty("uname"));
			hp.setpwd(p.getProperty("password"));
			hp.clickingsubmitbutton();
		logger.info("******************Clicked Login button*************");
		SuccesPage sp=new SuccesPage(driver);
		
	//	if(confirmMSG.equals(information))
				
		if(sp.DispaysuccesfulLogin())
		{
		//	System.out.println(lp.getThanking_msg());
			Assert.assertTrue(true);;
		}
		else
		{
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		  logger.info("************I logined my Account**********");

	}


}
