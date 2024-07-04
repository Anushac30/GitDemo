package Anushacompany.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Anushacompany.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	
	public WebDriver DriverInitialization() throws IOException
	{
		
		//Properties class
		Properties p= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")
				+ "//src/main//java//Anushacompany//resources//GlobalData.properties");
		p.load(fis);
		
		String browserName= System.getProperty("browser")!=null ? System.getProperty("browser") :p.getProperty("browser");
		//p.getProperty("browser")
		
		if(browserName.contains("chrome"))
		{
	
		
	// Using chromeoptions class for running the tests in head less mode
		WebDriverManager.chromedriver().setup();
		
		if(browserName.contains("headless"))
			{
			ChromeOptions options= new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);

			}

			driver = new ChromeDriver();//if you get error showing for this line then press command+shift+O to add the packages
		driver.manage().window().setSize(new Dimension(2560,1600));// to run on full screen
		 //driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			 driver= new FirefoxDriver();//if you get error showing for this line then press command+shift+O to add the packages
			
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver= new EdgeDriver();//if you get error showing for this line then press command+shift+O to add the packages
				
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		String jsoncontent = FileUtils.readFileToString(new File(filepath), 
				StandardCharsets.UTF_8);
	//String to Json change using Json databind dependency
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>> data= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){
		});
		return data;
		
		}
	
	// FOR TAKING THE SCREENSHOT
	public String getScreenShot(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir") + "//reports//"  + testcaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//"  + testcaseName + ".png";
		
	}
	
	@BeforeMethod(alwaysRun=true)// alwaysRun attribute is used to run the test irrespective of any conditions apply on the class file
    public LandingPage launchApplication() throws IOException
	{
		WebDriver driver = DriverInitialization();
        lp= new LandingPage(driver);
		lp.goTolandingurl();
		return lp;
	}
	@AfterMethod(alwaysRun=true)
	 public void closeBrowser() 
	{
		driver.close();
	}
	
}
