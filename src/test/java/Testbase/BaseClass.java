package Testbase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import org.apache.logging.log4j.core.config.Configurator;


public class BaseClass {
	
	
public	WebDriver driver=new ChromeDriver();
public Logger logger;
public String country;
public Properties p;

@BeforeClass(groups= {"sanity","Regression","Master"})
@Parameters({"os","browser"})
public void setup(String os,String br) throws IOException
{
	
	logger =LogManager.getLogger(this.getClass());
	PropertyConfigurator.configure("./src//test//resources//log4j.properties");
	FileReader file=new FileReader("./src//test//resources//config.properties");
	
	p=new Properties();
	p.load(file);
	if(p.getProperty("execution_env").equalsIgnoreCase("remote"));
	{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//os from xml parameters
		if(os.equalsIgnoreCase("windows"))
				{
			 capabilities.setPlatform(Platform.WIN11);
					
				}
		else if(os.equalsIgnoreCase("mac"))
		{
			 capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching os");
		}
		switch(br.toLowerCase())
		{
		case "chrome":  capabilities.setBrowserName("chrome");
		break;
		case "edge" : capabilities.setBrowserName("MicrosoftEdge");
		break;
		case "firefox": capabilities.setBrowserName("firefox");
		default :
			System.out.println("No matching browser");
			return;
		}
		
	driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	}
	if(p.getProperty("execution_env").equalsIgnoreCase("local"));
	{
		switch(br.toLowerCase())
		{
		case "chrome" : driver =new ChromeDriver();
		break;
		case "edge": driver= new EdgeDriver();
		break;
		case "firefox" :driver=new FirefoxDriver();
		break;  
		default :System.out.println("invalid browser name ....");
		return; //return will do exit from processing otherwise it will go next statement

		}
			
	}
	
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("appURL"));
	driver.manage().window().maximize();
	
	
}

@AfterClass(groups= {"sanity","Regression","Master"})
@Parameters({"os","browser"})
public void tearDown()
{
	driver.quit();
}
public String randomeString()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(6); //6 charters only generated ,ur wish
	return generatedstring;
}
public String randomeNumber()
{
	String generatednumber=RandomStringUtils.randomNumeric(10); //10  numbers on generated ,ur wish
	return generatednumber;
}
public String randomeAlphaNumric()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(3);
	String generatednumber=RandomStringUtils.randomNumeric(3); //10  numbers on generated ,ur wish
	return  (generatedstring+"-"+generatednumber);
}

public String countryName()

{
	By myzone = By.xpath("//select[@name='country']//option");
	List<WebElement> myElements = driver.findElements(myzone);
	for(WebElement e : myElements) {
	  if(e.getText().equals("UNITED STATES"))
	  {
		 country =e.getText();
		
	  }
	}	return country;	

}
public String captureScreen(String tname)throws IOException{
	String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
	File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" +tname+"_"+timeStamp+".png";

	File targetFile=new File(targetFilePath);
	sourceFile.renameTo(targetFile);
	return targetFilePath;

}

}

