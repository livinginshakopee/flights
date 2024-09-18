package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SuccesPage;
import Testbase.BaseClass;
import utilities.Dataproviders;
public class TC003_LoginDDT  extends BaseClass {

	


	@Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class,groups="DataDriven")	//DataProviders class is in another package
	public void verify_loginDDT(String uname,String pwd,String exp) throws InterruptedException
	{
		try {


		logger.info("***************************starting TC003_LoginDDT Method**************");
		HomePage hp=new HomePage(driver);
	
		hp.clickingsignin();
		hp.setuserName(uname);
		hp.setpwd(pwd);
		hp.clickingsubmitbutton();
		SuccesPage sp=new SuccesPage(driver);
		boolean mylogin=sp.DispaysuccesfulLogin();
		
		//Login
		
		
		//MyAccount
		logger.info("***************Clicked on MyAccount Link****************");

		
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(mylogin)
			{
				hp.clickingsign_off();//assertion after statements doesnt execute
				Assert.assertTrue(true);

			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		logger.info("******************************this is not valid statement**********************************");
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(mylogin)
			{
				hp.clickingsign_off();;
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		
		
		
		catch(Exception e)
		{
			System.out.println (e);
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("***************************finished TC003_LoginDDT Method**************");
	}
}
