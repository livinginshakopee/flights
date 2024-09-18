package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testdata\\logindetails.xlsx"; //taking xl file from Testdata
		Excelutility xlutil=new Excelutility(path); //creating an object for ExcelUtility class

		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);

		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can story

		for(int i=1; i<=totalrows; i++)//1 //read the data from xl storing in two dimensional array
		{
			for(int j=0; j<totalcols; j++) //0 //i is rows j is col
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j); //1,0

			}
		}
		return logindata;//return two dimension array
	}


	//DataProvider 2
	 //DataProvider 3
}



