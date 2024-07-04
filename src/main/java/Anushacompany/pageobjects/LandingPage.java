package Anushacompany.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Anushacompany.Abstractmethods.abstractComponents;

public class LandingPage extends abstractComponents{
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	//
//WebElement userEmail= driver.findElement(By.id("userEmail")).sendKeys("anushac30@gmail.com");
	@FindBy(id= "userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement passwordfield;
	@FindBy(id="login")
	WebElement submit;
	
	//Error validation
	@FindBy(css = "[class*='flyInOut']")
	WebElement errormsg;
	
	
	
	public Productpage loginApplication(String email, String password)//action method to perform the operations
	{
		userEmail.sendKeys(email);
		passwordfield.sendKeys(password);
		submit.click();
		Productpage pp= new Productpage(driver);
		return pp;
	}
	
	public String getErrormessage()
	{
		 waitForWebElementToAppear(errormsg);
		
		 return errormsg.getText();
		 
	}
	
	

	public void goTolandingurl()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}
