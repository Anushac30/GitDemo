package Anushacompany.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Anushacompany.Abstractmethods.abstractComponents;

public class CheckoutPage extends abstractComponents{
	WebDriver driver;
	@FindBy(css= ".totalRow button")
	WebElement Totalrow;
	
	@FindBy(css= "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item.list-group-item.ng-star-inserted")
	List<WebElement> options;
	
	//@FindBy(xpath="//input[@placeholder='Select Country']")
	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	
	@FindBy(css= ".action__submit")
	WebElement submit;
	
	By results= By.cssSelector(".ta-results");
		
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
     public void selectdropdown(String countryName)
    {
	  //Totalrow.click();
    	 Actions a= new Actions(driver);
    	 a.sendKeys(country,countryName).build().perform();
	 // Country.sendKeys(countryName);
	  waitForElementToAppear(results);
	  selectCountry.click();
	  
	  
      
    }
      
     public ConfirmationPage submitOrder()
      {
    	  submit.click();
    	  ConfirmationPage confirmpage= new ConfirmationPage(driver);
    	  return confirmpage;
      }
     

	
				

}
