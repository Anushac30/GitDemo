package Anushacompany.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Anushacompany.Abstractmethods.abstractComponents;

public class ConfirmationPage extends abstractComponents{
	WebDriver driver;
	

	
	public ConfirmationPage(WebDriver driver)
      {

		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css= ".hero-primary")
	WebElement Msg;
	 public String getConfirmationMsg()
	 {
		 return Msg.getText();
	 }
	 
	


}
